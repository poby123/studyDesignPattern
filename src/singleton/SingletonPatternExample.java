package singleton;

//����� ���´�.
final class Captain {
	private static Captain captain;

	private Captain() { }

	// multi-thread�� ���������ϴ� ���� ���� ���� synchronized Ű���带 ����Ѵ�.
	public static synchronized Captain getCaptain() {
		/*
		 * Lazy initialization : �ʱ�ȭ ����.
		 * ��ü ������ ���߿� �ϴ� ������, �ʿ��� ��쿡�� ��ü�� ����� ���̴�.
		 * �� ����� ��ü�� ����� ���� ���� ����� ��� ���μ����� ó���� �� �����ϴ�.
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
