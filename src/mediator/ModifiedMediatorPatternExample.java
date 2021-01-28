package mediator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

interface ModifiedMediator {
	void register(ModifiedEmployee employee);

	void sendMessage(ModifiedEmployee fromEmployee, ModifiedEmployee toEmployee, String msg)
			throws InterruptedException;
}

// ConcreteMediator
class ModifiedConcreteMediator implements ModifiedMediator {
	List<ModifiedEmployee> participants = new ArrayList<ModifiedEmployee>();

	@Override
	public void register(ModifiedEmployee employee) {
		participants.add(employee);
	}

	public void displayRegisteredEmployees() {
		System.out.println("At present ,registered participants are:");
		for (ModifiedEmployee employee : participants) {
			System.out.println(employee.getName());
		}
	}

	@Override
	public void sendMessage(ModifiedEmployee fromEmployee, ModifiedEmployee toEmployee, String msg)
			throws InterruptedException {
		/* if( fromEmployee.getClass().getSimpleName().equals("UnauthorizedUser")) */
		if (fromEmployee.employeeType() == "UnauthorizedUser") {
			System.out.println("[ALERT Everyone] An outsider named " + fromEmployee.getName()
					+ " trying to send some messages to " + toEmployee.getName());
			fromEmployee.receive(fromEmployee, ",you are not allowed to enter here.");
		} else if (participants.contains(fromEmployee)) {
			System.out.println(
					"-----" + fromEmployee.getName() + " posts some message at: " + LocalDateTime.now() + "-----");
			Thread.sleep(1000);
			// No need to inform everyone or himself
			// Only let the target receiver know
			if (participants.contains(toEmployee)) {
				toEmployee.receive(fromEmployee, msg);
			}
			// If target receipient does not exist
			else {
				System.out.println(fromEmployee.getName() + " , your target recipient does not exist");
			}
		}
		// An outsider tries to send message.
		else {
			System.out.println("[ALERT] An unregistered employee named " + fromEmployee.getName()
					+ " trying to send some messages to " + toEmployee.getName());
			System.out.println(fromEmployee.getName() + ", you need to register yourself first.");
		}
	}
}

// Employee
abstract class ModifiedEmployee {
	private ModifiedMediator mediator;
	protected String name;
	private boolean authorizedUser;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Constructor
	public ModifiedEmployee(ModifiedMediator mediator, String name, boolean authorizedUser) {
		this.mediator = mediator;
		this.name = name;
		this.authorizedUser = authorizedUser;
		if (this.authorizedUser) {
			mediator.register(this);
		}
	}

	// The following method name need not be same as the Mediator's method name
	public void send(ModifiedEmployee toFriend, String msg) throws InterruptedException {
		mediator.sendMessage(this, toFriend, msg);
	}

	// public abstract void receive(Friend fromFriend,String message);
	public void receive(ModifiedEmployee fromFriend, String message) {
		System.out.println(
				this.name + " received a message : " + message + " from an employee " + fromFriend.getName() + ".");
	}

	public abstract String employeeType();
}

//A concrete friend
class ModifiedConcreteEmployee extends ModifiedEmployee {
	public ModifiedConcreteEmployee(ModifiedMediator mediator, String name, boolean authorizedUser) {
		super(mediator, name, authorizedUser);
	}

	@Override
	public String employeeType() {
		return "ConcreteEmployee";
	}
}

//Unauthorized user
class UnauthorizedUser extends ModifiedEmployee {
	public UnauthorizedUser(ModifiedMediator mediator, String name) {
		// The user is always treated an unauthorized user.So, the flag is
		// false always.
		super(mediator, name, false);
	}

	@Override
	public void receive(ModifiedEmployee fromEmployee, String message) {
		System.out.println(this.name + message);
	}

	@Override
	public String employeeType() {
		return "UnauthorizedUser";
	}
}

public class ModifiedMediatorPatternExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("***Mediator Pattern Demo***\n");
		ModifiedConcreteMediator mediator = new ModifiedConcreteMediator();
		ModifiedEmployee Amit = new ModifiedConcreteEmployee(mediator, "Amit", true);
		ModifiedEmployee Sohel = new ModifiedConcreteEmployee(mediator, "Sohel", true);
		ModifiedEmployee Raghu = new ModifiedConcreteEmployee(mediator, "Raghu", true);

		// Unauthorized user
		ModifiedEmployee Jack = new ModifiedConcreteEmployee(mediator, "Jack", false);

		// Only two parameter needed to pass in the following case.
		ModifiedEmployee Divya = new UnauthorizedUser(mediator, "Divya");

		// Displaying the participant's list
		mediator.displayRegisteredEmployees();
		System.out.println("Communication starts among participants...");
		Amit.send(Sohel, "Hi Sohel,can we discuss the mediator pattern?");
		Sohel.send(Amit, "Hi Amit,Yup, we can discuss now.");
		
		// Boss is sending messages to each of them individually
		Raghu.send(Amit, "Please get back to work quickly.");
		Raghu.send(Sohel, "Please get back to work quickly.");
		
		// An unregistered employee(Jack) and an outsider(Divya) are also
		// trying to participate.
		Jack.send(Amit, "Hello Guys..");
		Divya.send(Raghu, "Hi Raghu");

	}

}
