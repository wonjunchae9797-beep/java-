package com.kh.chap02.encapsulation.run;

import java.util.Scanner;

import com.kh.chap02.encapsulation.model.vo.AutoSellingMachine;

public class Run {
	// 캡슐화 (encapsulation)
	// 속성(데이터)과 해당 데이터를 조작하는 행동(메소드)를 하나의 단위로 묶는 것
	// 정보은닉(information hiding)

	public static void main(String[] args) {
									// 객체 생성 == 메모리(heap)에 적재
		AutoSellingMachine asm = new AutoSellingMachine();
		// asm.hi();
		// new AutoSellingMachine().hi();
		// 변수 공간에 대입될 수 있는 값은 딱 9가지(null값 제외)
		// boolean리터럴값, char리터럴값, byte리터럴값, short리터럴값, int리터럴값, long리터럴값
		// float리터럴값, double리터럴값
		// 주소값 == 아 이거 객체다!
		/*
		asm.name = "삼양라면";
		//asm.abc = "없는데?";
		System.out.println(asm.name);
		asm.price = 1100;
		System.out.println(asm.price);
		asm.amount = 0;
		System.out.println(asm.amount); // 아쉬워라
		*/
		/*
		asm.재고확인하기();
		asm.재고채우기();
		asm.제품판매하기();
		asm.재고확인하기();
		*/
		// asm.openMachine();
		
		// 필드가 외부에서는 보이지 않아서 오류가 발생!
		// 접근제한자를 public에서 private으로 변경했기 때문!
		// 직접접근이 불가능 => 간접적으로 접근할 수 있는 방법을 만들어주어야함
		
		// getter / setter라는 메소드 구현하기
		// asm.checkAmount();
		// 라면 가격 1500으로 세팅하고싶다.
		asm.setPrice(1500);
				// argument, 인자값, 인수
		// asm.setPrice();
		// System.out.println(asm);
		// 비유
		// 초등학생
		// int 거스름돈 = asm.두부사오기(10000);
		// System.out.println(거스름돈);
		// asm.두부사오기();
		asm.setName("삼양라면");
		asm.setAmount(5);
		// 흠 나는 이렇게 하나하나 필드값을 전달하는 것이 아니라
		// 한번에 여러 개의 값을 전달하고 한 번에 필드값을 대입하고 싶은데???
		// asm.setPriceAndAmount(1000, 5);
		
		// 함수 == BuiltInFunction 
		// 자바의 클래스 == 자료형
		// 메소드 == 특정 자료형만 수행할 수 있는 기능
		// new AutoSellingMachine();
		// System.out.println(asm.getName());
		String name = asm.getName();
		
		Scanner sc = new Scanner(System.in);
		// String str = sc.nextLine();
		
		System.out.println(name);

		// asm.d();
		int amount = asm.getAmount();
		System.out.println(amount);
		
		int price = asm.getPrice();
		System.out.println(price);
		
		
		System.out.println("자판기 = [제품명 : " + name + ", 가격 : " + price + ", 재고 : " + amount + "]");
		String info = asm.info();
		System.out.println(info);
		
	}
	
	
	
	
	
	
	
	

}
