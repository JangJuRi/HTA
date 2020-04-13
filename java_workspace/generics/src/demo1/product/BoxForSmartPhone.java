package demo1.product;

// 제네릭스의 제한
// 제네릭 타입에 extends를 사용하면 특정 타입의 자손들만 타입 파라미터로 대입할 수 있다.
public class BoxForSmartPhone<T extends SmartPhone> {	// SmartPhone의 자손클래스만 담을 수 있다.

	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
