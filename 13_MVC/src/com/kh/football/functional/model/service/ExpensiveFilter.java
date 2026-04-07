package com.kh.football.functional.model.service;

import com.kh.football.functional.model.dto.Material;

public class ExpensiveFilter implements BinFilter {

	@Override
	public boolean test(Material m) {
		return m.getPrice() >= 3500;
	}

}
