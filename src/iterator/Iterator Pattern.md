## Iterator Pattern
### Definition
내부 표현방법을 노출하지 않고, 복합 객체의 원소를 순차적으로 접근할 수 있는 방법을 제공한다.

### Concept
iterator를 통해, 클라이언트 객체는 컨테이너를 순회하면서 각각의 요소들에 접근할 수 있게 된다.<br>
- 트리 자료구조에서 노드들을 순회할 때 사용된다. 그래서 많은 경우, composite 패턴과 함께 iterator 패턴을 사용한다.
- iterator의 역할은 순회하는 것에 한정되지 않는다. iterator은 다양한 요구사항을 지원하기 위해 달라질 수 있다.
- 클라이언트에서는 실제 순회방식을 볼 수 없고, 원래부터 public한 iterator 메서드만 사용할 수 있다.


### Diagram
<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/iteratorpattern1.png"/>