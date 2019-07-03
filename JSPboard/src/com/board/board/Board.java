package com.board.board;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.constraints.NotBlank;

public class Board {
	private int boardId;
	@NotBlank(message="제목이 빈칸입니다.")
	private String boardTitle;
	private String userId;
	private String boardDate;
	@NotBlank(message="내용이 빈칸입니다.")
	private String boardContent;
	private int boardvalid;
	
	
	
	public Board(int boardId, String boardTitle, String userId, String boardContent, int boardvalid) {
		super();
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.userId = userId;
		this.boardContent = boardContent;
		this.boardvalid = boardvalid;
		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		this.boardDate=dateFormat.format(Calendar.getInstance().getTime());
	}
	
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardTitle=" + boardTitle + ", userId=" + userId + ", boardDate="
				+ boardDate + ", boardContent=" + boardContent + ", boardvalid=" + boardvalid + "]";
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardvalid() {
		return boardvalid;
	}
	public void setBoardvalid(int boardvalid) {
		this.boardvalid = boardvalid;
	}
	
}
