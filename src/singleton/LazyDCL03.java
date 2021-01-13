package singleton;

/*
 * Lazy Initialization.
 * Double Checking Locking.
 * Thread-safe.
 * */
public class LazyDCL03 {
	/*
	 * volatile : volatile ������ ������� �ʴ� ��Ƽ �����忡���� �۾��� �����ϴ� ���� Main Memory���� ���� ������
	 * CPU cache�� �����ϴµ�, ��Ƽ ������ ȯ�濡���� ������ �����尡 ������ CPU cache�� ���� �޶��� �� �ֱ� ������ ���� ��
	 * ����ġ ������ �߻��ϰ� �ȴ�. volatile ������ ���� CPU cache�� �ƴ� Main Memory���� �����ϸ� �б� ������ �̷���
	 * ������ ������ �� �ִ�.
	 */
	private volatile static LazyDCL03 uniqueInstance;

	private LazyDCL03() {
	}

	// Lazy Initialization. DCL
	public static LazyDCL03 getInstance() {
		if (uniqueInstance == null) {

			/*
			 * ��Ƽ ������ ȯ�濡���� �ν��Ͻ� ������ ����ȭ���� ����ؼ�, �� ���� �ϳ��� �����常 ������ �� �ֵ��� �ؾ��ϸ�, 
			 * ���� �ϳ��� ��ü�� �����ϴ� ���� �����ؾ� �Ѵ�.
			 */
			synchronized (LazyDCL03.class) {
				if (uniqueInstance == null) {
					System.out.println("Instance is created!");
					uniqueInstance = new LazyDCL03();
				}
			}
		}
		System.out.println("Return Instance.");
		return uniqueInstance;
	}

	public static void main(String[] args) {
		LazyDCL03 s = LazyDCL03.getInstance();
		LazyDCL03 s2 = LazyDCL03.getInstance();
	}
}
