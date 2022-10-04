package co.edu.inherit.friend;

public class AnimalMain {
	public static void main(String[] args) {
//		Animal animal = new Animal(); // 추상클래스는 인스턴스 생성 불가
		Animal cat = new Cat();
		Animal dog = new Dog();
		
		cat.speak();
		dog.speak();
	}
}
