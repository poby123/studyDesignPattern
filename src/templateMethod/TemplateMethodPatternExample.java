package templateMethod;

abstract class BasicEngineering {
	public final void completeCourse() {
		completeMath();
		completeSoftSkills();
		completeSpecialPaper();
		
		if(isAdditionalPapersNeeded()) {
			completeAdditionalPapers();
		}
	}

	private void completeMath() {
		System.out.println("1. Mathematics");
	}

	private void completeSoftSkills() {
		System.out.println("2. SoftSkills");
	}

	public abstract void completeSpecialPaper();
	
	private void completeAdditionalPapers() {
		System.out.println("4. Additional Papers are needed for this course.");
	}
	
	boolean isAdditionalPapersNeeded() {
		return true;
	}
}

class ComputerScience extends BasicEngineering {
	@Override
	public void completeSpecialPaper() {
		System.out.println("3. OOP");
	}
}

class Electronics extends BasicEngineering{
	@Override
	public void completeSpecialPaper() {
		System.out.println("3. Digital Logic and Circuit Theory");
	}
	
	@Override
	boolean isAdditionalPapersNeeded() {
		return false;
	}
}

public class TemplateMethodPatternExample {

	public static void main(String[] args) {
		System.out.println("*** Templeate Method Pattern Demo ***");
		BasicEngineering preferredCourse = new ComputerScience();
		System.out.println("Computer Sc. course will be completed in following order : ");
		preferredCourse.completeCourse();
		System.out.println();
		
		preferredCourse = new Electronics();
		System.out.println("Electronics course will be completed in following order : ");
		preferredCourse.completeCourse();
	}

}
