package singleton;

class Captain2 {
	/*
	 * Early initialization 
	 * 장점 : 
	 * 1. 직관적이고, 깔끔하다. 
	 * 2. Lazy initialization과는 반대이지만 여전히 thread-safe 하다. 
	 * 3. 모든 것이 이미 메모리에 로드되기 때문에, 프로그래밍 실행될 때 지연시간이 짧다.
	 * 
	 * 단점 : 
	 * 1. 프로그램이 시작되기까지 시간이 비교적 오래 걸린다. 모든 것을 메모리에 올려야하기 때문이다.
	 * 
	 * 주의 :
	 * Captain2 인스턴스가 전혀 사용되지 않는 경우에는, 인스턴스화가 일어나지 않는다.
	 */
	private static final Captain2 captain = new Captain2();

	private Captain2() {
		System.out.println("A captain is elected for your team.");
	}

	public static Captain2 getCaptain() {
		System.out.println("You have a captain for your team.");
		return captain;
	}

	public static void dummyMethod() {
		System.out.println("It is a dummy method");
	}
}

public class Eager01 {

	public static void main(String[] args) {
		System.out.println("*** Singleton Pattern Demo With Eager Initialization ***\n");
		Captain2.dummyMethod();
		Captain2 c1 = Captain2.getCaptain();

		System.out.println("Trying to make another captain.");
		Captain2 c2 = Captain2.getCaptain();

		if (c1 == c2) {
			System.out.println("c1 and c2 are same instance.");
		}
	}

}
