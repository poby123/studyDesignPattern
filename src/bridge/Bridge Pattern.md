## Bridge Pattern
### Definition
추상화를 그 구현부분으로부터 분리시켜서, 각각 독립적으로 변형할 수 있게 한다. 구현과 추상화 개념을 분리함으써 하나의 추상화 개념으로 다양한 변형을 할 수 있게되며, 구현과 독립적으로 인터페이스도 다양함을 가질 수 있게 된다.

### Concept
이 패턴은 handle/body 패턴으로도 알려져있는데, 이는 추상화와 구현을 분리하고, 각각의 상속 구조를 만드는 것이다. 이것들을 bridge를 통해 연결할 수 있다. <br>
추상화(abstraction)와 구현은, 인터페이스나 추상 클래스를 통해 나타내질 수 있지만, 추상화는 그 구현하는 부분에 대한 참조를 가지고 있다는 점을 주목해야한다. 보통 추상화의 자식은 refined abstraction 으로 불리며, 그 자식의 구현은 concrete implementation이라고 부른다.
<br>
이러한 bridge 인터페이스는 concrete 클래스들의 기능적인 부분을, 인터페이스를 구현하는 클래스로부터, 독립적으로 만들어준다.

### Diagram
<img src="https://www.java2blog.com/wp-content/uploads/2012/09/BridgeDesignPatternGeneric.gif"/>

### Objects
- Abstraction : 추상화 개념에 대한 인터페이스를 제공하고, 객체 구현자(implementor)에 대한 참조자를 관리한다.
- RefinedAbstraction : 추상화 개념에 정의된 인터페이스를 확장한다.
- Implementor: 구현 클래스에 대한 인터페이스를 제공한다. 다시 말해 실질적인 구현을 제공한 서브 클래스들에 있어서 공통적인 연산의 시그니처만을 정의하고 있다. 이 인터페이스는 Abstraction 클래스에 정의된 인터페이스에 정확하게 대응할 필요가 없다. 즉, 두 인터페이스는 서로 다른 형태일 수 있다는 것이다. 일반적으로 Implementor 인터페이스는 기본적인 구현 연산을 수행하고, Abstraction은 보다 추상화된 서비스 관점의 인터페이스를 제공한다. 따라서, 서비스 관점의 인터페이스를 구현하기 위해서는 Implementor에 정의된 여러 개의 연산이 필요할 수도 있다.
- ConcreteImplementor : Implementor 인터페이스를 구현하는 것으로 실제적인 구현이 이루어진다. 구현 방식이 달라지면 지속적으로 만들어지는 클래스다.