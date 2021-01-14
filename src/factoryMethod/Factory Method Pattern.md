## Factory Method Pattern
### Definition
객체를 생성하기 위한 인터페이스를 정의하지만, 하위 클래스에서 인스턴스화할 클래스를 결정하도록 한다.<br/>
Factory Method 패턴은, 한 클래스의 인스턴스화를 하위클래스로 미룰 수 있도록 해준다.

<hr>

### Example Diagram
Dog -> Animal <- Tiger <br>
DogFactory -> AnimalFactory <- TigerFactory
