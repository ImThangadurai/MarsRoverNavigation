package com.navigation.test;

import org.junit.Assert;
import org.junit.Test;

import com.navaigation.exception.InvalidMoveException;
import com.navigation.domain.Coordinates;
import com.navigation.domain.Direction;
import com.navigation.domain.Plateau;
import com.navigation.domain.Rover;
import com.navigation.processor.CommandProcessor;
import com.navigation.processor.Command;

public class CommandProcessorTest {

	@Test
	public void rotateLeftTest() {
		Plateau plateau = new Plateau(new Coordinates(0, 0),new Coordinates(6, 6));
		Rover rover =  new Rover(new Coordinates(0,0),Direction.valueOf("E"));
		String commands = "L";
		Command commandProcessor = new CommandProcessor(plateau,rover);
		commandProcessor.execute(commands.toCharArray());
		
		Assert.assertEquals("0 0 N", rover.position());
	}
	
	@Test
	public void rotateRightTest() {
		Plateau plateau = new Plateau(new Coordinates(0, 0),new Coordinates(6, 6));
		Rover rover =  new Rover(new Coordinates(0,0),Direction.valueOf("E"));
		String commands = "R";
		Command commandProcessor = new CommandProcessor(plateau,rover);
		commandProcessor.execute(commands.toCharArray());
		Assert.assertEquals("0 0 S", rover.position());
	}
	
	@Test
	public void moveForwardTest() {
		Plateau plateau = new Plateau(new Coordinates(0, 0),new Coordinates(6, 6));
		Rover rover =  new Rover(new Coordinates(0,0),Direction.valueOf("E"));
		String commands = "M";
		Command commandProcessor = new CommandProcessor(plateau,rover);
		commandProcessor.execute(commands.toCharArray());
		Assert.assertEquals("1 0 E", rover.position());
	}
	
	@Test
	public void moveForwardEastBoundaryTest() {
		Plateau plateau = new Plateau(new Coordinates(0, 0),new Coordinates(6, 6));
		Rover rover =  new Rover(new Coordinates(0,0),Direction.valueOf("E"));
		
		boolean thrown=false;
		try{
			Command commandProcessor = new CommandProcessor(plateau,rover);
			for(int i=0;i<7;i++){
				commandProcessor.moveForward();
			}
		}catch(InvalidMoveException ime){
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	
	@Test
	public void moveForwardWestBoundaryTest() {
		Plateau plateau = new Plateau(new Coordinates(0, 0),new Coordinates(6, 6));
		Rover rover =  new Rover(new Coordinates(0,0),Direction.valueOf("W"));
		
		boolean thrown=false;
		try{
			Command commandProcessor = new CommandProcessor(plateau,rover);
			for(int i=0;i<1;i++){
				commandProcessor.moveForward();
			}
		}catch(InvalidMoveException ime){
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	
	@Test
	public void moveForwardNorthBoundaryTest() {
		Plateau plateau = new Plateau(new Coordinates(0, 0),new Coordinates(6, 6));
		Rover rover =  new Rover(new Coordinates(0,0),Direction.valueOf("N"));
		
		boolean thrown=false;
		try{
			Command commandProcessor = new CommandProcessor(plateau,rover);
			for(int i=0;i<7;i++){
				commandProcessor.moveForward();
			}
		}catch(InvalidMoveException ime){
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	
	@Test
	public void moveForwardSouthBoundaryTest() {
		Plateau plateau = new Plateau(new Coordinates(0, 0),new Coordinates(6, 6));
		Rover rover =  new Rover(new Coordinates(0,0),Direction.valueOf("S"));
		
		boolean thrown=false;
		try{
			Command commandProcessor = new CommandProcessor(plateau,rover);
			for(int i=0;i<1;i++){
				commandProcessor.moveForward();
			}
		}catch(InvalidMoveException ime){
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	
	@Test
	public void executeTest() {
		Plateau plateau = new Plateau(new Coordinates(0, 0),new Coordinates(5, 5));
		Rover rover =  new Rover(new Coordinates(3,3),Direction.valueOf("E"));
		String commands = "MMRMMRMRRM";
		Command commandProcessor = new CommandProcessor(plateau,rover);
		commandProcessor.execute(commands.toCharArray());
		Assert.assertEquals("5 1 E", rover.position());
	}

}
