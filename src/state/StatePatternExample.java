package state;

interface PossibleState {
	void pressOnButton(TV context);

	void pressOffButton(TV context);

	void pressMuteButton(TV context);
}

class Off implements PossibleState {

	@Override
	public void pressOnButton(TV context) {
		System.out.println("You pressed on button. Going from Off to On State.");
		context.setCurrentState(new On());
		System.out.println(context.getCurrentState().toString());
	}

	@Override
	public void pressOffButton(TV context) {
		System.out.println("You pressed Off button. TV is already in Off state.");

	}

	@Override
	public void pressMuteButton(TV context) {
		System.out.println("You pressed Mute button. TV is already in Off state, so Mute operation will not work.");
	}

	public String toString() {
		return "\t** TV is switched off now.";
	}

}

//On state
class On implements PossibleState {
	@Override
	public void pressOnButton(TV context) {
		System.out.println("You pressed On button. TV is already in On state.");
	}

	@Override
	public void pressOffButton(TV context) {
		System.out.println("You pressed Off button.Going from On to Off state.");
		context.setCurrentState(new Off());
		System.out.println(context.getCurrentState().toString());
	}

	@Override
	public void pressMuteButton(TV context) {
		System.out.println("You pressed Mute button.Going from On to Mute mode.");
		context.setCurrentState(new Mute());
		System.out.println(context.getCurrentState().toString());
	}

	public String toString() {
		return "\t**TV is switched on now.**";
	}
}

//Mute state
class Mute implements PossibleState {
	@Override
	public void pressOnButton(TV context) {
		System.out.println("You pressed On button.Going from Mute mode to On state.");
		context.setCurrentState(new On());
		System.out.println(context.getCurrentState().toString());
	}

	@Override
	public void pressOffButton(TV context) {
		System.out.println("You pressed Off button. Going from Mute mode to Off state.");
		context.setCurrentState(new Off());
		System.out.println(context.getCurrentState().toString());
	}

	@Override
	public void pressMuteButton(TV context) {
		System.out.println("You pressed Mute button.TV is already in Mute mode.");
	}

	public String toString() {
		return "\t**TV is silent(mute) now**";
	}
}

class TV {
	private PossibleState currentState;

	public TV() {
		this.setCurrentState(new Off());
	}

	public PossibleState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(PossibleState currentState) {
		this.currentState = currentState;
	}

	public void pressOffButton() {
		currentState.pressOffButton(this);// Delegating the state
	}

	public void pressOnButton() {
		currentState.pressOnButton(this);// Delegating the state
	}

	public void pressMuteButton() {
		currentState.pressMuteButton(this);// Delegating the state
	}
}

public class StatePatternExample {

	public static void main(String[] args) {
		System.out.println("***State Pattern Demo***\n");
		// Initially TV is Off.
		TV tv = new TV();
		System.out.println("User is pressing buttons in the following sequence:");
		System.out.println("Off->Mute->On->On->Mute->Mute->Off\n");

		tv.pressOffButton();
		tv.pressMuteButton();
		tv.pressOnButton();
		tv.pressOnButton();
		tv.pressMuteButton();
		tv.pressMuteButton();
		tv.pressOffButton();
	}

}
