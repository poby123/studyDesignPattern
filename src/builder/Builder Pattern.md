## Builder Pattern

### Definition
복잡한 객체의 생성과정과 표현 방법을 분리해서 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴이다.
<hr>

### Concept
Builder Pattern은 여러 부분을 가지고 있는 복잡한 객체를 생성할 때 유용하다. <br>
객체의 생성 방식은 객체의 부분과 독립적이어야 하며, 객체의 생성 과정에서는 객체의 부분이 어떻게 합쳐지는지 신경쓰지 않을 수 있도록 해야한다.<br>
그리고 똑같은 생성과정에서도 다른 객체의 표현을 할 수 있어야 한다.<br>
복잡한 객체를 만들어야하는데, 그 객체가 변하지 않아야 하는 객체라면 Builder Pattern이 좋은 선택이 될 수 있다.
<hr>

### Pattern Diagram : Director -> Builder <- ConcreteBuilder -> Product
#### Product
우리가 만들고 싶은 복잡한 객체.<br>

#### ConcreteBuilder
추상 인터페이스인 Builder를 구현한 것으로, Product의 부분들을 생성하고 조립해준다.<br>
이를 위해 Product의 내부적인 표현을 세우고, 생성방식과 조립방식을 정의한다.

#### Director
Builder 인터페이스를 이용해서 최종적인 객체를 만든다.<br>
즉 Director가 Builder를 이용하고, 각각의 절차를 제어하여 최종적인 객체를 만드는 것이다.
<hr>

### Example1 Participants
1. Builder
2. Car : ConcreteBuilder
3. MotorCycle : ConcreteBuilder
4. Product
5. Director