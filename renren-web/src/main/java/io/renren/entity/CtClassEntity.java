package io.renren.entity;

import io.renren.entity.enums.ClassLevelEnum;
import io.renren.entity.enums.ClassTypeEnum;
import io.renren.entity.enums.StatusEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 09:14:00
 */
public class CtClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer classId;
	//
	private Integer classType;
	//课程类型名称
	private String classTypeStr;
	//
	private Integer classVersion;
	//
	private String classNameCn;
	//
	private String className;
	//
	private String classSummary;
	//
	private String author;
	//存放封面图片
	private MultipartFile frontcoverFile;
	//
	private String frontcoverUrl;
	//
	private String storageLocation;
	//状态数值
	private Integer status;
	//状态值
	private String statusStr;
	//
	private Integer sort;
	//
	private Date createdTime;
	//
	private Integer commentCount;
	//收藏数量
	private Integer keepCount;
	//
	private String frontcoversmallUrl;
	//
	private String provider;
	//
	private String kind;
	//
	private Date effectedTime;
	//
	private Date expiredTime;
	//
	private Integer price;
	//
	private String preNote;
	//
	private String midNote;
	//
	private String aftNote;
	//
	private String keyword;
	//
	private String age;
	//课程等级数值
	private Integer classLevel;
	//课程等级值
	private String classLevelStr;
	//参考译文
	private String referTranslate;
	//文化拓展
	private String cultureExpand;
	//融入生活
	private String engageLife;
	//
	private Integer seriId;
	//
	private Integer pressId;
	//
	private String mp3ZipUrl;
	//存放MP3压缩文件
	private MultipartFile mp3Zip;
	//
	private String picZipUrl;
	//存放pic压缩文件
	private MultipartFile picZip;
	//
	private Integer megagame;
	//
	private Integer gradeId;

	public MultipartFile getFrontcoverFile() {
		return frontcoverFile;
	}

	public void setFrontcoverFile(MultipartFile frontcoverFile) {
		this.frontcoverFile = frontcoverFile;
	}

	public MultipartFile getMp3Zip() {
		return mp3Zip;
	}

	public void setMp3Zip(MultipartFile mp3Zip) {
		this.mp3Zip = mp3Zip;
	}

	public MultipartFile getPicZip() {
		return picZip;
	}

	public void setPicZip(MultipartFile picZip) {
		this.picZip = picZip;
	}

	public String getClassLevelStr() {
		return classLevelStr;
	}

	public void setClassLevelStr(String classLevelStr) {
		this.classLevelStr = classLevelStr;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	/**
	 * 设置：
	 */
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	/**
	 * 获取：
	 */
	public Integer getClassId() {
		return classId;
	}
	/**
	 * 设置：
	 */
	public void setClassType(Integer classType) {
		this.classType = classType;
		this.setClassTypeStr(ClassTypeEnum.getName(classType));
	}
	/**
	 * 获取：
	 */
	public Integer getClassType() {
		return classType;
	}

	public String getClassTypeStr() {
		return classTypeStr;
	}

	public void setClassTypeStr(String classTypeStr) {
		this.classTypeStr = classTypeStr;
	}

	/**
	 * 设置：
	 */
	public void setClassVersion(Integer classVersion) {
		this.classVersion = classVersion;
	}
	/**
	 * 获取：
	 */
	public Integer getClassVersion() {
		return classVersion;
	}
	/**
	 * 设置：
	 */
	public void setClassNameCn(String classNameCn) {
		this.classNameCn = classNameCn;
	}
	/**
	 * 获取：
	 */
	public String getClassNameCn() {
		return classNameCn;
	}
	/**
	 * 设置：
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * 获取：
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * 设置：
	 */
	public void setClassSummary(String classSummary) {
		this.classSummary = classSummary;
	}
	/**
	 * 获取：
	 */
	public String getClassSummary() {
		return classSummary;
	}
	/**
	 * 设置：
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：
	 */
	public void setFrontcoverUrl(String frontcoverUrl) {
		this.frontcoverUrl = frontcoverUrl;
	}
	/**
	 * 获取：
	 */
	public String getFrontcoverUrl() {
		return frontcoverUrl;
	}
	/**
	 * 设置：
	 */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	/**
	 * 获取：
	 */
	public String getStorageLocation() {
		return storageLocation;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
		setStatusStr(StatusEnum.getName(status));
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：
	 */
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	/**
	 * 获取：
	 */
	public Integer getCommentCount() {
		return commentCount;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setKeepCount(Integer keepCount) {
		this.keepCount = keepCount;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getKeepCount() {
		return keepCount;
	}
	/**
	 * 设置：
	 */
	public void setFrontcoversmallUrl(String frontcoversmallUrl) {
		this.frontcoversmallUrl = frontcoversmallUrl;
	}
	/**
	 * 获取：
	 */
	public String getFrontcoversmallUrl() {
		return frontcoversmallUrl;
	}
	/**
	 * 设置：
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}
	/**
	 * 获取：
	 */
	public String getProvider() {
		return provider;
	}
	/**
	 * 设置：
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
	 * 获取：
	 */
	public String getKind() {
		return kind;
	}
	/**
	 * 设置：
	 */
	public void setEffectedTime(Date effectedTime) {
		this.effectedTime = effectedTime;
	}
	/**
	 * 获取：
	 */
	public Date getEffectedTime() {
		return effectedTime;
	}
	/**
	 * 设置：
	 */
	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}
	/**
	 * 获取：
	 */
	public Date getExpiredTime() {
		return expiredTime;
	}
	/**
	 * 设置：
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * 设置：
	 */
	public void setPreNote(String preNote) {
		this.preNote = preNote;
	}
	/**
	 * 获取：
	 */
	public String getPreNote() {
		return preNote;
	}
	/**
	 * 设置：
	 */
	public void setMidNote(String midNote) {
		this.midNote = midNote;
	}
	/**
	 * 获取：
	 */
	public String getMidNote() {
		return midNote;
	}
	/**
	 * 设置：
	 */
	public void setAftNote(String aftNote) {
		this.aftNote = aftNote;
	}
	/**
	 * 获取：
	 */
	public String getAftNote() {
		return aftNote;
	}
	/**
	 * 设置：
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * 获取：
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * 设置：
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * 获取：
	 */
	public String getAge() {
		return age;
	}
	/**
	 * 设置：
	 */
	public void setClassLevel(Integer classLevel) {
		this.classLevel = classLevel;
		setClassLevelStr(ClassLevelEnum.getName(classLevel));
	}
	/**
	 * 获取：
	 */
	public Integer getClassLevel() {
		return classLevel;
	}
	/**
	 * 设置：参考译文
	 */
	public void setReferTranslate(String referTranslate) {
		this.referTranslate = referTranslate;
	}
	/**
	 * 获取：参考译文
	 */
	public String getReferTranslate() {
		return referTranslate;
	}
	/**
	 * 设置：文化拓展
	 */
	public void setCultureExpand(String cultureExpand) {
		this.cultureExpand = cultureExpand;
	}
	/**
	 * 获取：文化拓展
	 */
	public String getCultureExpand() {
		return cultureExpand;
	}
	/**
	 * 设置：融入生活
	 */
	public void setEngageLife(String engageLife) {
		this.engageLife = engageLife;
	}
	/**
	 * 获取：融入生活
	 */
	public String getEngageLife() {
		return engageLife;
	}
	/**
	 * 设置：
	 */
	public void setSeriId(Integer seriId) {
		this.seriId = seriId;
	}
	/**
	 * 获取：
	 */
	public Integer getSeriId() {
		return seriId;
	}
	/**
	 * 设置：
	 */
	public void setPressId(Integer pressId) {
		this.pressId = pressId;
	}
	/**
	 * 获取：
	 */
	public Integer getPressId() {
		return pressId;
	}
	/**
	 * 设置：
	 */
	public void setMp3ZipUrl(String mp3ZipUrl) {
		this.mp3ZipUrl = mp3ZipUrl;
	}
	/**
	 * 获取：
	 */
	public String getMp3ZipUrl() {
		return mp3ZipUrl;
	}
	/**
	 * 设置：
	 */
	public void setPicZipUrl(String picZipUrl) {
		this.picZipUrl = picZipUrl;
	}
	/**
	 * 获取：
	 */
	public String getPicZipUrl() {
		return picZipUrl;
	}
	/**
	 * 设置：
	 */
	public void setMegagame(Integer megagame) {
		this.megagame = megagame;
	}
	/**
	 * 获取：
	 */
	public Integer getMegagame() {
		return megagame;
	}
	/**
	 * 设置：
	 */
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	/**
	 * 获取：
	 */
	public Integer getGradeId() {
		return gradeId;
	}
}
