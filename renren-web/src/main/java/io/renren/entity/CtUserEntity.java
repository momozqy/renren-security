package io.renren.entity;

import io.renren.entity.enums.UserTypeEnum;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:28
 */
public class CtUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long userId;
	//
	private String userName;
	//
	private String password;
	//1 普通用户 2 付费用户 4 学校用户
	private Integer type;
	//用户类型名称
	private String typeStr;
	//0：未激活1：激活  默认为未激活
	private Integer status;
	//
	private String trueName;
	//
	private String nickname;
	//0：男 1：女
	private Integer sex;
	//
	private Integer age;
	//0：身份证 1：军官证2：学生证 3：车本
	private Integer cardType;
	//
	private String cardNumber;
	//
	private String city;
	//
	private String pic;
	//
	private String picSmall;
	//
	private String tel;
	//
	private String mobile;
	//
	private Date regTime;
	//
	private Date activeTime;
	//
	private String remark;
	//家长限制0：无限制
            
	private Integer parentsLimit;
	//
	private String deviceId;
	//
	private String inviteCode;
	//
	private Integer studentId;
	//
	private String level;
	//
	private String openId;

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
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：1 普通用户
            2 付费用户
            4 学校用户
	 */
	public void setType(Integer type) {
		this.type = type;
		this.setTypeStr(UserTypeEnum.getName(type));
	}
	/**
	 * 获取：1 普通用户
            2 付费用户
            4 学校用户
	 */
	public Integer getType() {
		return type;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	/**
	 * 设置：0：未激活
            1：激活
            默认为未激活
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：0：未激活
            1：激活
            默认为未激活
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	/**
	 * 获取：
	 */
	public String getTrueName() {
		return trueName;
	}
	/**
	 * 设置：
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：0：男
            1：女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：0：男
            1：女
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：0：身份证
            1：军官证
            2：学生证
            3：车本
	 */
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	/**
	 * 获取：0：身份证
            1：军官证
            2：学生证
            3：车本
	 */
	public Integer getCardType() {
		return cardType;
	}
	/**
	 * 设置：
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * 获取：
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * 设置：
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * 设置：
	 */
	public void setPicSmall(String picSmall) {
		this.picSmall = picSmall;
	}
	/**
	 * 获取：
	 */
	public String getPicSmall() {
		return picSmall;
	}
	/**
	 * 设置：
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	/**
	 * 获取：
	 */
	public Date getRegTime() {
		return regTime;
	}
	/**
	 * 设置：
	 */
	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}
	/**
	 * 获取：
	 */
	public Date getActiveTime() {
		return activeTime;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：家长限制
            0：无限制
            
	 */
	public void setParentsLimit(Integer parentsLimit) {
		this.parentsLimit = parentsLimit;
	}
	/**
	 * 获取：家长限制
            0：无限制
            
	 */
	public Integer getParentsLimit() {
		return parentsLimit;
	}
	/**
	 * 设置：
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：
	 */
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
	/**
	 * 获取：
	 */
	public String getInviteCode() {
		return inviteCode;
	}
	/**
	 * 设置：
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：
	 */
	public Integer getStudentId() {
		return studentId;
	}
	/**
	 * 设置：
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 获取：
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * 设置：
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：
	 */
	public String getOpenId() {
		return openId;
	}
}
