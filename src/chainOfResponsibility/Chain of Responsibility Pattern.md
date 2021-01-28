## Chain of Responsibility Pattern
### Definition
요청을 처리할 수 있는 기회를 하나 이상의 객체에게 부여함으로써, 요청하는 객체와 처리하는 객체 사이의 결합을 없애버린다. 요청을 해결할 객체를 만날 때까지 객체 고리를 따라서 요청을 전달한다.

### Diagram
<img src="https://miro.medium.com/max/491/1*A-RUUrXZtJmW5ImF853Xsg.png"/>


### Objects
- Handler: 요청을 처리하는 인터페이스를 정의하고, 다음 처리자와의 연결을 구현한다. 즉, 연결 고리에 연결된 다음 객체에게 메시지를 다시 보낸다.
- ConcreteHandler : 책임져야할 행위가 있다면 스스로 요청을 처리한다. 다음 처리자에 접근할 수 있다. 즉, 자신이 처리할 행위가 있으면 처리하고, 그렇지 않으면 다음 처리자에게 다시 처리를 요청한다.
- Client: ConcreteHandler 객체에게 필요한 요청을 보낸다.
