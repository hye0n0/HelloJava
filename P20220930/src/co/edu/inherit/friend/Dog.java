package co.edu.inherit.friend;

public class Dog extends Animal{

	@Override
	public void eat() {
		System.out.println("강아지가 먹이를 먹습니다");
	}
	
	@Override
	public void speak() {
		System.out.println("멍멍");
	}
}
