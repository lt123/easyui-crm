package com.lt.crm.model;

import java.util.Date;

public class User {
	private Long id;
	private String username;
	private String password;
	private String email;
	private Integer age;
	/**
	 * 1 男 2 女
	 */
	private Integer sex = 1;
	
	/**
	 * 用户的录入时间
	 */
	private Date inputTime = new Date();
	
	/**
	 * -1 离职
	 * 1   正常
	 */
	private Integer status=1;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", age=" + age + ", sex="
				+ sex + ", inputTime=" + inputTime + ", status=" + status
				+ ", loginIp=" + loginIp + ", loginTime=" + loginTime
				+ ", lastLoginIp=" + lastLoginIp + ", lastLoginTime="
				+ lastLoginTime + "]";
	}
	private String loginIp;//本次登录IP
	private Date loginTime;//本次登录时间
	
	private String lastLoginIp;//上次登录IP
	private Date lastLoginTime;//上次登录时间
	
	public Date getInputTime() {
		return inputTime;
	}
	public User setInputTime(Date inputTime) {
		this.inputTime = inputTime;
		return this;
	}
	public Integer getStatus() {
		return status;
	}
	public User setStatus(Integer status) {
		this.status = status;
		return this;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public User setLoginIp(String loginIp) {
		this.loginIp = loginIp;
		return this;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public User setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
		return this;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public User setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
		return this;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public User setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		return this;
	}
	
	public Long getId() {
		return id;
	}
	public User setId(Long id) {
		this.id = id;
		return this;
	}
	public String getUsername() {
		return username;
	}
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	public Integer getAge() {
		return age;
	}
	public User setAge(Integer age) {
		this.age = age;
		return this;
	}
	public Integer getSex() {
		return sex;
	}
	public User setSex(Integer sex) {
		this.sex = sex;
		return this;
	}
	
}
