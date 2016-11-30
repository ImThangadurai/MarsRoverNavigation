package com.navigation.processor;

import com.navaigation.exception.InvalidMoveException;
import com.navigation.domain.Coordinates;
import com.navigation.domain.Direction;
import com.navigation.domain.Plateau;
import com.navigation.domain.Rover;
import com.navigation.util.Util;

public class CommandProcessor implements Command{
	
	private Plateau plateau;
	private Rover rover;
	
	public CommandProcessor(Plateau plateau, Rover rover) {
		super();
		this.plateau = plateau;
		this.rover = rover;
	}
	
	/**
	 * Executes the command
	 */
	public void execute(char[] commands){
	
		for(char command:commands){
			if(command=='L'  || command=='l'){
				rotateLeft();
			}else if(command=='R' || command=='R'){
				rotateRight();
			}else if(command=='M' || command=='M'){
				try{
					moveForward();
				}catch(InvalidMoveException exception){
					Util.log(exception.getMessage());
				}
			}else{
				Util.log("Invalid Command");
			}
		}
		
		Util.log(rover.position());
	}
	
	/**
	 * Rotates the rover 90 degree left from the current direction
	 */
	public void rotateLeft() {
		
		if(Direction.E.equals(rover.getDirection())){
			rover.setDirection(Direction.N);
			return;
		}
		if(Direction.W.equals(rover.getDirection())){
			rover.setDirection(Direction.S);
			return;
		}
		if(Direction.N.equals(rover.getDirection())){
			rover.setDirection(Direction.W);
			return;
		}
		if(Direction.S.equals(rover.getDirection())){
			rover.setDirection(Direction.E);
			return;
		}
	}
	
	/**
	 * Rotates the rover 90 degree right from the current direction
	 */
	public void rotateRight() {
		
		if(Direction.E.equals(rover.getDirection())){
			rover.setDirection(Direction.S);
			return;
		}
		if(Direction.W.equals(rover.getDirection())){
			rover.setDirection(Direction.N);
			return;
		}
		if(Direction.N.equals(rover.getDirection())){
			rover.setDirection(Direction.E);
			return;
		}
		if(Direction.S.equals(rover.getDirection())){
			rover.setDirection(Direction.W);
			return;
		}
	}
	
	/**
	 * Moves the rover forward from the current direction and 
	 * throws an exception if the boundary reached.
	 */
	public void moveForward() throws InvalidMoveException {
		
		Coordinates currentPosition = rover.getCoordinates();
		
		if(Direction.E.equals(rover.getDirection())){
			if((currentPosition.getX()+1) > plateau.getUpperCoordinates().getX()){
				throw new InvalidMoveException("Can't move, Boundary Reached");
			}else{
				currentPosition.setX(currentPosition.getX()+1);
			}
			return;
		}
		if(Direction.W.equals(rover.getDirection())){
			if((currentPosition.getX()-1) < 0){
				throw new InvalidMoveException("Can't move, Boundary Reached");
			}else{
				currentPosition.setX(currentPosition.getX()-1);
			}
			return;
		}
		if(Direction.N.equals(rover.getDirection())){
			if((currentPosition.getY()+1) > plateau.getUpperCoordinates().getY()){
				throw new InvalidMoveException("Can't move, Boundary Reached");
			}else{
				currentPosition.setY(currentPosition.getY()+1);
			}
			return;
		}
		if(Direction.S.equals(rover.getDirection())){
			if((currentPosition.getY()-1) < 0){
				throw new InvalidMoveException("Can't move, Boundary Reached");
			}else{
				currentPosition.setY(currentPosition.getY()-1);
			}
			return;
		}
	}
}
