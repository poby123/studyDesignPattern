## Abstract Factory Pattern
### Definition 
객체들의 구체적인 클래스(Concrete Classes)를 지정하지 않고, 서로 연관되어 있거나 종속적인 객체의 제품군을 만들 수 있는 인터페이스를 제공한다.

### Concept 
Factory Method 패턴에 비해 한 단계 높은 추상화를 제공한다.<br>
공통적인 테마(예) Wild, Pet)를 가지고 있는 각각의 Factory 그룹을 캡슐화하는 방법을 제공해준다.<br>
이 패턴의 클래스들은 직접적으로 객체를 생성하지 않고, 객체 생성하는 일을 Factory 객체에 위임한다.<br>

### Abstract Factory Pattern Diagram
<img src="https://user-images.githubusercontent.com/50279318/104676317-7b12ba80-572a-11eb-8edc-74f7fc71da13.png" width="700"/>

### Example source Diagram
<img src="https://user-images.githubusercontent.com/50279318/104678558-0a21d180-572f-11eb-92e6-6b8e3ecdbf40.jpg" width="700"/>
