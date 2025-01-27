/*
 * Name: Stefan Jovanovic
 * Student ID #: 10135783
 * Version 3
 * 
 * 
 *V2 Notes: Fuck the scanner class. It has this bs thing where you have to clear the 
 * 		  keyboard.nextLine(); before you can take an int with keyboard.nextInt();.
 * 
 * 		  I found a solution searching the internet but it is really stupid as hell.
 * 
 * 		  Solution: int s = Integer.parseInt(keyboard.nextLine());
 * 
 * V3 Notes: The previous solution did not work. The cheat method only worked once and then
 * 			if you tried to use cheat again it would throw an error.
 * 			In this version I just created a new scanner for each input. Apparently this
 * 			way of doing it creates a lot of memory leaks, but it was the only way i could do it.
 * 			Also I skipped tutorial where you might have gone over it so.... yea...
 */
import java.util.Scanner;

public class GameController {
	Track arcticTrack;
	SUV arcticCar;
	Track desertTrack;
	Sports desertCar;
	GameControllerDisplayAndInputs display;
	
	boolean breakLoop = false;
	boolean checkBlizzard;
	boolean checkHeatWave;
	int positionDCar = 0;
	int positionACar = 0;
	boolean globalBlizzard = false;
	boolean globalHeatWave = false;
	
	public GameController(){
		//first make the two cars and the two tracks
    	//arctic track and car
    	arcticTrack = new Track();
    	arcticCar = new SUV();
    	
    	//desert track and car
    	desertTrack = new Track();
    	desertCar = new Sports();
    	
    	//put the cars in the tracks
    	int initalPosition = 0;
    	arcticTrack.setLocation(arcticCar, initalPosition);
		desertTrack.setLocation(desertCar, initalPosition);
		
		//game controller display 
		display = new GameControllerDisplayAndInputs();
	}
	
	public void start(){
		//infinte loop until a car wins or the user selects to exit program
    	while(-1 < 1){ 
			display.formatDisplay(arcticTrack, desertTrack);

			arcticTrack.genDisaster(arcticTrack.rollDice());
			checkBlizzard = arcticTrack.getDisaster();
			System.out.print(display.carDisplay(arcticCar.getApperence(), checkBlizzard, globalBlizzard));
        	identifyInputSUV(display.getInput());
        	
        	if(breakLoop){
				System.out.println(display.checkWhyLoopFinished(arcticTrack,desertTrack));
				break;
			}
        	
        	System.out.println();
        	
			desertTrack.genDisaster(desertTrack.rollDice());
			checkHeatWave = desertTrack.getDisaster();
			System.out.print(display.carDisplay(desertCar.getApperence(), checkHeatWave, globalHeatWave));
        	identifyInputSports(display.getInput());
        	
        	if(breakLoop){
				System.out.println(display.checkWhyLoopFinished(arcticTrack,desertTrack));
				break;
			}
    	}
	}
	
	public void identifyInputSUV(char SUV){
		//identify and proc commands 
		switch(SUV){
			case 'a':
			case 'A':
				
				int distance;
				//check if track has a blizzard
				if(checkBlizzard == true || globalBlizzard == true){
					//drive slower 
					System.out.println("A blizzard has hit, but you contiune to move at a slow pace.");
					distance = arcticCar.moveInConditions();
					
				}
				else{
					//move normally
					distance = arcticCar.move();
					
				}
				
				//erase previous position
				arcticTrack.setLocation(null, positionACar);
				positionACar = positionACar + distance;
				System.out.println("Distance moved: " + distance);
				
				//check if car won
				if(positionACar >= 24){
					//if car is at 24 position then leave it there and it won the race
					if(positionACar == 24){
						arcticTrack.setLocation(arcticCar, positionACar);
					}
					breakLoop = true;
					
				}
				
				else{
					//put in new position
					arcticTrack.setLocation(arcticCar, positionACar);
				}
				
				break;
			
			case 'd':
			case 'D':
				//drive normally
				int otherDistance;
				//check if track has blizzard
				if(checkBlizzard == true || globalBlizzard == true){
					//car stops moving 
					System.out.println("A blizzard has hit, your car spins its wheels.");
					otherDistance = arcticCar.stopInCondidtions();
					
				}
				else{
					//move normally
					otherDistance = arcticCar.move();
				}

				//erase previous position
				arcticTrack.setLocation(null, positionACar);
				positionACar = positionACar + otherDistance;
				System.out.println("Distance moved: " + otherDistance);
				
				//check if car won
				if(positionACar >= 24){
					//if car at position 24 put car in location and say it won
					if(positionACar == 24){
						arcticTrack.setLocation(arcticCar, positionACar);
					}
					breakLoop = true;
					
				}
				
				else{
					//put in new position
					arcticTrack.setLocation(arcticCar, positionACar);
				}
				
				break;
			
			case 'c':
			case 'C':
				//enable cheat mode for this turn
				System.out.println(display.cheatDisplay());
				cheatOptions(display.getInput());
				break;
			
			case 'q':
			case 'Q':
				//quit the program
				breakLoop = true;
				break;
		}
		
		
	}
	public void identifyInputSports(char sportsCar){
		//identify and proc commands 
		switch(sportsCar){
			case 'd':
			case 'D':
				
				int distance;
				//check if there is a heat wave
				if(checkHeatWave == true || globalHeatWave == true){
					//if heat wave double the fuel consumption 
					distance = desertCar.moveInConditions();
				}
				else{
					//regular
					distance = desertCar.move();
					
				}
				
				//erase previous position
				desertTrack.setLocation(null, positionDCar);
				positionDCar = positionDCar + distance;
				System.out.println("Distance moved: " + distance);
				
				//check if car won
				if(positionDCar >= 24){
					//if position of car is at 24 put car there and say it won
					if(positionDCar == 24){
						desertTrack.setLocation(desertCar, positionDCar);
					}
					breakLoop = true;
					
				}
				
				else{
					//put in new position
					desertTrack.setLocation(desertCar, positionDCar);
				}
				
				break;
			
			case 'c':
			case 'C':
				//enable cheat mode for this turn
				System.out.print(display.cheatDisplay());
				cheatOptions(display.getInput());
				break;
			
			case 'q':
			case 'Q':
				//quit the program
				breakLoop = true;
				break;
				
		}
	}
	public void cheatOptions(int userInput){
		if(userInput == 0){
			//toggle 
			if(Debug.on == true){
				System.out.println("<<<< Debugging Mode Off >>>>");
				Debug.on = false;
			}
			if(Debug.on == false){
				System.out.println("<<<<DeBugging Mode On>>>>");
				Debug.on = true;
			}
		}
		if(userInput == 1){
			System.out.print("What amount of fuel would you like to set for the sports car?: ");
			int fuelAmount = new Scanner(System.in).nextInt();
			
			//if < 0 the person inputed then set fuel to zero
			if(fuelAmount >= 0)
				desertCar.setFuel(fuelAmount);
			else
				desertCar.setFuel(0);

		}
		if(userInput == 2){
			System.out.print("What amount of fuel would you like to set for the SUV?: ");
			int fuelAmount = new Scanner(System.in).nextInt();
			
			//if < 0 the person inputed then set fuel to zero
			if(fuelAmount >= 0)
				arcticCar.setFuel(fuelAmount);
			else
				arcticCar.setFuel(0);

		}
		if(userInput == 3){
			System.out.print("Where would you like to change the location of the sports car?(0-24):");
			int position = new Scanner(System.in).nextInt();
			if(position >= 0 && position < 25){
				//change location
				desertTrack.setLocation(desertCar, position);
				//erase old location
				desertTrack.setLocation(null, positionDCar);
				//update the current position
				positionDCar = position;
				//if 24 last columb break loop
				if(positionDCar == 24)
					breakLoop = true;
			}
			else if(position >= 25){
				//erase old location
				desertTrack.setLocation(null, positionDCar);
				breakLoop = true;
			}
			else{
				System.out.println("Out of range.");
			}
		}
		if(userInput == 4){
			System.out.print("Where would you like to change the location of the SUV?(0-24):");
			int position = new Scanner(System.in).nextInt();
			if(position >= 0 && position < 25){
				//change location
				arcticTrack.setLocation(arcticCar, position);
				//erase old location
				arcticTrack.setLocation(null, positionACar);
				positionACar = position;
				//if last colum brake loop
				if(positionACar == 24)
					breakLoop = true;
			}
			else if(position >= 25){
				//erase old location
				arcticTrack.setLocation(null, positionACar);
				breakLoop = true;
			}
			else{
				System.out.println("Out of range.");
			}
	
		}
		if(userInput == 5){
			System.out.println("Permenantly set blizzard in arctic track (you can toggle this option on or off)");
			if(globalBlizzard == false)
				globalBlizzard = true;
			else if(globalBlizzard == true)
				globalBlizzard = false;

		}
		if(userInput == 6){
			System.out.println("Permenantly set heat wave in desert track (you can toggle this option on or off)");
			if(globalHeatWave == false)
				globalHeatWave = true;
			else if(globalHeatWave == true)
				globalHeatWave = false;
			
		}	
	}
}
