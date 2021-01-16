## Adapter Pattern
### Definition
클래스의 인터페이스를 클라이언트가 원하는 다른 인터페이스로 변환한다. 
Adapter을 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스를 연결해서 쓸 수 있다.

### Object type Adapter Diagram
<img src="https://t1.daumcdn.net/cfile/tistory/24231F4C575EACA210" width="700"/>

### Class Type Adapter Diagram
<img src="https://t1.daumcdn.net/cfile/tistory/252CFB4F575EB62D0A" width="700"/>


### Objects
- Target : 클라이언트가 사용할 도메인에 종속적인 인터페이스를 정의하고 있는 클래스이다.
- Client : Target 인터페이스를 만족하는 객체와 동작할 대상이다.
- Adaptee : 인터페이스 개조가 필요한 기존의 인터페이스를 정의하고 있는 클래스이다.
- Adapter : Target 인터페이스에 Adaptee의 인터페이스를 맞춰주는 클래스이다.