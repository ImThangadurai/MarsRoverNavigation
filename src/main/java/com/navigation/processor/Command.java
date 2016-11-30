package com.navigation.processor;

import com.navaigation.exception.InvalidMoveException;

public interface Command {
	
	void execute(char[] commands);
	void rotateLeft();
	void rotateRight();
	void moveForward() throws InvalidMoveException;

}
