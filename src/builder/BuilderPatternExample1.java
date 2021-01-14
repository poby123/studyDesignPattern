package builder;

import java.util.LinkedList;

/*
 * Builder interface
 * */
interface Builder {
	void startUpOperations();

	void buildBody();

	void insertWheels();

	void addHeadlights();

	void endOperations();

	/* It used to retrieve the object that is constructed. */
	Product getVehicle();
}

/*
 * Car ConcreteBuilder is implements Builder interface.
 */
class Car implements Builder {
	private String brandName;
	private Product product;

	public Car(String brand) {
		product = new Product();
		this.brandName = brand;
	}

	@Override
	public void startUpOperations() {
		product.add(String.format("Car model is : %s", this.brandName));
	}

	@Override
	public void buildBody() {
		product.add("This is a body of a Car");
	}

	@Override
	public void insertWheels() {
		product.add("4 wheels are added");
	}

	@Override
	public void addHeadlights() {
		product.add("2 Headlights are added");
	}

	@Override
	public void endOperations() {
	}

	@Override
	public Product getVehicle() {
		return product;
	}
}

/*
 * MotorCycle ConcreteBuilder is implements Builder interface.
 */
class MotorCycle implements Builder {
	private String brandName;
	private Product product;

	public MotorCycle(String brand) {
		product = new Product();
		this.brandName = brand;
	}

	@Override
	public void startUpOperations() {

	}

	@Override
	public void buildBody() {

		product.add("This is a body of a Motorcycle");
	}

	@Override
	public void insertWheels() {

		product.add("2 wheels are added");
	}

	@Override
	public void addHeadlights() {
		product.add("1 Headlights are added");

	}

	@Override
	public void endOperations() {
		// Finishing up with brand name
		product.add(String.format("Motorcycle model is : %s", this.brandName));
	}

	@Override
	public Product getVehicle() {
		return product;
	}
}

/*
 * Product Class
 */
class Product {
	private LinkedList<String> parts;

	public Product() {
		parts = new LinkedList<String>();
	}

	public void add(String part) {
		parts.addLast(part);
	}

	public void showProduct() {
		System.out.println("\nProduct completed as below : ");
		for (String part : parts) {
			System.out.println(part);
		}
	}
}

/*
 * Director Class
 */
class Director {
	Builder builder;

	/*
	 * Director define each step to build product and order specific representation.
	 */
	public void construct(Builder builder) {
		this.builder = builder;
		builder.startUpOperations();
		builder.buildBody();
		builder.insertWheels();
		builder.addHeadlights();
		builder.endOperations();
	}
}

public class BuilderPatternExample1 {

	public static void main(String[] args) {
		System.out.println("*** Builder Design Pattern Demo *** ");
		Director director = new Director();

		// Instantiate each ConcreteBuilders
		Builder fordCar = new Car("ford");
		Builder hondaMotorCycle = new MotorCycle("Honda");

		// Making Car
		director.construct(fordCar);
		Product p1 = fordCar.getVehicle();
		p1.showProduct();

		// Making MotorCycle
		director.construct(hondaMotorCycle);
		Product p2 = hondaMotorCycle.getVehicle();
		p2.showProduct();
	}

}
