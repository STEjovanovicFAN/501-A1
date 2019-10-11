import java.util.Scanner;
public class GameControllerDisplayAndInputs {
 
    public String carDisplay(char apperence, boolean event, boolean global){
        String ret = "";
		if(event == true || global == true){
            ret += "WARNING: EXTREME CONDITIONS ON ROAD" + "\n";
		}
            
        if(apperence == 'S'){
            ret +=  "Sportscar driving options" + 
             "\n" + "(d)rive normally" + 
             "\n" + "(q)uit simulation" + 
             "\n" + "Enter selection: ";
        }
        if(apperence == 'V'){
            ret +=  "SUV driving options" + 
            "\n" + "(a)ll wheel drive mode" + 
            "\n" + "(d)rive normally" + 
            "\n" + "(q)uit simulation" + 
            "\n" + "Enter selection: ";

        }
        return ret;
    }

    public char getInput(){
        //get input
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        if(input.length() > 0){
            return input.charAt(0);
        }
        return ' ';
    }

    public String cheatDisplay(){
        String ret = "";
        ret+= "\n" + 
        "\n" + "(0) Toggle debugging messages on/off" + 
        "\n" + "(1) Change fuel of sports car" + 
        "\n" + "(2) Change fuel of SUV car"+ 
        "\n" + "(3) Change location of sports car" + 
        "\n" + "(4) Change location of SUV car" + 
        "\n" + "(5) Make blizzard in arctic track" + 
        "\n" + "(6) Make a heat wave in desert track" + 
        "\n" + "Enter Selection: ";
        return ret;
    }

    public String checkWhyLoopFinished(Track arcticTrack, Track desertTrack){
		if(arcticTrack.finisedTrack()){
			formatDisplay(arcticTrack,desertTrack);
			return "The SUV won!";
		}

		if(desertTrack.finisedTrack()){
			formatDisplay(arcticTrack,desertTrack);
			return "The sports car won!"; 
		}

		return "User (through input 'q') decided to quit the program!";

	}

    public void formatDisplay(Track arcticTrack, Track desertTrack){
		System.out.println("\n" + "ARCTIC TRACK");
		arcticTrack.display();
		System.out.println("\n" + "DESERT TRACK");
		desertTrack.display();
		System.out.println("");
	}
}