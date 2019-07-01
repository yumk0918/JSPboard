package com.board.board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Board {
	private int bId;
	@NotBlank(message="제목이 빈칸입니다.")
	private String bTitle;
	private String userId;
	private String bDate;
	@NotBlank(message="내용이 빈칸입니다.")
	private String bContent;
	private int bcheck;
	
	@Override
	public String toString() {
		return "Board [bId=" + bId + ", bTitle=" + bTitle + ", userId=" + userId + ", bDate=" + bDate + ", bContent="
				+ bContent + ", bcheck=" + bcheck + "]";
	}
	
	public Board() {
		super();
	}

	public Board(int bId, String bTitle, String userId, String bDate, String bContent, int bcheck) {
		super();
		this.bId = bId;
		this.bTitle = bTitle;
		this.userId = userId;
		this.bDate = bDate;
		this.bContent = bContent;
		this.bcheck = bcheck;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public int getBcheck() {
		return bcheck;
	}

	public void setBcheck(int bcheck) {
		this.bcheck = bcheck;
	}
	

}
