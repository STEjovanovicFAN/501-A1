
public class SUV extends Car{
	public static final int STARTING_FUEL = 50;
    public static final int STANDARD_DISTANCE = 2;
    public static final int CONSUMPTION_RATE = 3;
	
	public SUV(){
		setAppearance('V');
		setFuel(STARTING_FUEL);
	}
	
	public int getDistance(){
		return(STANDARD_DISTANCE);
	}
	
	public int moveInConditions(){
		if(Debug.on == true){
			System.out.println("<<<< In Class SUV, Method: moveInConditions >>>>");
		}
		//check fuel 
		int carFuel = getFuel();
		//if there is not enough fuel to be consumed then don't move and show current fuel
    	if(carFuel < 3){
    		System.out.println("Current fuel: " + getFuel());
    		System.out.println("Fuel use: " + (0));
    		//distance moved
    		return(0);
    				   
    	}
    	else{
    		consumeFuel(CONSUMPTION_RATE);
    		System.out.println("Current fuel: " + getFuel());
    		System.out.println("Fuel use: " + CONSUMPTION_RATE);
    	    return (1);	
    	}
	}
	
	//override method
    public int move (){
		if(Debug.on == true){
			System.out.println("<<<< In Class SUV, Method: move >>>>");
		}
    	//check fuel 
    	int carFuel = getFuel();
    	//if there is not enough fuel to be consumed then don't move and show current fuel
    	if(carFuel < 3){
    		System.out.println("Current fuel: " + getFuel());
    		System.out.println("Fuel use: " + (0));
    		//distance moved
    		return(0);
    				   
    	}
    	else{
    		consumeFuel(CONSUMPTION_RATE);
    		System.out.println("Current fuel: " + getFuel());
    		System.out.println("Fuel use: " + CONSUMPTION_RATE);
    		return STANDARD_DISTANCE;
    		
    	}
    }

	public int stopInCondidtions() {
		if(Debug.on == true){
			System.out.println("<<<< In Class SUV, Method: stopInConditions >>>>");
		}
    	//check fuel 
    	int carFuel = getFuel();
    	//if there is not enough fuel to be consumed then don't move and show current fuel
    	if(carFuel < 3){
    		System.out.println("Current fuel: " + getFuel());
    		System.out.println("Fuel use: " + (0));
    		//distance moved
    		return(0);
    				   
    	}
    	else{
    		consumeFuel(CONSUMPTION_RATE);
    		System.out.println("Current fuel: " + getFuel());
    		System.out.println("Fuel use: " + CONSUMPTION_RATE);
    		return (0);
    		
    	}
	}  
}
