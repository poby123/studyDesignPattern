## Facade Pattern
### Definition 
하위시스템에 있는 인터페이스들에 대해 통합된 하나의 인터페이스를 제공한다. Facade는 하위 시스템을 사용하기 쉽게 해주는 높은 수준의 인터페이스를 정의한다.

### Concept
Facade는 클라이언트의 삶을 쉽게 만들어준다. 여러 개의 일을 처리해야할 필요가 있는 여러개의 객체가 있는 복잡한 시스템이 있다고 생각해보자. <br>
그리고 당신은 그 시스템과 상호작용해야한다. 이러한 상황에서 facade는 객체들의 생성과, 올바른 순서대로 일을 처리할 수 있게 해주는 등의 <br>
모든 일을 관리하는 단순화된 인터페이스를 제공해줄 수 있다. 결과적으로 여러 개의 객체들과 상호작용하는 대신 단 하나의 객체와 상호작용하면 된다.<br><br>
Facade는 느슨한 결합을 지원하는 패턴들중에 하나이다. 간단한 인터페이스를 높임으로써 추상화정도를 높이고, 복잡한 부분을 감출 수 있다. <br>
결과적으로 코드는 더 깔끔해지고, 좋아진다.

### Diagram
출처 : http://gyanendushekhar.com/2016/08/21/facade-design-pattern-c/ <br>
<img src="https://gyanendushekhar.com/wp-content/uploads/2016/08/Facade-Design-Pattern-in-C-UML-Diagram.png"/><br>

- Facade : 단순하고 일관된 통합 인터페이스를 제공하며, 서브 시스템을 구성하는 어떤 클래스가 어떤 요청을 처리해야는지 모두 알고있다.<br> 클라이언트의 요청이 들어오면 해당하는 서브 시스템 객체에 요청을 전달한다.
- Subsystem classes : Facade 객체가 시키는대로, 실제로 작업을 처리하지만 Facade에 대해서는 어떤 정보도 가지고 있지 않다.