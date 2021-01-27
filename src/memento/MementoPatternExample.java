package memento;

class Memento {
	private int stateId;

	public Memento(int stateId) {
		this.stateId = stateId;
	}

	public int getStateId() {
		return stateId;
	}
}

class Originator {
	private int stateId;

	public Originator() {
		this.stateId = 0;
		System.out.println(" Originator is created with state id : " + stateId);
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
		System.out.println(" Setting the state id of the originator to : " + stateId);
	}

	public Memento saveMemento(int stateId) {
		System.out.println(" Saving originator's current state id.");
		return new Memento(stateId);
	}

	public void revertMemento(Memento previousMomento) {
		System.out.println(" Restoring to state id ..." + previousMomento.getStateId());
		this.stateId = previousMomento.getStateId();
		System.out.println(" Current state id of originator : " + stateId);
	}
}

// This is CareTaker Class
public class MementoPatternExample {

	public static void main(String[] args) {
		System.out.println("*** Memento Pattern Demo ***\n");
		Originator originatorObject = new Originator();
		Memento mementoObject;

		originatorObject.setStateId(1);
		mementoObject = originatorObject.saveMemento(originatorObject.getStateId());
		System.out.println(" Snapshot #1: Originator's current state id is saved in caretaker.");

		originatorObject.setStateId(2);
		mementoObject = originatorObject.saveMemento(originatorObject.getStateId());
		System.out.println(" Snapshot #2: Originator's current state id is saved in caretaker.");

		originatorObject.setStateId(3);
		originatorObject.revertMemento(mementoObject);
	}

}
