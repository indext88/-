package com.gxa.pojo;

import java.util.Date;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
public class UserInfo extends SeckillObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1056818541690168710L;

	private int userId;
	private String userName; // 用户名
	private String userPwd; // 密码
	private String userEmail; // 用户E-mail
	private String userPhone; // 用户电话
	private Date lastLoginTime; // 用户登录时间
	private Date registTime; // 注册时间

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail="
				+ userEmail + ", userPhone=" + userPhone + ", lastLoginTime=" + lastLoginTime + ", registTime="
				+ registTime + "]";
	}

	public UserInfo(int userId, String userName, String userPwd, String userEmail, String userPhone, Date lastLoginTime,
			Date registTime) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.lastLoginTime = lastLoginTime;
		this.registTime = registTime;
	}

	public UserInfo() {

	}

}
