package factoryMethod;

interface Animal {
	void speak();

	void preferredAction();
}

class Dog implements Animal {
	public void speak() {
		System.out.println("Dog says: Bow-Wow.");
	}

	public void preferredAction() {
		System.out.println("Dogs prefer barking...\n");
	}
}

class Tiger implements Animal {
	public void speak() {
		System.out.println("Tiger says: Halum.");
	}

	public void preferredAction() {
		System.out.println("Tigers prefer hunting...\n");
	}
}

abstract class AnimalFactory {
	
	/*
	 * 인스턴스화를 여기서 하지않고, 이를 구현한 하위 클래스로 미룬다.
	 * */
	public abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory {
	public Animal createAnimal() {
		// Creating a Dog
		return new Dog();
	}
}

class TigerFactory extends AnimalFactory {
	public Animal createAnimal() {
		// Creating a Tiger
		return new Tiger();
	}
}

public class FactoryMethodPatternExample {
	public static void main(String[] args) {
		System.out.println("***Factory Pattern Demo***\n");
		// Creating a Tiger Factory
		AnimalFactory tigerFactory = new TigerFactory();
		Animal aTiger = tigerFactory.createAnimal();
		aTiger.speak();
		aTiger.preferredAction();
		
		// Creating a DogFactory
		AnimalFactory dogFactory = new DogFactory();
		Animal aDog = dogFactory.createAnimal();
		aDog.speak();
		aDog.preferredAction();
	}
}
