package singleton;

/*
 * Lazy Initialization.
 * Double Checking Locking.
 * Thread-safe.
 * */
public class LazyDCL03 {
	/*
	 * volatile : volatile 변수를 사용하지 않는 멀티 스레드에서는 작업을 수행하는 동안 Main Memory에서 읽은 변수를
	 * CPU cache에 저장하는데, 멀티 스레드 환경에서는 각각의 스레드가 저장한 CPU cache의 값이 달라질 수 있기 때문에 변수 값
	 * 불일치 문제가 발생하게 된다. volatile 변수는 값을 CPU cache가 아닌 Main Memory에만 저장하며 읽기 때문에 이러한
	 * 문제를 예방할 수 있다.
	 */
	private volatile static LazyDCL03 uniqueInstance;

	private LazyDCL03() {
	}

	// Lazy Initialization. DCL
	public static LazyDCL03 getInstance() {
		if (uniqueInstance == null) {

			/*
			 * 멀티 스레드 환경에서의 인스턴스 생성은 동기화블럭을 사용해서, 한 번에 하나의 스레드만 접근할 수 있도록 해야하며, 
			 * 오직 하나의 객체만 생성하는 것을 보장해야 한다.
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
