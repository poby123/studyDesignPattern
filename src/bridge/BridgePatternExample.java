package bridge;

// Implementor
interface State {
	void moveState();

	void hardPressed();
}

// A Concrete Implementor
class OnState implements State {

	@Override
	public void moveState() {
		System.out.println("On State\n");
	}

	@Override
	public void hardPressed() {
		System.out.println("\tThe device is already On. Do not press the button so hard");
	}
}

// Another Concrete Implementor
class OffState implements State {

	@Override
	public void moveState() {
		System.out.println("Off State\n");
	}

	@Override
	public void hardPressed() {
		System.out.println("\tThe device is offline now. Do not press the off button again");
	}
}

// Abstraction
abstract class ElectronicGoods {
	// Composition - Implementor
	protected State state;

	/*
	 * public ElectronicGoods(State state) { this.state = state; }
	 */

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	/*
	 * Implementation specific: We are delegating the implementation to the
	 * Implementor object.
	 */
	public void moveToCurrentState() {
		System.out.println("The electronic item is functioning at : ");
		state.moveState();
	}

	public void hardButtonPressed() {
		state.hardPressed();
	}
}

// Refined Abstraction
class Television extends ElectronicGoods {
	/*
	 * Television(State state) { super(state); }
	 */
}

class DVD extends ElectronicGoods {

	/*
	 * DVD(State state){ super(state); }
	 */

	public void doublePress() {
		hardButtonPressed();
		hardButtonPressed();
	}
}

public class BridgePatternExample {

	public static void main(String[] args) {
		System.out.println("***Bridge Pattern Demo***");
		
		System.out.println("\n Dealing with a Television at present.");
		
		// TV on
		State presentState = new OnState();
		// ElectronicGoods eItem = new Television(presentState);
		ElectronicGoods eItem = new Television();
		eItem.setState(presentState);
		eItem.moveToCurrentState();
		eItem.hardButtonPressed();
		
		// TV off
		presentState = new OffState();
		// eItem = new Television(presentState);
		eItem.setState(presentState);
		eItem.moveToCurrentState();

		System.out.println("\n Dealing with a DVD now.");
		
		// DVD on
		presentState = new OnState();
		// eItem = new DVD(presentState);
		eItem = new DVD();
		eItem.setState(presentState);
		eItem.moveToCurrentState();
		
		// DVD off
		presentState = new OffState();
		// eItem = new DVD(presentState);
		eItem = new DVD();
		eItem.setState(presentState);
		eItem.moveToCurrentState();
		
		// hard press-A DVD specific method
		// (new DVD(presentState)).doublePress();
		((DVD) eItem).doublePress();
		/*
		 * The following line of code will cause error because a television object does
		 * not have this method.
		 */
		// (new Television(presentState)).doublePress();
	}

}
