package com.kh.football.model.vo;

import java.util.Date;
import java.util.Objects;

// Value Object
public class Board {
	private final int boardNo;			// 각 게시글을 식별할 용도의 필드
	private final String boardTitle;		// 게시글 제목을 저장할 필드
	private final String boardContent;	// 게시글 내용을 저장할 필드
	private final String boardWriter;		// 게시글 작성자를 저장할 필드
	private final String password;		// 게시글 작성 시 비밀번호를 저장할 필드
	private final String createDate;		// 게시글 작성 날짜를 저장할 필드
	public Board(int boardNo, String boardTitle, String boardContent, String boardWriter, String password,
			String createDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.password = password;
		this.createDate = createDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public String getPassword() {
		return password;
	}
	public String getCreateDate() {
		return createDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(boardContent, boardNo, boardTitle, boardWriter, createDate, password);
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
		return Objects.equals(boardContent, other.boardContent) && boardNo == other.boardNo
				&& Objects.equals(boardTitle, other.boardTitle) && Objects.equals(boardWriter, other.boardWriter)
				&& Objects.equals(createDate, other.createDate) && Objects.equals(password, other.password);
	}
	
	
	
}
