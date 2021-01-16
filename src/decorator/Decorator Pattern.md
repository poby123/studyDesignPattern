## Decorator Pattern
### Definition
객체에 동적으로 책임을 추가할 수 있게 한다. Decorator 패턴은 기능의 유연한 확장을 위해서 상속 대신 사용할 수 있는 방법이다.
<hr>

### Diagram
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Decorator_UML_class_diagram.svg/600px-Decorator_UML_class_diagram.svg.png" width="700"/>
<hr>

### Objects
- Component : 동적으로 추가할 서비스를 가질 가능성이 있는 객체들에 대한 인터페이스
- ConcreteComponent : 추가적인 서비스가 실제로 정의되어야 할 필요가 있는 객체
- Decorator : Component 객체에 대한 참조자를 관리하면서 Component에 정의된 인터페이스를 만족하도록 인터페이스를 정의
- ConcreteDecorator : Component에 새롭게 추가할 서비스를 실제로 구현하는 클래스이고, Decorator에 정의된 기본 오퍼레이션을 만족하면서 추가적인 행위를 addBehavior 또는 addedState 로 처리한다.

<hr>

### 고려해야할 점
- Component는 장식을 추가할 베이스가 되는 역할이기 때문에 가능한 한 작고 가볍게 정의하자.
	- 가급적 인터페이스만 정의한다.
	- 무언가를 저장하는 변수는 정의하지 않는다. 
	- 저장할 것이 있다면 서브클래스에서 하도록.
- Decorator 와 Component가 같은 인터페이스를 갖도록 해야한다.
- 구현하려는 내용이 객체의 겉을 변경하려는 것인지, 속을 변경하려고 하는 것인지 생각하자.
	- 속을 변경하려는 것이라면 strategy-pattern 을 선택하는 것이 더 나을 수 있다.
- Decorator 패턴으로 구현한 후에 사용이 까다롭게 느껴지거나 자주 쓰는 조합이 있다면 다음 패턴을 고려해보자.
	- builder-pattern
	- factory-pattern
	- static-factory-method-pattern
- Decorator가 다른 Decorator에 대해 알아야할 필요가 있다면, 패턴의 사용의도와 어긋나는 작업일 수 있다.
	

### 장점
1. 이미 있는 구조는 건들지 않기 때문에, 이미 있는 구조에 새로운 버그가 생기지는 않는다.
2. 새로운 기능들을 쉽게 객체에 추가할 수 있다.
3. 처음부터 복잡한 클래스를 먼저 만든 다음에 기능을 확장하려고 하면 이것은 꽤나 지루한 과정이 될 수 있는데, Decorator 패턴을 사용하면 처음 디자인을 구상하는 단계에서 모든 기능들을 예측하거나 구현하지 않아도 된다. 즉 점차적으로 개발할 수 있다.

<hr/>

### 단점
당신이 충분히 고려해서 사용한다면 눈에 띄는 단점은 없을 것이다. 다만 너무 많은 데코레이터를 만들면, 그때는 시스템을 유지보수하는 것이 힘들어질 수 있다는 사실을 알아야한다. 