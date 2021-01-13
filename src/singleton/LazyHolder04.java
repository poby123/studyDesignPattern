package singleton;

public class LazyHolder04 {

	private LazyHolder04() {
	}

	/*
	 * Static Member Class
	 * �� Ŭ������ ������ ���� ������, Ŭ���� �δ��� �ʱ�ȭ�� �� �� �ʱ�ȭ���� �ʰ�,
	 * getInstance �޼��带 ȣ���� �� �ʱ�ȭ�ȴ�. �� ���� ���ε�(��Ÿ�ӽ� ������ ����)�� �Ͼ��
	 * Thread-safe �ϸ鼭�� ������ �پ��. �̱����� ����Ϸ��� �� �� ���� ���� ���Ǵ� ����̴�.
	 * */
	private static class InnerInstanceClass {
		private static final LazyHolder04 uniqueInstance = new LazyHolder04();
	}

	public static LazyHolder04 getInstance() {
		return InnerInstanceClass.uniqueInstance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
