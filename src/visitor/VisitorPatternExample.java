package visitor;

interface OriginalInterface {
	void acceptVisitor(Visitor visitor);
}

class MyClass implements OriginalInterface {
	private final int myInt;

	public MyClass() {
		myInt = 5;
	}

	public int getMyInt() {
		return myInt;
	}

	@Override
	public void acceptVisitor(Visitor visitor) {
		visitor.visit(this);
	}
}

interface Visitor {
	void visit(MyClass myClassObject);
}

class ConcreteVisitor implements Visitor {
	@Override
	public void visit(MyClass myClassObject) {
		System.out.println("Current Value of myInt=" + myClassObject.getMyInt());
		System.out.println("Visitor will make it double and display it.");
		System.out.println("Current Value of myInt=" + 2 * myClassObject.getMyInt());
		System.out.println("Exiting from Visitor");
	}
}

public class VisitorPatternExample {
	public static void main(String[]args) {
		System.out.println("*** Visitor Pattern Demo ***\n");
		Visitor visitor = new ConcreteVisitor();
		MyClass myClass = new MyClass();
		myClass.acceptVisitor(visitor);
	}
}
