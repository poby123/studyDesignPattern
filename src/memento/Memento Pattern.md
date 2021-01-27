## Memento Pattern
### Definition
캡슐화를 위배하지 않고, 객체의 내부 상태를 객체화해서, 나중에 객체가 이 상태로 복구될 수 있도록 한다.

### Diagram
<img src="https://i.stack.imgur.com/NxGIn.png"/>

### Objects
- Memento : Originator 객체의 내부 상태를 저장한다. Memento는 originator 객체의 내부 상태를 필요한 만큼 저장해둔다. originator 객체를 제외한 다른 객체는 Memento 클래스에 접근할 수 없다. 그래서 Memento 클래스는 두 개의 인터페이스를 갖는다. 관리 책임을 갖는 객체인 CareTaker 클래스는 Memento 에 정의된 모든 인터페이스를 다 보지 못하고 단지 Memento를 다른 객체에 전달한다. 이에 비해 Originator 클래스는 자신의 상태를 이전 상태로 복구하기 위해 필요한 모든 자료에 접근하는데 필요한 Memento의 다양한 인터페이스를 사용할 수 있다. Memento를 생성하는 Originator 클래스만이 메멘토의 내부상태에 접근할 수 있는 권한을 갖는다.
- Originator: Memento를 생성하여 현재 객체의 상태를 저장하고 내부 상태를 복구한다.
- CareTaker: Memento의 보관을 책임지지만, 내용을 확인하거나 처리하지 않는다.