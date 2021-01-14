package builder;

interface Builder2 {
	Builder2 startUpOperations(String startUpMessage);

	Builder2 buildBody(String bodyType);

	Builder2 insertWheels(int noOfWheels);

	Builder2 addHeadlights(int noOfHeadLights);

	Builder2 endOfOperations(String endOperationsMessage);

	ProductClass constructCar();

	ProductClass getConstructedCar();
}

class CarBuilder implements Builder2 {

	// default properties
	private String startUpMessage = "Start building the product";
	private String bodyType = "Steel";
	private int noOfWheels = 4;
	private int noOfHeadLights = 2;
	private String endOperationMessage = "Product creation completed";
	private ProductClass product;

	@Override
	public Builder2 startUpOperations(String startUpMessage) {
		this.startUpMessage = startUpMessage;
		return this;
	}

	@Override
	public Builder2 buildBody(String bodyType) {
		this.bodyType = bodyType;
		return this;
	}

	@Override
	public Builder2 insertWheels(int noOfWheels) {
		this.noOfWheels = noOfWheels;
		return this;
	}

	@Override
	public Builder2 addHeadlights(int noOfHeadLights) {
		this.noOfHeadLights = noOfHeadLights;
		return this;
	}

	@Override
	public Builder2 endOfOperations(String endOperationsMessage) {
		this.endOperationMessage = endOperationsMessage;
		return this;
	}

	@Override
	public ProductClass constructCar() {
		product = new ProductClass(this.startUpMessage, this.bodyType, this.noOfWheels, this.noOfHeadLights,
				this.endOperationMessage);
		return product;
	}

	@Override
	public ProductClass getConstructedCar() {
		return product;
	}
}

/*
 * Product Class
 */
final class ProductClass {
	private String startUpMessage;
	private String bodyType;
	private int noOfWheels;
	private int noOfHeadLights;
	private String endOperationsMessage;

	public ProductClass(final String startUpMessage, String bodyType, int noOfWheels, int noOfHeadLights,
			String endOperationMessage) {
		this.startUpMessage = startUpMessage;
		this.bodyType = bodyType;
		this.noOfWheels = noOfWheels;
		this.noOfHeadLights = noOfHeadLights;
		this.endOperationsMessage = endOperationMessage;
	}

	public String toString() {
		return "Product Completed as:\n startUpMessage=" + startUpMessage + "\n bodyType=" + bodyType + "\n noOfWheels="
				+ noOfWheels + "\n noOfHeadLights=" + noOfHeadLights + "\n endOperationsMessage="
				+ endOperationsMessage;
	}
}

/*
 * Director Class
 */
public class BuilderPatternExample2 {

	public static void main(String[] args) {
		System.out.println("*** Modified Builder Pattern Demo ***");

		/* custom car 1 */
		final ProductClass customCar1 = new CarBuilder().addHeadlights(5).insertWheels(5).buildBody("Plastic")
				.constructCar();
		System.out.println(customCar1);

		/* custom car 2 */
		System.out.println("--------------");
		Builder2 carBuilder2 = new CarBuilder();
		final ProductClass customCar2 = carBuilder2.insertWheels(7).addHeadlights(6)
				.startUpOperations("I am making my own car").constructCar();
		System.out.println(customCar2);

		/* custom car 3 */
		System.out.println("--------------");
		final ProductClass customCar3 = carBuilder2.getConstructedCar();
		System.out.println(customCar3);
	}

}
