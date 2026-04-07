package com.kh.football.model.domain;

public class BackNumber {
	private Integer backNumber;
	
	public BackNumber(Integer backNumber) {
		this.backNumber = backNumber;
	}
	
	public static void validateNumber(Integer backNumber) {
		if(backNumber == null) {
			throw new RuntimeException("등번호가 입력 안됨!");
		}
		if(backNumber < 0) {
			throw new RuntimeException("유효하지 않은 등번호!");
		}
	}

}
