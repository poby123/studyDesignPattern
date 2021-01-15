package proxy;


// Abstract class Subject
abstract class Subject{
	public abstract String doSomeWork();
}

// Concrete Subject Class
class ConcreteSubject extends Subject{
	@Override
	public String doSomeWork() {
		System.out.println("doSomeWord() inside ConcreteSubject is invoked.");
		return "Return from doSomeWork() inside ConcreteSubejct";
	}
}

/*
 * proxy Class : It will try to invoke the doSomeWork()
 * of a Concrete instance
 * */
class Proxy extends Subject{
	static Subject cs;
	
	@Override
	public String doSomeWork() {
		System.out.println("Proxy call happending now...");
		
		// Lazy initialization
		if(cs == null) {
			cs = new ConcreteSubject();
		}
		
		// �븮�ڴ� ���� ��ü�� ��ȯ ����� �״�� �����Ѵ�.
		return cs.doSomeWork();
	}
}

public class ProxyPatternExample {

	public static void main(String[] args) {
		System.out.println("*** Proxy Pattern Demo ***\n");
		Proxy px = new Proxy();
		px.doSomeWork();
	}

}
