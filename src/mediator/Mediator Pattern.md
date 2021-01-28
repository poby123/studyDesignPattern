## Mediator Pattern
### Definition
객체들간의 상호작용을 객체로 캡슐화한다. Mediator 패턴은 객체들간의 참조관계를 객체에서 분리함으로써 상호작용만을 독립적으로 다양하게 확대할 수 있다.

### Diagram
<img src="https://www.baeldung.com/wp-content/uploads/2019/03/mediator.png"/>


### Objects
- Mediator : Colleague 객체와 교류하는데 필요한 인터페이스를 정의한다.
- ConcreteMediator: Colleague 객체와 조화를 이룸으로써 이루어지는 협력 행위를 구현하고 자신의 colleague가 무엇인지를 알고 이를 관리한다.
- Colleague: Mediator 객체가 누구인지를 안다. 다른 객체와 연결성을 필요하면 Mediator를 통해 이루어지도록 한다.
