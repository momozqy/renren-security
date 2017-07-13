package io.renren.service.impl;

import io.renren.dao.CtClassDao;
import io.renren.entity.CtClassEntity;
import io.renren.entity.enums.StatusEnum;
import io.renren.service.CtClassService;
import io.renren.utils.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service("ctClassService")
public class CtClassServiceImpl implements CtClassService {
	@Autowired
	private CtClassDao ctClassDao;
	
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
	public void save(CtClassEntity ctClass) throws IOException{
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
	}
	
	@Override
	public void update(CtClassEntity ctClass){
		ctClassDao.update(ctClass);
	}
	
	@Override
	public void delete(Integer classId){
		ctClassDao.delete(classId);
	}
	
	@Override
	public void deleteBatch(Integer[] classIds){
		ctClassDao.deleteBatch(classIds);
	}
	
}
