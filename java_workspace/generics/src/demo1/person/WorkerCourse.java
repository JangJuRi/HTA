package demo1.person;

public class WorkerCourse<T extends Worker> {

	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
