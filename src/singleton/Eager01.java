package singleton;

class Captain2 {
	/*
	 * Early initialization 
	 * ���� : 
	 * 1. �������̰�, ����ϴ�. 
	 * 2. Lazy initialization���� �ݴ������� ������ thread-safe �ϴ�. 
	 * 3. ��� ���� �̹� �޸𸮿� �ε�Ǳ� ������, ���α׷��� ����� �� �����ð��� ª��.
	 * 
	 * ���� : 
	 * 1. ���α׷��� ���۵Ǳ���� �ð��� ���� ���� �ɸ���. ��� ���� �޸𸮿� �÷����ϱ� �����̴�.
	 * 
	 * ���� :
	 * Captain2 �ν��Ͻ��� ���� ������ �ʴ� ��쿡��, �ν��Ͻ�ȭ�� �Ͼ�� �ʴ´�.
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
