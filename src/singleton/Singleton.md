## Singleton Pattern
### Definition
클래스가 오직 하나의 인스턴스만 가지도록 하고, 그 인스턴스에 접근할 수 있는 global한 지점을 제공하는 것을 말한다.

### Concept
하나의 클래스가 여러개의 인스턴스를 가지지 못하도록 한다.
하나의 인스턴스가 만들어지고 나면, 이후에는 계속 이미 존재하는 인스턴스를 이용하게 된다.
싱글톤 패턴은 중앙 집중화된 시스템에서 불필요한 객체생성을 제한하는데 도움을 주며, 유지보수를 쉽게 해준다.

### 주의
싱글톤을 구현할 때는 멀티 스레드 환경에서도 Thread-safe 하여, 단 하나의 인스턴만 가지도록 보장해야한다.

### 구현
1. Eager Initialization
2. Lazy Initialization - Synchronized
3. Lazy Initialization - Double Checking Locking
4. Lazy Initialization - Lazy Holder