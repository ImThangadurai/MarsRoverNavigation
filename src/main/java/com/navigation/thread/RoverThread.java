package com.navigation.thread;

import com.navigation.processor.Command;
import com.navigation.util.Util;

public class RoverThread implements Runnable{
	
	private Command commandProcessor;

	private String commands;
	
	public RoverThread(Command commandProcessor,
			String commands){
		this.commandProcessor = commandProcessor;
		this.commands = commands;

	}

	public void run() {
		try{
			commandProcessor.execute(commands.toCharArray());
		}catch(Exception exception){
			Util.log(exception.getMessage());
		}
	}

}
