## State Pattern
### Definition
객체의 내부상태에 따라 행위를 변경할 수 있게 한다. 이렇게 하면 객체는 마치 클래스를 바꾸는 것처럼 보인다.

### Diagram
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/State_Design_Pattern_UML_Class_Diagram.svg/400px-State_Design_Pattern_UML_Class_Diagram.svg.png"/>

### Objects
- Context : 클라이언트가 관심을 갖고 있는 인터페이스를 정의한다. ConcreteState 서브 클래스의 인스턴스를 관리하고 있는데, ConcreteState의 서브 클래스들이 객체의 현재 상태를 정의하고 있다.
- State : Context가 갖는 각 상태별로 필요한 행위를 캡슐화하여 인터페이스로 정의한다.
- ConcreteState Subclass : 각 서브클래스들은 Context의 상태에 따라 처리되어야할 실제 행위를 구현하고 있다.