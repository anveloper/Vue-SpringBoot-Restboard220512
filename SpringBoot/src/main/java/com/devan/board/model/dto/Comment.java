package com.devan.board.model.dto;

public class Comment {
	private int no;
	private int boardNo;
	private String writer;
	private String content;
	private String regDate;
	private String modiDate;

	public Comment() {
	}

	public Comment(int no, int boardNo, String writer, String content, String regDate, String modiDate) {
		this.no = no;
		this.boardNo = boardNo;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.modiDate = modiDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getModiDate() {
		return modiDate;
	}

	public void setModiDate(String modiDate) {
		this.modiDate = modiDate;
	}

	@Override
	public String toString() {
		return "comment [no=" + no + ", boardNo=" + boardNo + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", modiDate=" + modiDate + "]";
	}

}
