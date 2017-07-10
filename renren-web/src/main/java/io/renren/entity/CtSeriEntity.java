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
public class CtSeriEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer seriId;
	//系列名字
	private String seriName;

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
	 * 设置：系列名字
	 */
	public void setSeriName(String seriName) {
		this.seriName = seriName;
	}
	/**
	 * 获取：系列名字
	 */
	public String getSeriName() {
		return seriName;
	}
}
