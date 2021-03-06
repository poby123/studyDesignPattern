package prototype;

import java.util.Random;

public abstract class BasicCar implements Cloneable {
	public String modelName;
	public int basePrice, onRoadPrice;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelname) {
		this.modelName = modelname;
	}

	public static int setAdditionalPrice() {
		int price = 0;
		Random r = new Random();

		int p = r.nextInt(10000);
		price = p;

		return price;
	}

	public BasicCar clone() throws CloneNotSupportedException {
		return (BasicCar) super.clone();
	}
}
