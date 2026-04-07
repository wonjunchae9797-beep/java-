package com.kh.chap03.controller;

public class CookingFactory {
	public Cooking createRice() {
		return new Rice();
	}
	public Cooking createPasta() {
		return new Pasta();
	}
	public Cooking createFired() {
		return new Fired();
	}

}
