import java.util.Random;

public class DesertTrack extends Track {
	boolean heatWave = false;

	public int rollDice(){
		//make dice
		Random dice = new Random();
		//roll dice btwn 0-9 (10 numbers)
		int diceRolled = dice.nextInt(9);
		return(diceRolled);
	}

	public void heatWave() {

		//initalize heat wave to be false then roll dice
		heatWave = false;
		int event = rollDice();
		
		//assign number 7 to be the chance it will be a heat wave
		if(event == 7){
			heatWave = true;
		}
	}
	
	public boolean getHeatWave(){
		return(heatWave);
	}
}
