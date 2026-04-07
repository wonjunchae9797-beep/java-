package com.kh.football.model.domain;

public class FootballPlayer {
	private String name;
	private String position;
	private BackNumber backNumber;
	
	public FootballPlayer(String name, String position, BackNumber backNumber) {
		super();
		this.name = name;
		this.position = position;
		this.backNumber = backNumber;
	}

	public static FootballPlayer createPlayer(String name,
												String position,
												Integer backNumber) {
		BackNumber.validateNumber(backNumber);
		return new FootballPlayer(name,
								  position,
								  new BackNumber(backNumber));	
	}

}
