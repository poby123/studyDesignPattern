package command;

interface MCommand {
	void executeDo();

	void executeUndo();
}

class AdditionCommand implements MCommand {
	private MReceiver receiver;

	public AdditionCommand(MReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void executeDo() {
		receiver.performDo();
	}

	@Override
	public void executeUndo() {
		receiver.performUndo();
	}
}

class PowerCommand implements MCommand {
	private MReceiver receiver;

	public PowerCommand(MReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void executeDo() {
		receiver.performDo();
	}

	@Override
	public void executeUndo() {
		receiver.performUndo();
	}
}

interface MReceiver {
	void performDo();

	void performUndo();
}

class Receiver1 implements MReceiver {
	private int myNumber;

	public int getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}

	public Receiver1() {
		myNumber = 10;
		System.out.println("Receiver1 init with " + myNumber);
		System.out.println("The obejcts of receiver1 cannot set beyond " + myNumber);
	}

	@Override
	public void performUndo() {
		System.out.println("Received an undo addition request");
		int presentNumber = this.myNumber;

		if (presentNumber > 10) {
			setMyNumber(this.myNumber - 2);
			System.out.println(presentNumber + " -2 = " + this.myNumber);
			System.out.println("\t Undo request processed.");
		} else {
			System.out.println("Nothing more to undo...");
		}
	}

	@Override
	public void performDo() {
		System.out.println("Received an addition request.");
		
		int presentNumber = getMyNumber();
		setMyNumber(presentNumber + 2);
		System.out.println(presentNumber + " + 2 =" + this.myNumber);
	}
}

class Receiver2 implements MReceiver {
	boolean status;

	public Receiver2() {
		System.out.println("Receiver2 initialized ");
		status = false;
	}

	@Override
	public void performDo() {
		System.out.println("Received a system power on request.");
		if (status == false) {
			System.out.println("System is starting up.");
			status = true;
		} else {
			System.out.println("System is already running.So, power on request is ignored.");
		}
	}

	@Override
	public void performUndo() {
		System.out.println("Received a undo request.");
		if (status == true) {
			System.out.println("System is currently powered on.");
			status = false;
			System.out.println("\t Undo request processed.System is switched off now.");
		} else {
			System.out.println("System is switched off at present.");
			status = true;
			System.out.println("\t Undo request processed.System is powered on now.");
		}
	}
}

//Invoker class
class MInvoker {
	MCommand commandToBePerformed;

	public void setCommand(MCommand command) {
		this.commandToBePerformed = command;
	}

	public void executeCommand() {
		commandToBePerformed.executeDo();
	}

	public void undoCommand() {
		commandToBePerformed.executeUndo();
	}
}

public class ModifiedCommandPatternExample {

	public static void main(String[] args) {
		System.out.println("***Command Pattern Q&As***");
		System.out.println("***A simple demo with undo supported operations***\n");
		MInvoker invoker = new MInvoker();

		System.out.println("-----Testing operations in Receiver1-----");
		MReceiver intendedreceiver = new Receiver1();
		MCommand currentCmd = new AdditionCommand(intendedreceiver);
		invoker.setCommand(currentCmd);

		System.out.println("*Testing single do/undo operation*");
		invoker.executeCommand();
		invoker.undoCommand();
		System.out.println("_______");
		
		System.out.println("**Testing a series of do/undo operations**");
		invoker.executeCommand();
		invoker.executeCommand();
		invoker.undoCommand();
		invoker.undoCommand();
		invoker.undoCommand();
		
		System.out.println("\n-----Testing operations in Receiver2-----");
		intendedreceiver = new Receiver2();
		currentCmd = new PowerCommand(intendedreceiver);
		invoker.setCommand(currentCmd);
		
		System.out.println("*Testing single do/undo operation*");
		invoker.executeCommand();
		invoker.undoCommand();
		System.out.println("_______");
		System.out.println("**Testing a series of do/undo operations**");
		
		invoker.executeCommand();
		invoker.executeCommand();
		invoker.undoCommand();
		invoker.undoCommand();
		invoker.undoCommand();

	}

}
