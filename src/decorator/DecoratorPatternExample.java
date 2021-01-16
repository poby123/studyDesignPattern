package decorator;

/*
 * 추가할 서비스가 있을 가능성이 있는 객체에 대한 인터페이스(추상클래스)
 * */
abstract class Component {
	public abstract void makeHouse();
}

/*
 * 기본 서비스가 있는 기본 객체
 * */
class ConcreteComponent extends Component {

	@Override
	public void makeHouse() {
		System.out.println("Original House is complete. It is closed for modification.");
	}

}

/*
 * Component 클래스를 상속받고, Component 기본 객체를 관리한다. 
 * */
abstract class AbstractDecorator extends Component {
	protected Component component;

	public void setTheComponent(Component c) {
		component = c;
	}

	@Override
	public void makeHouse() {
		if (component != null) {
			component.makeHouse();
		}
	}
}

/*
 * 구체적인 ConcreteDecorator 에 해당하며, Decorator를 상속받아 부가서비스를 구현한다.
 * */
class FloorDecorator extends AbstractDecorator {
	public void makeHouse() {
		super.makeHouse();

		System.out.println("*** Floor decorator is in action ***");
		addFloor();
	}

	private void addFloor() {
		System.out.println("I am making an additional floor on top of it.");
	}
}

class PaintDecorator extends AbstractDecorator {
	public void makeHouse() {
		super.makeHouse();
		System.out.println("*** Paint decorator is in action ***");
		paintTheHouse();
	}

	private void paintTheHouse() {
		System.out.println("Now I am painting the house.");
	}
}

public class DecoratorPatternExample {

	public static void main(String[] args) {
		System.out.println("*** Decorator pattern Demo ***");
		ConcreteComponent withoutDecorator = new ConcreteComponent();
		withoutDecorator.makeHouse();
		System.out.println("____________________");

		System.out.println("Using a Floor decorator now.");
		FloorDecorator floorDecorator = new FloorDecorator();
		floorDecorator.setTheComponent(withoutDecorator);
		floorDecorator.makeHouse();
		System.out.println("____________________");

		System.out.println("Using a Paint decorator now.");
		PaintDecorator paintDecorator = new PaintDecorator();
		paintDecorator.setTheComponent(floorDecorator);
		paintDecorator.makeHouse();
		System.out.println("____________________");
	}

}
