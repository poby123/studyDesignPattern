## Singleton Pattern
### Definition
Ŭ������ ���� �ϳ��� �ν��Ͻ��� �������� �ϰ�, �� �ν��Ͻ��� ������ �� �ִ� global�� ������ �����ϴ� ���� ���Ѵ�.

### Concept
�ϳ��� Ŭ������ �������� �ν��Ͻ��� ������ ���ϵ��� �Ѵ�.
�ϳ��� �ν��Ͻ��� ��������� ����, ���Ŀ��� ��� �̹� �����ϴ� �ν��Ͻ��� �̿��ϰ� �ȴ�.
�̱��� ������ �߾� ����ȭ�� �ý��ۿ��� ���ʿ��� ��ü������ �����ϴµ� ������ �ָ�, ���������� ���� ���ش�.

### ����
�̱����� ������ ���� ��Ƽ ������ ȯ�濡���� Thread-safe �Ͽ�, �� �ϳ��� �ν��ϸ� �������� �����ؾ��Ѵ�.

### ����
1. Eager Initialization
2. Lazy Initialization - Synchronized
3. Lazy Initialization - Double Checking Locking
4. Lazy Initialization - Lazy Holder