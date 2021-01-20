package visitor;

import java.util.ArrayList;
import java.util.List;

interface Employee {
	void printStructures();

	void acceptVisitor(ModifiedVisitor visitor);
}

class CompositeEmployee implements Employee {

	private String name;
	private String dept;
	private final int yearsOfExperience;
	private List<Employee> controls;

	public CompositeEmployee(String name, String dept, int experience) {
		this.name = name;
		this.dept = dept;
		this.yearsOfExperience = experience;
		controls = new ArrayList<Employee>();
	}

	public void addEmployee(Employee e) {
		controls.add(e);
	}

	public void removeEmployee(Employee e) {
		controls.remove(e);
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public int getExperience() {
		return yearsOfExperience;
	}

	public List<Employee> getControls() {
		return this.controls;
	}

	@Override
	public void printStructures() {
		System.out.println("\t" + getName() + " works in  " + getDept() + " Experience :" + getExperience() + " years");
		for (Employee e : controls) {
			e.printStructures();
		}
	}

	@Override
	public void acceptVisitor(ModifiedVisitor visitor) {
		visitor.visitTheElement(this);
	}
}

class SimpleEmployee implements Employee {
	private String name;
	private String dept;
	private int yearsOfExperience;

	// Constructor
	public SimpleEmployee(String name, String dept, int experience) {
		this.name = name;
		this.dept = dept;
		this.yearsOfExperience = experience;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return this.dept;
	}

	public int getExperience() {
		return yearsOfExperience;
	}

	@Override
	public void printStructures() {
		System.out
				.println("\t\t" + getName() + " works in  " + getDept() + " Experience :" + getExperience() + " years");
	}

	@Override
	public void acceptVisitor(ModifiedVisitor visitor) {
		visitor.visitTheElement(this);
	}
}

interface ModifiedVisitor {
	void visitTheElement(CompositeEmployee employees);

	void visitTheElement(SimpleEmployee employee);
}

class ModifiedConcreteVisitor implements ModifiedVisitor {
	@Override
	public void visitTheElement(CompositeEmployee employee) {
		// We'll promote them if experience is greater than 15 years
		boolean eligibleForPromotion = employee.getExperience() > 15 ? true : false;
		System.out.println("\t\t" + employee.getName() + " from  " + employee.getDept() + " is eligible for promotion? "
				+ eligibleForPromotion);
	}

	@Override
	public void visitTheElement(SimpleEmployee employee) {
		// We'll promote them if experience is greater than 12 years
		boolean eligibleForPromotion = employee.getExperience() > 12 ? true : false;
		System.out.println("\t\t" + employee.getName() + " from  " + employee.getDept() + " is eligible for promotion? "
				+ eligibleForPromotion);
	}
}

public class ModifiedVisitorPatternExample {

	public static void main(String[] args) {
		System.out.println("***Visitor Pattern combined with Composite Pattern Demo***\n");

		SimpleEmployee mathTeacher1 = new SimpleEmployee("Math Teacher-1", "Maths", 13);
		SimpleEmployee mathTeacher2 = new SimpleEmployee("Math Teacher-2", "Maths", 6);
		SimpleEmployee cseTeacher1 = new SimpleEmployee("CSE Teacher-1", "Computer Sc.", 10);
		SimpleEmployee cseTeacher2 = new SimpleEmployee("CSE Teacher-2", "Computer Sc.", 13);
		SimpleEmployee cseTeacher3 = new SimpleEmployee("CSE Teacher-3", "Computer Sc.", 7);

		CompositeEmployee hodMaths = new CompositeEmployee("Mrs.S.Das(HOD-Maths)", "Maths", 14);
		CompositeEmployee hodCompSc = new CompositeEmployee("Mr. V.Sarcar(HOD-CSE)", "Computer Sc.", 16);

		CompositeEmployee principal = new CompositeEmployee("Dr.S.Som(Principal)", "Planning-Supervising-Managing", 20);

		hodMaths.addEmployee(mathTeacher1);
		hodMaths.addEmployee(mathTeacher2);

		hodCompSc.addEmployee(cseTeacher1);
		hodCompSc.addEmployee(cseTeacher2);
		hodCompSc.addEmployee(cseTeacher3);

		principal.addEmployee(hodMaths);
		principal.addEmployee(hodCompSc);
		System.out.println("\n Testing the overall structure");

		// Prints the complete structure
		principal.printStructures();
		System.out.println("\n***Visitor starts visiting our composite structure***\n");
		System.out.println("---The minimum criteria for promotion is as follows ---");
		System.out.println("--Junior Teachers-12 years and Senior teachers-15 years.--\n");
		ModifiedVisitor myVisitor = new ModifiedConcreteVisitor();

		List<Employee> employeeContainer = new ArrayList<Employee>();
		for (Employee e : principal.getControls()) {
			employeeContainer.add(e);
		}
		for (Employee e : hodMaths.getControls()) {
			employeeContainer.add(e);
		}
		for (Employee e : hodCompSc.getControls()) {
			employeeContainer.add(e);
		}
		for (Employee e : employeeContainer) {
			e.acceptVisitor(myVisitor);
		}

	}

}
