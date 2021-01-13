package singleton;

public class LazyHolder04 {

	private LazyHolder04() {
	}

	/*
	 * Static Member Class
	 * 이 클래스의 변수가 없기 때문에, 클래스 로더가 초기화를 할 때 초기화되지 않고,
	 * getInstance 메서드를 호출할 때 초기화된다. 즉 동적 바인딩(런타임시 성격이 결정)이 일어나며
	 * Thread-safe 하면서도 성능은 뛰어나다. 싱글톤을 사용하려고 할 때 가장 많이 사용되는 방법이다.
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
