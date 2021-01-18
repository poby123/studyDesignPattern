## Flyweight Pattern
### Definition
많은 수의 <mark>fine-grained</mark> 객체들을 효율적으로 지원하기 위해 공유를 사용한다.<br>
즉 작은 크기의 객체들이 여러 개 있는 경우, 객체를 효과적으로 사용하는 방법으로써 객체를 공유하게 한다.<br>
중복 생성될 가능성이 높거나 자원 생성비용이 큰 객체를 재사용하는 패턴이다.

> fine-grained : grain은 원래 보리나 밀 같은 곡식을 낟알로 만드는 작업이나 표면을 우둘투둘하게 하는 일을 뜻하는데, 그때 아주 곱고 섬세하게 하느냐
듬성 듬성 크게 하느냐에 따라 fine과 coarse라는 형용사를 붙인다. 이것이 컴퓨터공학에서는 어떤 프로세스를 아주 잘게 쪼개느냐(fine), 크게 쪼개느냐(coarse)의 의미로 쓰인다.

<hr>

### Concept
flyweight란, 여러 개의 컨텍스트안에서 동시에 사용될 수 있는 공유객체이다. 이 flyweight는 각각의 컨텍스트안에서 독립적인 객체로써 행동한다(공유되지 않는 객체의 인스턴스와 구별되지 않는다.)<br>
이 패턴을 고려할 때, 다음과 같은 점을 기억할 필요가 있다.
- 이 패턴은 일반적으로 적은 매개변수를 가지고 있고, 대부분의 객체들이 공통점이 많은 유니크한 여러 개의 비슷한 객체들이 필요할 때 유용하다.
- flyweight는 객체이다. 공유 데이터를 가능한 한 많이 사용함으로써 메모리의 사용을 줄인다.
- 두 가지 용어가 자주 나온다. extrinsic(외적인) 과 intrinsic(본질적인). intrinsic 상태는 flyweight 객체안에서 저장되고 공유되고 있는 상태이며, flyweight의 context와 독립적이다. 반면에 extrinsic 상태는 flyweight의 context와 함께 다양한데, 이것이 이것들이 공유될 수 없는 이유이다. 클라이언트 객체들은 extrinsic 상태를 유지하고, 그 객체들은 flyweight로 그것들을 전달할 필요가 있다. 만약 요구된다면, flyweight를 사용할 때, 클라이언트들은 또 extrinsic 상태의 있는 것을 계산할 수 있다는 점을 주목하자.

### Diagram
출처 : https://ultteky.tistory.com/35 <br>
<img src="https://lh3.googleusercontent.com/proxy/iWyx8H3C2vWRmU5iHBRcrYTYt2NM4n1P6BP6UtJkbMsxbj4JIqNTOrNgXjt0gtyNMfJMXxs06Wmlf2uw-hpwPYnJggmmO9zQU_JNZ3FxHTgs-E7c1wubsWuxGfwYz7aLHILI9RLLyETxC2VOcmGG4EGGi9f_4TvZFivz7JIQzd0KFqy6T4LuOUqU54lmRqo"/>

### 객체들
- Flyweight : Flyweight가 받아들일 수 있고, 부작적 상태에서 동작해야하는 인터페이스를 선언한다.
- ConcreteFlyweight : Flyweight 인터페이스를 구현하고 내부적으로 갖고 있어야 하는 본질적 상태에 대한 저장소를 정의하고 있다. ConcreteFlyweight 객체는 공유할 수 있는 것이어야 한다. 그러므로 관리하는 어떤 상태는 본질적인 것이어야 한다.
- UnsharedConcreteFlyweight : 모든 Flyweight 서브클래스들이 공유될 필요는 없다. Flyweight 인터페이스는 공유를 가능하게 하지만 그것을 강요해서는 안된다. UnsharedConcreteFlyweight 객체가 ConcreteFlyweight 객체를 자신의 자식으로 갖는 것은 흔한 일이다.
- FlyweightFactory : Flyweight 객체를 생성하고 관리한다. Flyweight가 적절히 공유되도록 보장해야한다. 클라이언트에서 Flyweight를 요청하면 FlyweightFactory 객체는 이미 존재하는 인스턴스를 제공하거나, 존재하지 않는다면 생성해야한다.