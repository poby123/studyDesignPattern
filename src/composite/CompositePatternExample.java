package composite;

import java.util.ArrayList;
import java.util.List;

interface IEmployee {
	void printStructures();

	int getEmployeeCount();
}

class CompositeEmployee implements IEmployee {
	private int employeeCount = 0;
	private String name;
	private String dept;

	// Container for child objects
	private List<IEmployee> controls;

	// Constructor
	public CompositeEmployee(String name, String dept) {
		this.name = name;
		this.dept = dept;
		controls = new ArrayList<IEmployee>();
	}

	public void addEmployee(IEmployee e) {
		controls.add(e);
	}

	public void removeEmployee(IEmployee e) {
		controls.remove(e);
	}

	@Override
	public void printStructures() {
		System.out.println("\t" + this.name + " works in " + this.dept);
		for (IEmployee e : controls) {
			e.printStructures();
		}
	}

	@Override
	public int getEmployeeCount() {
		employeeCount = controls.size();
		for (IEmployee e : controls) {
			employeeCount += e.getEmployeeCount();
		}
		return employeeCount;
	}

}

class Employee implements IEmployee {
	private String name;
	private String dept;
	private int employeeCount = 0;

	// Constructor
	public Employee(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}

	@Override
	public void printStructures() {
		System.out.println("\t\t" + this.name + " works in " + this.dept);
	}

	@Override
	public int getEmployeeCount() {
		return employeeCount;
	}
}

public class CompositePatternExample {

	public static void main(String[] args) {
		System.out.println("*** Composite Pattern Demo ***");
		Employee mathTeacher1 = new Employee("Math Teacher-1", "Maths");
		Employee mathTeacher2 = new Employee("Math Teacher-2", "Maths");

		Employee cseTeacher1 = new Employee("CSE Teacher-1", "Computer Sc.");
		Employee cseTeacher2 = new Employee("CSE Teacher-2", "Computer Sc.");
		Employee cseTeacher3 = new Employee("CSE Teacher-3", "Computer Sc.");

		// The College has 2 head of Departments, Maths, Computer Sc.
		CompositeEmployee hodMaths = new CompositeEmployee("Mrs.S.Das(HOD-Maths)", "Maths");
		CompositeEmployee hodCompSc = new CompositeEmployee("Mrs.V.Sarcar(HOD-CSE)", "Computer Sc.");

		// Principal of the college
		CompositeEmployee principal = new CompositeEmployee("Dr.S.Som(Principal)", "Planning-Supervising-Managing");

		hodMaths.addEmployee(mathTeacher1);
		hodMaths.addEmployee(mathTeacher2);

		hodCompSc.addEmployee(cseTeacher1);
		hodCompSc.addEmployee(cseTeacher2);
		hodCompSc.addEmployee(cseTeacher3);

		principal.addEmployee(hodMaths);
		principal.addEmployee(hodCompSc);

		// Prints the complete structure
		principal.printStructures();
		System.out.println(
				"At present Principal has control over " + principal.getEmployeeCount() + " number of employees.");
		System.out.println("\n Testing the structure of a HOD-CSE object:");
		// Prints the details of Computer Sc, department
		hodCompSc.printStructures();
		System.out.println(
				"At present HOD-CSE has control over " + hodCompSc.getEmployeeCount() + " number of employees.");
		System.out.println("\n Testing the structure of a HOD-Maths object:");
		// Prints the details of Mathematics department
		hodMaths.printStructures();
		System.out.println(
				"At present HOD-Maths has control over " + hodMaths.getEmployeeCount() + " number of employees.");
		
		// Leaf node
		System.out.println("\n Testing the structure of a leaf node:");
		mathTeacher1.printStructures();
		System.out.println("At present Math Teacher-1 has control over " + mathTeacher1.getEmployeeCount()
				+ " number of employees.");
		/*
		 * Suppose, one computer teacher is leaving now from the organization
		 */
		hodCompSc.removeEmployee(cseTeacher2);
		System.out.println("\n After CSE Teacher-2 resigned, the organization has following members:");
		principal.printStructures();
		System.out.println(
				"At present Principal has control over " + principal.getEmployeeCount() + " number of employees");
		System.out.println(
				"At present HOD-CSE has control over " + hodCompSc.getEmployeeCount() + " number of employees");
		System.out.println(
				"At present HOD-Maths has control over " + hodMaths.getEmployeeCount() + " number of employees");
	}

}
