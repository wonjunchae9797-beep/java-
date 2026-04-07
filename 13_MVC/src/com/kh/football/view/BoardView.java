package com.kh.football.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.football.controller.BoardController;
import com.kh.football.model.dto.BoardDto;
import com.kh.football.model.vo.Board;

public class BoardView {
	private BoardController bc = new BoardController();
	private Scanner sc = new Scanner(System.in);
	
	public void boardMenu() {
		while(true) {
			System.out.println("\n\n\n\n\n");
			System.out.println();
			System.out.println("축구 이야기 게시판입니다.");
			findAll();
			System.out.println("1. 게시글 상세보기");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 수정");
			System.out.println("4. 게시글 삭제");
			System.out.println("5. 축구메뉴로 돌아가기");
			System.out.println();
			System.out.print("원하시는 메뉴를 선택해주세요 > ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : findById(); break;
			case "2" : saveBoard(); break;
			case "3" : updateBoard(); break;
			case "4" : deleteBoard(); break;
			case "5" : return;
			default : System.out.println("메뉴를 다시 선택해주세요!");
			}
		}
	}
	
	private void findAll() {
		List<Board> boards = bc.findAll();
		if(boards.isEmpty()) {
			System.out.println("=========================");
			System.out.println("아직 게시글이 존재하지 않습니다.");
			System.out.println("첫 글의 주인공이 되어보세요~~ !");
			System.out.println("=========================");
		} else {
			/*
			boards.stream()
				  .map(b -> b.getBoardNo() + " || " + 
						  	b.getBoardTitle() + " || "+
						  	b.getBoardWriter() + " || " + 
						  	b.getCreateDate())
				  .forEach(System.out::println);
				  Consumer<T> -> void
			*/
			
			System.out.println("게시글 목록 : ");
			System.out.println("---------------------------------------------------------------------------------");
			for(Board board : boards) {
				System.out.println(board.getBoardNo() + "    ||    "
								 + board.getBoardTitle() + "    ||    "
								 + board.getBoardWriter() + "    ||    "
								 + board.getCreateDate());
			}
			System.out.println("---------------------------------------------------------------------------------");
		}
	}
	
	private void findById() {
		findAll();
		System.out.print("상세보기를 하실 게시글 번호를 입력해주세요.");
		int boardNo = 0;
		try {
			boardNo = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("게시글 번호는 숫자만 입력가능합니다.");
			sc.nextLine();
			return;
		}
		Board board = bc.findById(boardNo);
		
		// 사용자가 입력한 게시글 번호
		// 경우의 수
		// -1, -2, -3...
		// 0
		// 1, 2, 3...
		while(true) {
			if(board != null) {
				// 게시글 상세정보 출력
				System.out.println("-------------------------------");
				System.out.println(boardNo + "번 게시글");
				System.out.println();
				System.out.println("제목 : ");
				System.out.println(board.getBoardTitle());
				System.out.println("-------------------------------");
				System.out.println("본문 : ");
				System.out.println(board.getBoardContent());
				System.out.println();
				System.out.println("-------------------------------");
				System.out.println("작성자 : " + board.getBoardWriter()
								  +" | 작성일 : " + board.getCreateDate());
				System.out.println("-------------------------------");
			} else {
				// board를 아예 참조를 안해버리기
				System.out.println("존재하지 않는 게시글 번호입니다.");
			}
			
			System.out.println("메뉴로 돌아가시려면 돌아가기를 입력하세요.");
			String exit = sc.nextLine();
			
			if("돌아가기".equals(exit)) {
				break;
			}
		}
	}
	
	private void saveBoard() {
		// 입력값을 뭘 받아야하지???
		// 제목, 내용, 작성자, 비밀번호
		System.out.println("게시글 작성 서비스입니다.");
		System.out.print("게시글의 제목을 입력해주세요 > ");
		String title = sc.nextLine();
		System.out.print("게시글의 내용을 입력해주세요 > ");
		String content = sc.nextLine();
		System.out.print("게시글의 작성자를 입력해주세요 > ");
		String writer = sc.nextLine();
		System.out.print("게시글의 비밀번호를 입력해주세요 > ");
		String password = sc.nextLine();
		// String[]
		// Map
		// List
		
		//bc.saveBoard(title, content, writer, password);
		/*
		new BoardDto(0, title, content, writer, password, null);
		BoardDto bd = new BoardDto();
		bd.setBoardTitle(title);
		bd.setBoardContent(content);
		bd.setBoardWriter(writer);
		bd.setPassword(password);
		*/
		bc.saveBoard(new BoardDto(title, content, writer, password));
	}
	
	private void updateBoard() {
		findAll();
		System.out.println("게시글 수정 서비스입니다.");
		System.out.print("수정하실 게시글 번호를 입력해주세요.");
		int boardNo = 0;
		try {
			boardNo = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("게시글 번호는 숫자만 가능합니다.");
			sc.nextLine();
			return;
		}
		// 1절 사용자가 0보다 작은 숫자를 입력했거나
		//     사용자가 존재하지않는 게시글번호를 입력함
		Board b = bc.findById(boardNo);
		
		// 2절 사용자에게 작성자와 비밀번호를 입력받아 일치한다면
		// 제목과 내용을 바꿔줄거임
		if(b != null) {
			System.out.print("게시글 작성자를 입력해주세요 > ");
			String writer = sc.nextLine();
			System.out.print("게시글의 비밀번호를 입력해주세요 > ");
			String password = sc.nextLine();
			System.out.print("수정할 제목을 입력해주세요 > ");
			String title = sc.nextLine();
			System.out.print("수정할 내용을 입력해주세요 > ");
			String content = sc.nextLine();
			// 넘겨야할 값의 개수 다섯개
			// 인덱스 => boardNo
			// 1번 매개변수 다섯개 만들기
			// 2번 정수 하나랑 DTO하나 만들어서 보내기
			// 3번 DTO에 매개변수 다섯개짜리 생성자만들어서 보내기
			Board updatedBoard = bc.updateBoard(boardNo, 
												new BoardDto(title, 
															 content, 
															 writer,
															 password));
			// 경우의수
			// null / 주소값
			while(true) {
				if(updatedBoard != null) {
					System.out.println("-------------------------------");
					System.out.println(boardNo + "번 게시글");
					System.out.println();
					System.out.println("제목 : ");
					System.out.println(updatedBoard.getBoardTitle());
					System.out.println("-------------------------------");
					System.out.println("본문 : ");
					System.out.println(updatedBoard.getBoardContent());
					System.out.println();
					System.out.println("-------------------------------");
					System.out.println("작성자 : " + updatedBoard.getBoardWriter()
									  +" | 작성일 : " + updatedBoard.getCreateDate());
					System.out.println("-------------------------------");
				} else {
					System.out.println("존재하지 않는 게시글 번호입니다.");
				}
				System.out.println("메뉴로 돌아가시려면 돌아가기를 입력하세요.");
				String exit = sc.nextLine();
				if("돌아가기".equals(exit)) {
					break;
				}
			}
		} else {
			System.out.println("존재하지 않는 게시글 번호입니다.");
		}
	}
	
	private void deleteBoard() {
		findAll();
		System.out.print("삭제할 게시글 번호를 입력해주세요 > ");
		int boardNo = 0;
		try {
			boardNo = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("게시글 번호는 숫자만 입력할 수 있습니다.");
			sc.nextLine();
			return;
		}
		int result = bc.deleteBoard(boardNo);
		if(result > 0) {
			System.out.println("게시글 삭제에 성공했습니다!");
		} else {
			System.out.println("게시글 삭제에 실패했습니다...");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 자바 어렵다.
	 * 이론 + 기술
	 * 
	 * 1. 일단 따라한다
	 * 2. 이게 뭐하는 거예요 -> 이해를 시키려고함   -> 이론적인 내용
	 * 
	 * 
	 * 3. 많이 반복한다
	 * 4. 생각 없이 손이 먼저 써짐                -> 체득의 과정
	 * 
	 * 목표 -> 월요일 까지는 숙제해오기
	 *     -> ★☆다음주 주말까지 CRUD하는거는 띄엄띄엄 구현할 수 있게 숙련해오기!☆★
	 */
	
	
	
	

}
