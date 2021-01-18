package flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface Robot {
	// Color comes from client. It is extrinsic.
	void showMe(String color);
}

// A shared flyweight implementation
class SmallRobot implements Robot {
	/*
	 * Intrinsic state. It is not supplied by client so it is independent of the
	 * flyweight's context. This can be shared across and these data are often
	 * immutable
	 */
	private final String robotTypeCreated;

	public SmallRobot() {
		robotTypeCreated = "A small robot created";
		System.out.println(robotTypeCreated);
	}

	@Override
	public void showMe(String color) {
		System.out.println(" with " + color + " color");
	}

}

// A shared flyweight implementation
class LargeRobot implements Robot {
	/*
	 * Intrinsic state. It is not supplied by client so it is independent of the
	 * flyweight's context. This can be shared across and these data are often
	 * immutable
	 */
	private final String robotTypeCreated;

	public LargeRobot() {
		robotTypeCreated = "A large robot created";
		System.out.println(robotTypeCreated);
	}

	@Override
	public void showMe(String color) {
		System.out.println(" with " + color + " color");
	}
}

//An unshared flyweight implementation
class FixedSizeRobot implements Robot {
	/*
	 * Intrinsic state. It is not supplied by client so it is independent of the
	 * flyweight's context. This can be shared across and these data are often
	 * immutable
	 */
	private final String robotTypeCreated;

	public FixedSizeRobot() {
		robotTypeCreated = "A Robot with a fixed size created.";
		System.out.println(robotTypeCreated);
	}

	@Override
	// Ignoring the extrinsic state argument
	// Since it is an unshared flyweight
	public void showMe(String color) {
		System.out.println(" with " + " blue (default) color");
	}
}

class RobotFactory {
	static Map<String, Robot> robotFactory = new HashMap<String, Robot>();

	public int totalObjectsCreated() {
		return robotFactory.size();
	}

	public static synchronized Robot getRobotFromFactory(String robotType) throws Exception {
		Robot robotCategory = robotFactory.get(robotType);
		if (robotCategory == null) {
			switch (robotType) {
			case "small":
				System.out.println("We do not have Small Robot at present so se are creating small robot now.");
				robotCategory = new SmallRobot();
				break;
			case "large":
				System.out.println("We do not have Large Robot at present.So we are creating a large robot now.");
				robotCategory = new LargeRobot();
				break;
			case "fixed":
				System.out.println("We do not have fixed size at present. So we are creating a fixed size robot now.");
				robotCategory = new FixedSizeRobot();
				break;
			default:
				throw new Exception(" Robot Factory can create only small ,large or fixed size robots");
			}
			robotFactory.put(robotType, robotCategory);
		} else {
			System.out.println("\n\t Using exsisting " + robotType + " robot and coloring it.");
		}
		return robotCategory;
	}
}

public class FlyweightPatternExample {

	public static void main(String[] args) throws Exception {
		RobotFactory robotFactory = new RobotFactory();
		System.out.println("\n***Flyweight Pattern Example ***\n");
		Robot myRobot;

		// Here we are trying to get 3 Small type robots
		for (int i = 0; i < 3; i++) {
			myRobot = RobotFactory.getRobotFromFactory("small");
			Thread.sleep(1000);

			// The extrinsic property color is supplied by the client code.
			myRobot.showMe(getRandomColor());
		}
		int numOfDistinctRobots = robotFactory.totalObjectsCreated();
		System.out.println("\n Till now, total no of distinct robot objects created: " + numOfDistinctRobots);
		
		// Here we are trying to get 5 Large type robots
		for (int i = 0; i < 5; i++) {
			myRobot = RobotFactory.getRobotFromFactory("large");
			Thread.sleep(1000);

			// The extrinsic property color is supplied by the client code.
			myRobot.showMe(getRandomColor());
		}
		numOfDistinctRobots = robotFactory.totalObjectsCreated();
		System.out.println("\n Till now, total no of distinct robot objects created: " + numOfDistinctRobots);
		
		// Here we are trying to get 4 fixed size robots
		for (int i = 0; i < 4; i++) {
			myRobot = RobotFactory.getRobotFromFactory("fixed");
			Thread.sleep(1000);

			// The extrinsic property color is supplied by the client code.
			myRobot.showMe(getRandomColor());
		}
		numOfDistinctRobots = robotFactory.totalObjectsCreated();
		System.out.println("\n Till now, total no of distinct robot objects created: " + numOfDistinctRobots);
	}

	static String getRandomColor() {
		Random r = new Random();
		/*
		 * I am simply checking the random number generated that can be either an even
		 * number or an odd number. And based on that we are choosing the color. For
		 * simplicity, I am using only two colors-red and green
		 */
		int random = r.nextInt();
		if (random % 2 == 0) {
			return "red";
		} else {
			return "green";
		}

	}

}
