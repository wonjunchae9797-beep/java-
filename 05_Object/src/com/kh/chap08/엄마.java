package com.kh.chap08;

public class 엄마 {
	private int cash;
	private 자녀 자녀 = new 자녀();
	
	public 엄마(int cash) {
		this.cash = cash;
	}
	
	public void 심부름시키기() {
		int 잔돈 = 자녀.심부름하기(cash);
		cash = 잔돈;
	}
	
	public int get잔돈() {
		return cash;
	}

}
