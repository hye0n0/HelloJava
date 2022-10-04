package co.edu.inherit;

public class Parent {
	String field;
	Parent() {
		System.out.println("Parent() call");
	}
	Parent(String args) {
		System.out.println("Parent(String args) call");
	}
	void method() {
		System.out.println("parent method() call");
	}
	@Override
	public String toString() {
		return "Parent [field=" + field + "]";
	}
}
