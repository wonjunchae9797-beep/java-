package com.kh.chap04.model.service;

import java.util.HashMap;

public class HongkongHouse extends Test implements CookingSkill, CookingSkillI {
	@Override
	public void makeDopbap() { 
		System.out.println("홍콩식 치킨 덮밥만들기");
	}
}