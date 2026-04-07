package com.kh.football.controller;

import java.util.List;

import com.kh.football.model.dto.BoardDto;
import com.kh.football.model.service.BoardService;
import com.kh.football.model.vo.Board;

public class BoardController {
	private BoardService bs = new BoardService();
	
	public List<Board> findAll() {
		return bs.findAll();
	}
	// 지인짜 다배우면 컨트롤러에서 숫자 이거 1보다 큰거 맞아??
	public Board findById(int boardNo) {
		return bs.findById(boardNo);
	}
	
	public void saveBoard(BoardDto board) {
		bs.saveBoard(board);
	}
	
	// 1번 나는 성공실패여부를 View에 출력해 줄것이다
	// 2나는 업데이트에 성공한 Board 필드값을 출력해 줄 것이다.
	public Board updateBoard(int boardNo, BoardDto board) {
		return bs.updateBoard(boardNo, board);
	}
	
	public int deleteBoard(int boardNo) {
		return bs.deleteBoard(boardNo);
	}

}
