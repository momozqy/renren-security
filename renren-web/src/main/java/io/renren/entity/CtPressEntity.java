package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:28
 */
public class CtPressEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String pressCode;
	//
	private String pressName;

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
	public void setPressCode(String pressCode) {
		this.pressCode = pressCode;
	}
	/**
	 * 获取：
	 */
	public String getPressCode() {
		return pressCode;
	}
	/**
	 * 设置：
	 */
	public void setPressName(String pressName) {
		this.pressName = pressName;
	}
	/**
	 * 获取：
	 */
	public String getPressName() {
		return pressName;
	}
}
