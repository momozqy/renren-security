package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-08-09 15:03:41
 */
public class CtUserClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long userId;
	//
	private Integer classId;
	//
	private Integer userType;
	//
	private Date createdtime;
	//0:删除 1：增加
	private Integer operType;

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
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
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	/**
	 * 获取：
	 */
	public Integer getUserType() {
		return userType;
	}
	/**
	 * 设置：
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedtime() {
		return createdtime;
	}
	/**
	 * 设置：0:删除 1：增加
	 */
	public void setOperType(Integer operType) {
		this.operType = operType;
	}
	/**
	 * 获取：0:删除 1：增加
	 */
	public Integer getOperType() {
		return operType;
	}
}
