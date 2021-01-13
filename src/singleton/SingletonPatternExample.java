package singleton;

//상속을 막는다.
final class Captain {
	private static Captain captain;

	private Captain() { }

	// multi-thread로 동시접근하는 것을 막기 위해 synchronized 키워드를 사용한다.
	public static synchronized Captain getCaptain() {
		/*
		 * Lazy initialization : 초기화 지연.
		 * 객체 생성을 나중에 하는 것으로, 필요한 경우에만 객체를 만드는 것이다.
		 * 이 방법은 객체를 만들기 위해 많은 비용이 드는 프로세스를 처리할 때 유용하다.
		 * */
		if (captain == null) {
			captain = new Captain();
			System.out.println("New captain is elected for your team.");
		} else {
			System.out.println("You already have a captain for your team");
			System.out.println("Send him for the toss");
		}
		return captain;
	}
}

public class SingletonPatternExample {

	public static void main(String[] args) {
		System.out.println("*** Singleton pattern Demo ***\n");

		System.out.println("Trying to make captain.");
		// Captain c3 = new Captain(); //error, constructor is private.
		Captain c1 = Captain.getCaptain();

		System.out.println("Trying to make another captain.");
		Captain c2 = Captain.getCaptain();

		if (c1 == c2) {
			System.out.println("c1 and c2 are same instance");
		}
	}

}
