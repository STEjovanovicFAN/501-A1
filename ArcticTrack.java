import java.util.Random;
public class ArcticTrack extends Track {
	boolean blizzard = false;
	
	public int rollDice(){
		//make dice
		Random dice = new Random();
		//roll dice btwn 0-9 (10 numbers)
		int diceRolled = dice.nextInt(9);
		return(diceRolled);
	}

	public void blizzard() {

		//initalize blizzard to be false then roll dice
		blizzard = false;
		int event = rollDice();
		
		//assign number 7 to be the chance it will be a blizzard
		if(event == 7){
			blizzard = true;
		}
	}
	
	public boolean getBlizzard(){
		return(blizzard);
	}
	
}
