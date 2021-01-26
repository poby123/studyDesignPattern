package command;

interface Command {
	void executeCommand();
}

class MyUndoCommand implements Command {
	private Receiver receiver;

	public MyUndoCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void executeCommand() {
		receiver.doOptionalTaskPriorToUndo();
		receiver.performUndo();
	}
}

class MyRedoCommand implements Command {
	private Receiver receiver;

	public MyRedoCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void executeCommand() {
		receiver.doOptionalTaskPriorToRedo();
		receiver.performRedo();
	}
}

class Receiver {
	public void performUndo() {
		System.out.println("Performing an undo command in Receiver.");
	}

	public void performRedo() {
		System.out.println("Performing an redo command in Receiver.");
	}

	public void doOptionalTaskPriorToUndo() {
		System.out.println("Executing -Optional Task/s prior to execute undo command.");
	}

	public void doOptionalTaskPriorToRedo() {
		System.out.println("Executing -Optional Task/s prior to execute redo command.");
	}
}

class Invoker {
	Command commandToBePerformed;

	public void setCommand(Command command) {
		this.commandToBePerformed = command;
	}

	public void invokeCommand() {
		commandToBePerformed.executeCommand();
	}
}

public class CommandPatternExample {

	public static void main(String[] args) {
		System.out.println("*** Command Pattern Demo ***\n");
		
		Receiver intendedReceiver = new Receiver();
		Invoker invoker = new Invoker();
		
		MyUndoCommand undoCmd = new MyUndoCommand(intendedReceiver);
		invoker.setCommand(undoCmd);
		invoker.invokeCommand();
		
		MyRedoCommand redoCmd = new MyRedoCommand(intendedReceiver);
		invoker.setCommand(redoCmd);
		invoker.invokeCommand();
	}

}
