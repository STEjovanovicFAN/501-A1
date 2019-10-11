
public class Sports extends Car{
	public static final int STARTING_FUEL = 30;
    public static final int STANDARD_DISTANCE = 3;
    public static final int CONSUMPTION_RATE = 2;
    
	public Sports(){
		setAppearance('S');
		setFuel(STARTING_FUEL);
	}
	
	public int getDistance(){
		return(STANDARD_DISTANCE);
	}

	public int doubleConsumtionRate(int consumtionRate){
		return consumtionRate * 2;
	}

	public int moveInConditions(){
		if(Debug.on == true){
			System.out.println("<<<< In Class Sports, Method: moveInConditions >>>>");
		}
		//check fuel 
		int carFuel = getFuel();
		//if there is not enough fuel to be consumed then don't move and show current fuel
		if(carFuel < 2){
			System.out.println("Current fuel: " + getFuel());
			System.out.println("Fuel use: " + (0));
			//distance moved
			return(0);
			   
		}
		
		else{
			consumeFuel(doubleConsumtionRate(CONSUMPTION_RATE));
			System.out.println("Current fuel: " + getFuel());
			System.out.println("Fuel use: " + doubleConsumtionRate(CONSUMPTION_RATE));
	  		return STANDARD_DISTANCE;
		}
	}
	
	//override method
    public int move ()
    {
		if(Debug.on == true){
			System.out.println("<<<< In Class Sports, Method: Move >>>>");
		}
    	//check fuel 
    	int carFuel = getFuel();
    	//if there is not enough fuel to be consumed then don't move and show current fuel
    	if(carFuel < 2){
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
}
