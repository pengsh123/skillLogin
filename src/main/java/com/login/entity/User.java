package com.login.entity;

public class User {
	private String id;
	private String userName;
	private String pwd;
	private String tel;
	private float money;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public User(String id, String userName, String pwd, String tel, float money) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.tel = tel;
		this.money = money;
	}

	public User() {
		super();
	}

}
