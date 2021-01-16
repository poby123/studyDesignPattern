package decorator;

/*
 * �߰��� ���񽺰� ���� ���ɼ��� �ִ� ��ü�� ���� �������̽�(�߻�Ŭ����)
 * */
abstract class Component {
	public abstract void makeHouse();
}

/*
 * �⺻ ���񽺰� �ִ� �⺻ ��ü
 * */
class ConcreteComponent extends Component {

	@Override
	public void makeHouse() {
		System.out.println("Original House is complete. It is closed for modification.");
	}

}

/*
 * Component Ŭ������ ��ӹް�, Component �⺻ ��ü�� �����Ѵ�. 
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
 * ��ü���� ConcreteDecorator �� �ش��ϸ�, Decorator�� ��ӹ޾� �ΰ����񽺸� �����Ѵ�.
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
