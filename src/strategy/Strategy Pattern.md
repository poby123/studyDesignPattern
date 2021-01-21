## Strategy Pattern
### Definition
알고리즘군이 존재하는 경우, 각각의 알고리즘을 별도의 클래스로 캡슐화하고, 이들을 상호교환 가능한 것으로 정의한다. Strategy 패턴은 클라이언트에 영향을 주지 않고, 독립적으로 알고리즘을 다양하게 변경할 수 있게 해준다.

### Diagram
<img src="https://gmlwjd9405.github.io/images/design-pattern-strategy/strategy-pattern.png" width="700"/>

### Objects
- Strategy : 외부에서 동일한 방식으로 알고리즘을 호출하는 방법을 명시.
- Concrete Strategy : 알고리즘을 실제로 구현한 클래스
- Context : 이 패턴을 이용하는 역할을 수행하며, 필요에 따라 동적으로 구체적인 전략을 바꿀 수 있는 setter 메서드를 제공한다.