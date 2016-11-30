package com.navigation.test;

import org.junit.Assert;
import org.junit.Test;

import com.navigation.domain.Coordinates;
import com.navigation.domain.Direction;
import com.navigation.domain.Rover;

public class RoverTest {

	
	@Test
	public void testPosition() {
		
		Rover rover =  new Rover(new Coordinates(1, 2),Direction.valueOf("E"));
		
		Assert.assertEquals("1 2 E", rover.position());
	}
}
