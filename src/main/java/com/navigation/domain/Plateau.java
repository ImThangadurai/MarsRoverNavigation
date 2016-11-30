package com.navigation.domain;

public class Plateau {
	
	private Coordinates lowerCoordinates;
	private	Coordinates upperCoordinates;
	
	public Plateau(Coordinates lowerCoordinates, 
			Coordinates upperCoordinates) {
		super();
		this.lowerCoordinates = lowerCoordinates;
		this.upperCoordinates = upperCoordinates;
	}

	public Coordinates getLowerCoordinates() {
		return lowerCoordinates;
	}

	public Coordinates getUpperCoordinates() {
		return upperCoordinates;
	}
}
