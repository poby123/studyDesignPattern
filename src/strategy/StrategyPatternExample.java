package strategy;

/*
 * Strategy
 * */
interface TransportMedium{
	public void transport();
}

/*
 * Concrete Strategies
 * */
class WaterTransport implements TransportMedium{
	@Override
	public void transport() {
		System.out.println("I am transporting in water");
	}
}

class AirTransport implements TransportMedium{
	@Override
	public void transport() {
		System.out.println("I am transporing in air.");
	}
}

/*
 * Context
 * */
abstract class Vehicle{
	TransportMedium transportMedium;
	
	public Vehicle() {
		
	}
	
	public void showTransportMedium() {
		transportMedium.transport();
	}
	
	public void commonJob() {
		System.out.println("We all can be used to transport");
	}
	
	public abstract void showMe();
}

/*
 * Concrete Contexts
 * */
class Boat extends Vehicle{
	public Boat() {
		transportMedium = new WaterTransport();
	}
	
	@Override
	public void showMe() {
		System.out.println("I am a boat.");
	}
}

class Aeroplane extends Vehicle{
	public Aeroplane() {
		transportMedium = new AirTransport();
	}
	
	@Override
	public void showMe() {
		System.out.println("I am an aeroplane.");
	}
}

public class StrategyPatternExample {
	public static void main(String[] args) {
		System.out.println("*** Strategy Pattern Demo ***");
		Vehicle vehicleContext = new Boat();
		vehicleContext.showMe();
		vehicleContext.showTransportMedium();
		
		System.out.println("----------");
		
		vehicleContext = new Aeroplane();
		vehicleContext.showMe();
		vehicleContext.showTransportMedium();
	}
}
