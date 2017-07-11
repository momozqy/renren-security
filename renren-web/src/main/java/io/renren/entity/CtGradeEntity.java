package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-11 16:22:58
 */
public class CtGradeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//组别ID
	private Integer id;
	//
	private String gradeId;
	//组别名字
	private String gradeName;

	/**
	 * 设置：组别ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：组别ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	/**
	 * 获取：
	 */
	public String getGradeId() {
		return gradeId;
	}
	/**
	 * 设置：组别名字
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	/**
	 * 获取：组别名字
	 */
	public String getGradeName() {
		return gradeName;
	}
}
