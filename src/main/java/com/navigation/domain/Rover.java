package com.navigation.domain;

public class Rover {

	private	Coordinates coordinates;
	private Direction direction;
	
	public Rover(Coordinates coordinates, Direction direction){
		this.coordinates = coordinates;
		this.direction = direction;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public String position(){
		
		return coordinates.toString()+" "+direction.toString();
	}
	
	
}
