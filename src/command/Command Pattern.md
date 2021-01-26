## Command Pattern
### Definition
요청을 객체로 캡슐화함으로써 서로 다른 요청으로 클라이언트를 파라미터화하고, 요청을 저장하거나 기록을 남겨서 오퍼레이션의 취소도 가능하게 한다.

### Diagram
<img src="https://miro.medium.com/max/2992/1*xQ2peVm9CmcIgYY2UyyBYg.png" width="700"/>

### Objects
- Command: 오퍼레이션 수행에 필요한 인터페이스 선언
- ConcreteCommand: Receiver 객체와 액션간의 연결성을 정의한다. 또한 처리 객체에 정의된 오퍼레이션을 호출하도록 Execute를 구현한다.
- Client: ConcreteCommand 객체를 생성하고 처리 객체로 정의한다.
- Invoker: 명령어에게 처리를 수행할 것을 요청한다.
- Receiver: 요청과 관련된 오퍼레이션 수행방법을 알고있다.