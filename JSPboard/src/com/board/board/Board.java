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
	
	public Board() {
		super();
	}

	public Board(int boardId, String boardTitle, String userId, String boardDate, String boardContent, int boardvalid) {
		super();
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.userId = userId;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.boardvalid = boardvalid;
	}

	public Board(int boardId, String boardTitle, String userId, String boardContent, int boardvalid) {
		super();
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.userId = userId;
		this.boardContent = boardContent;
		this.boardvalid = boardvalid;
		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm");
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boardContent == null) ? 0 : boardContent.hashCode());
		result = prime * result + ((boardDate == null) ? 0 : boardDate.hashCode());
		result = prime * result + boardId;
		result = prime * result + ((boardTitle == null) ? 0 : boardTitle.hashCode());
		result = prime * result + boardvalid;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (boardContent == null) {
			if (other.boardContent != null)
				return false;
		} else if (!boardContent.equals(other.boardContent))
			return false;
		if (boardDate == null) {
			if (other.boardDate != null)
				return false;
		} else if (!boardDate.equals(other.boardDate))
			return false;
		if (boardId != other.boardId)
			return false;
		if (boardTitle == null) {
			if (other.boardTitle != null)
				return false;
		} else if (!boardTitle.equals(other.boardTitle))
			return false;
		if (boardvalid != other.boardvalid)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}
