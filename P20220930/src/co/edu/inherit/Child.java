package co.edu.inherit;

public class Child extends Parent{
	String field1;
	Child() {
		super("args"); // 부모클래스의 생성자 호출
		System.out.println("Child() call");
	}
	void method1() {
		System.out.println("method1() call");
	}
	// 부모클래스의 메소드를 재정의. overriding
	@Override  //  어노테이션 : 부모클래스의 메소드(반환값, 메소드의 이름, 매개값)체크
	void method() {
		System.out.println("Child method() call");
	}
	@Override
	public String toString() {
		return "Child [field1=" + field1 + "]";
	}
}
