package com.navigation.thread;

import java.util.Scanner;

import com.navigation.domain.Coordinates;
import com.navigation.domain.Direction;
import com.navigation.domain.Plateau;
import com.navigation.domain.Rover;
import com.navigation.processor.CommandProcessor;
import com.navigation.processor.Command;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=null;
		try{
			
			scanner = new Scanner(System.in);
			
			String upperCooridinates = scanner.nextLine();
			String[] array = upperCooridinates.split("\\s");
			Plateau plateau =null;
			try{
				if(array.length ==2){
					plateau = new Plateau(new Coordinates(0, 0), new Coordinates(Integer.parseInt(array[0]), 
																					Integer.parseInt(array[1])));
				}else{
					System.out.println("Invalid Input - "+upperCooridinates);
					return;
				}
			}catch(NumberFormatException nfe){
				System.out.println("Invalid Input - "+upperCooridinates);
				return;
			}
			
			int threadCount = 1;
			while(scanner.hasNext()){
				String currentPosition = scanner.nextLine();
				String[] arrayPosition = currentPosition.split("\\s");
				
				try{
					if(arrayPosition.length==3){
						 Coordinates coordinates = new Coordinates(Integer.parseInt(arrayPosition[0]), 
									Integer.parseInt(arrayPosition[1]));
						 Rover rover =  new Rover(coordinates,Direction.valueOf(arrayPosition[2]));
						 
						 String commands = scanner.nextLine();
						 
						 Command commandProcessor = new CommandProcessor(plateau,rover);
						 //commandProcessor.execute(commands.toCharArray());
						 
						 RoverThread rt = new RoverThread(commandProcessor, commands);
						 
						 Thread thread = new Thread(rt);
						 thread.setName("Thread-"+threadCount);
						 thread.start();
						 
						 threadCount++;
					 	
					}else{
						System.out.println("Invalid Input - "+currentPosition);
					}
				}catch(NumberFormatException nfe){
					System.out.println("Invalid Input - "+currentPosition);
				}
				 
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			if(scanner!=null)
				scanner.close();
		}
	}

}
