package abstractFactory;

interface Dog {
	void speak();

	void action();
}

interface Tiger {
	void speak();

	void action();
}

// Types of Dogs-wild dogs and pet dogs
class WildDog implements Dog {

	@Override
	public void speak() {
		System.out.println("Wild Dog says loudly: Bow-Wow");

	}

	@Override
	public void action() {
		System.out.println("Wild Dogs prefer to roam freely in jungles.\n");
	}

}

class PetDog implements Dog {

	@Override
	public void speak() {
		System.out.println("Pet Dog says softly : Bow-Wow");
	}

	@Override
	public void action() {
		System.out.println("Pet Dogs prefer to stay at home\n");
	}
}

// Types of Tigers-wild tigers and pet tigers
class WildTiger implements Tiger {

	@Override
	public void speak() {
		System.out.println("Wild Tiger says loudly : Halum");
	}

	@Override
	public void action() {
		System.out.println("Wild Tiger prefer hunting in jungles\n");
	}

}

class PetTiger implements Tiger {

	@Override
	public void speak() {
		System.out.println("Pet Tiger says softly: Halum.");
	}

	@Override
	public void action() {
		System.out.println("Pet Tigers play in the animal circus.\n");
	}

}

//Abstract Factory
interface AnimalFactory {
	Dog createDog();

	Tiger createTiger();
}

//Concrete Factory-Wild Animal Factory
class WildAnimalFactory implements AnimalFactory {
	@Override
	public Dog createDog() {
		return new WildDog();
	}

	@Override
	public Tiger createTiger() {
		return new WildTiger();
	}
}

//Concrete Factory-Pet Animal Factory
class PetAnimalFactory implements AnimalFactory {
	@Override
	public Dog createDog() {
		return new PetDog();
	}

	@Override
	public Tiger createTiger() {
		return new PetTiger();
	}
}

//Client
public class AbstractFactoryPatternExample {
	public static void main(String[] args) {
		AnimalFactory myAnimalFactory;
		Dog myDog;
		Tiger myTiger;

		System.out.println("*** Abstract Factory Pattern Demo ***\n");

		// Making a wild dog
		myAnimalFactory = new WildAnimalFactory();
		myDog = myAnimalFactory.createDog();
		myDog.speak();
		myDog.action();

		// Making wild tiger
		myTiger = myAnimalFactory.createTiger();
		myTiger.speak();
		myTiger.action();

		System.out.println("*************\n");

		// Making a pet dog
		myAnimalFactory = new PetAnimalFactory();
		myDog = myAnimalFactory.createDog();
		myDog.speak();
		myDog.action();

		// Making a pet tiger
		myTiger = myAnimalFactory.createTiger();
		myTiger.speak();
		myTiger.action();
	}
}
