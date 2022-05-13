package com.devan.board.model.dto;

public class User {
	private int seq;
	private String userId;
	private String password;
	private String userName;
	private String joinDate;

	public User() {
	}

	public User(int seq, String userId, String password, String userName, String joinDate) {
		this.seq = seq;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.joinDate = joinDate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "User [seq=" + seq + ", userId=" + userId + ", password=" + password + ", userName=" + userName
				+ ", joinDate=" + joinDate + "]";
	}

}
