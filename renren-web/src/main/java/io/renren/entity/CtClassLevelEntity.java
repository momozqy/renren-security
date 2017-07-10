package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:48
 */
public class CtClassLevelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String levelCode;
	//
	private String levelDesc;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	/**
	 * 获取：
	 */
	public String getLevelCode() {
		return levelCode;
	}
	/**
	 * 设置：
	 */
	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}
	/**
	 * 获取：
	 */
	public String getLevelDesc() {
		return levelDesc;
	}
}
