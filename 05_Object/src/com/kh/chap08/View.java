package com.kh.chap08;

import java.util.Scanner;

public class View {
	private 엄마 엄마 = new 엄마(50000);
	
	public void 두부심부름시키기시뮬레이터() {
		
		while(true) {
			System.out.println("심부름을 시켜보세요~");
			System.out.println("1. 심부름시키기");
			System.out.println("2. 잔액확인");
			System.out.println("3. 종료");
			System.out.print("뭐하실래요> ");
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : 엄마.심부름시키기();
			case 2 : System.out.println(엄마.get잔돈()); break;
			case 3 : return;
			}
		}
		
		
		
	}

}
