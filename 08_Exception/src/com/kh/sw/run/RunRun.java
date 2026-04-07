package com.kh.sw.run;

import java.util.Scanner;

import com.kh.sw.util.SwitchUtilImpl;

public class RunRun {

	public static void main(String[] args) {
		
		boolean result = false;
		while(true) {
			System.out.println("불을 켰다 껐다");
			System.out.println("1. 불켜기");
			System.out.println("2. 종료");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			sc.nextLine();
			
			if(result) {
				System.out.println("불이 켜졌습니다.");
				
			} else {
				System.out.println("불이 꺼졌습니다.");
			}
			result = !result;
		}

	}

}
