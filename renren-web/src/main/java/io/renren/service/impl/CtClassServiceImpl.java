package io.renren.service.impl;

import io.renren.dao.CtClassDao;
import io.renren.dao.CtUserClassDao;
import io.renren.entity.CtClassEntity;
import io.renren.entity.LessonJson;
import io.renren.entity.enums.StatusEnum;
import io.renren.service.CtClassService;
import io.renren.utils.SystemProperties;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.nuxeo.common.utils.ZipUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@Service("ctClassService")
public class CtClassServiceImpl implements CtClassService {
	@Autowired
	private CtClassDao ctClassDao;
	@Autowired
	CtUserClassDao ctUserClassDao;

	@Override
	public CtClassEntity queryObject(Integer classId){
		return ctClassDao.queryObject(classId);
	}
	
	@Override
	public List<CtClassEntity> queryList(Map<String, Object> map){
		return ctClassDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ctClassDao.queryTotal(map);
	}
	
	@Override
	public void save(CtClassEntity ctClass) throws Exception{
		String uuid = UUID.randomUUID().toString();
		String uuidTime = String.valueOf(System.currentTimeMillis());
		String frontcoverUrl = File.separator + uuid + ".png";
		String picZipUrl = File.separator + uuidTime + File.separator + uuid + "-pic.zip";
		String mp3ZipUrl = File.separator + uuidTime + File.separator + uuid + "-audio.zip";
		File picZip = new File(SystemProperties.ZIP_MP3_DIR+picZipUrl);
		File mp3Zip = new File(SystemProperties.ZIP_PIC_DIR+mp3ZipUrl);
		if(!picZip.exists()){
			picZip.mkdirs();
		}
		if(!mp3Zip.exists()){
			mp3Zip.mkdirs();
		}
		ctClass.getFrontcoverFile().transferTo(new File(SystemProperties.PIC_DIR+frontcoverUrl));
		ctClass.getMp3Zip().transferTo(mp3Zip);
		ctClass.getPicZip().transferTo(picZip);
		ctClass.setFrontcoverUrl(frontcoverUrl);
		ctClass.setMp3ZipUrl(mp3ZipUrl);
		ctClass.setPicZipUrl(picZipUrl);
		ctClass.setStatus(StatusEnum.PUBLISH.getIndex());
		ctClass.setCreatedTime(new Date());
		ctClass.setClassVersion(1);
		ctClass.setSort(1);
		ctClassDao.save(ctClass);

		//把压缩包复制到临时文件
        File tempPic = new File(SystemProperties.TEMP_DIR + File.separator + ctClass.getPicZipUrl());
        File tempMp3 = new File(SystemProperties.TEMP_DIR + File.separator + ctClass.getMp3ZipUrl());
        FileUtils.copyFile(picZip,tempPic);
        FileUtils.copyFile(mp3Zip,tempMp3);
		//解压临时文件
		ZipUtils.unzip(picZip,tempPic.getParentFile());
		ZipUtils.unzip(mp3Zip,tempMp3.getParentFile());

		// 获取picture 和 audio 目录
		File[] files = tempPic.getParentFile().listFiles();
		File mainMp3 = null;
		File mainPic = null;
		List<File> pics = new ArrayList<File>();
		List<File> audios = new ArrayList<File>();
		for(File file : files){
			File picDir = new File(
					SystemProperties.STORAGE_DIR  + File.separator + "picture" + File.separator + ctClass.getClassId() + File.separator + "picture");
			File audioDir = new File(
					SystemProperties.STORAGE_DIR + File.separator + "picture" + File.separator + ctClass.getClassId() + File.separator + "audio");

			if (!picDir.exists()) {
				picDir.mkdirs();
			}

			if (!audioDir.exists()) {
				audioDir.mkdirs();
			}
			if (file.getName().equals("picture") && file.isDirectory()) {
				File fP = new File(SystemProperties.PIC_DIR + File.separator + ctClass.getFrontcoverUrl());
				// 拷贝封面到picture目录下
				FileUtils.copyFileToDirectory(fP, file);

				for (File pic : file.listFiles()) {
					File newfile = null;
					if (pic.getName().endsWith(".png")) {
						// 如果是首页
						if (pic.getName().equals(fP.getName())) {
							newfile = new File(pic.getAbsolutePath().replaceAll(fP.getName(), "main@2x.png"));
							pic.renameTo(newfile);
							mainPic = newfile;
							continue;
						} else {// 如果不是首页
							newfile = new File(pic.getAbsolutePath().replaceAll(".png", "@2x.png"));
							// 在pic改名字前存一份
							pic.renameTo(newfile);
							FileUtils.copyFileToDirectory(newfile, picDir);
						}
					}
					if (newfile == null) {
						continue;
					}
					if (newfile.getName().endsWith(".png")) {
						pics.add(newfile);
					}
				}
			} else if (file.getName().equals("audio") && file.isDirectory()) {
				for (File audio : file.listFiles()) {
					if (audio.getName().equals("main.mp3")) {
						mainMp3 = audio;
					} else if (audio.getName().endsWith(".mp3")) {
						audios.add(audio);
					}
					FileUtils.copyFileToDirectory(audio, audioDir);
				}
			}
		}
		List<String> picNames = new ArrayList<String>();
		List<String> audioNames = new ArrayList<String>();
		for (int ii = 0; ii < pics.size(); ii++) {
			picNames.add(pics.get(ii).getName());
			if (audios.size() > ii) {
				audioNames.add(audios.get(ii).getName());
			} else {
				audioNames.add(ii + ".unkonwn.mp3");
			}
		}
        sort(picNames,audioNames);
		if (null != mainMp3) {
			audioNames.add(mainMp3.getName());
		}
		if (null != mainPic) {
			picNames.add(mainPic.getName());
		}
        preseJson(ctClass, tempPic.getParentFile().getPath(), picNames, audioNames);
		tempMp3.delete();
		tempPic.delete();
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(SystemProperties.STORAGE_DIR + File.separator + ctClass.getClassId() + ".zip"));
		this.zip(out, tempPic.getParentFile(), "");
		out.close();
		FileUtils.deleteDirectory(tempPic.getParentFile());
	}
	
	@Override
	public void update(CtClassEntity ctClass){
		ctClassDao.update(ctClass);
	}
	
	@Override
	public void delete(Integer classId){
		//增加删除课程用户关联表
		ctUserClassDao.delete(classId);
		ctClassDao.delete(classId);
	}
	
	@Override
	public void deleteBatch(Integer[] classIds){
		ctClassDao.deleteBatch(classIds);
	}

	public static void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			in.close();
		}

	}
    class CompareClass implements Comparator<String> {
        private String type;

        @Override
        public int compare(String o1, String o2) {
            String str1 = o1.substring(0, o1.indexOf(this.type));
            String str2 = o2.substring(0, o2.indexOf(this.type));
            int flag = 1;
            if (Integer.valueOf(str1) < Integer.valueOf(str2)) {
                flag = -1;
            }
            return flag;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }
	public void sort(List<String> pics,List<String> audios){
        CompareClass compareClass = new CompareClass();
        compareClass.setType("@");
        Collections.sort(pics, compareClass);
        compareClass.setType(".");
        Collections.sort(audios, compareClass);
	}

    private static void preseJson(CtClassEntity ctClass, String jsonPath, List<String> picNames, List<String> audioNames)
            throws UnsupportedEncodingException, IOException {
        LessonJson lessonJson = new LessonJson();
        lessonJson.setAudio(audioNames.toArray(new String[0]));
        lessonJson.setPicture(picNames.toArray(new String[0]));
        lessonJson.genReadingGuide(ctClass.getAge(), ctClass.getClassName(), ctClass.getClassNameCn(),
                ctClass.getAuthor(), ctClass.getFrontcoverUrl(), ctClass.getClassSummary(), ctClass.getPreNote(),
                ctClass.getMidNote(), ctClass.getAftNote(), ctClass.getKeyword(), ctClass.getReferTranslate(),
                ctClass.getCultureExpand(), ctClass.getEngageLife());
        File jsontext = new File(jsonPath + File.separator + "text" + File.separator + "info.json");
        if (!jsontext.getParentFile().exists()) {
            jsontext.getParentFile().mkdirs();
        }
        OutputStream os = new FileOutputStream(jsontext);
        os.write(JSONObject.fromObject(lessonJson).toString().getBytes("utf-8"));
        os.close();
    }
}
