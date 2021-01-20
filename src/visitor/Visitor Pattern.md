## Visitor Pattern
### Definition
어떤 객체 구조에서의 요소들에 수행되어져야할 연산을 나타낸다. Visitor은 연산이 처리할 요소들의 클래스를 수정하지 않고도 새로운 연산을 정의할 수 있도록 해준다.

### Concept
이 패턴은 상응하는 클래스들을 수정없이도, 객체들에 새로운 연산을 정의할 수 있도록 도와준다. 이상적으로 visitors는 새로운 기능을 지원하기 위해 클래스의 객체와 함께 하는 class-specific 메서드를 정의한다. 어떤 객체구조로부터 알고리즘을 분리하고, 새로운 계층을 이용해서 새로운 연산을 추가할 수 있다. 그래서 이 패턴은 open/close 원칙(확장은 허용되지만, 클래스나 함수와 같은 것들의 수정은 허용되지 않는다.)을 지원한다. 이 패턴은 composite pattern과 함께 사용할 때 위력을 실감할 수 있다.

### Diagram
<img src="https://upload.wikimedia.org/wikipedia/en/thumb/e/eb/Visitor_design_pattern.svg/430px-Visitor_design_pattern.svg.png"/>

### Objects
- Visitor: 각 ConcreteElement 클래스에 대한 Visit 연산(Operation)을 선언한다. 연산의 이름과 인터페이스의 형태는 Visit() 요청을 보내는 방문자에게 보내는 클래스를 명시한다. 이로써 방문자는 방문할 요소의 실제 서브 클래스를 결정한다. 그리고 나서 방문자는 Element가 제공하는 인터페이스를 통해 직접 Element 객체에 접근할 수 있다.
- ConcreteVisitor : Visitor 클래스에 정의된 연산을 구현한다. 각 연산은 객체에 해당하는 클래스에 정의된 알고리즘을 구현한다. ConcreteVisitor 클래스는 내부 상태를 저장하고 있으며, 알고리즘이 운영될 수 있는 상황 정보를 제공한다.
ConcreteVisitor 클래스가 저장하고 있는 내부 상태는 구조의 순회 과정에서 도출되기도 한다.
- Element : 인자로 Visitor 클래스를 받아들이는 Accept() 연산을 정의한다.
- ConcreteElement : 인자로 Visitor 객체를 받아들이는 Accept() 연산을 구현한다.
- ObjectStructure : 요소들을 나열하고 방문자로 하여금 이들 요소에 접근하게 하는 인터페이스를 제공한다. ObjectStructure는 Composite 패턴의 복합 객체일 수도 있고, List나 Set 같은 컬렉션일 수도 있다.