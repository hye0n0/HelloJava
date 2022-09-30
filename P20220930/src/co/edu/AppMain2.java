package co.edu;

public class AppMain2 {
	public static void main(String[] args) {
		
		Student.staticMethod();
		
		Math.random();
		Math.round(.5);
		
		Student s1 = new Student();
//		s1.staticMethod(); // error 아닌데 warning
		
		s1.setStudNo("111-111");
		s1.setstudName("홍길동");
		s1.setMajor("컴퓨터공학");
		s1.setAge(20);
		
		System.out.println(s1.getStudNo()); // String = null. 초기값출력.
		System.out.println(s1.getAge()); // int = 0;
		System.out.println(s1.showInfo());
		
		Student s2 = new Student();
		s2.setstudName("김민숙");
		s2.setStudNo ("111-222");
		s2.setMajor("역사학과");
		System.out.println(s2.showInfo());
		
		String[] hob = {"독서", "자전거"};
		s1.setHobbies(hob);
		s1.addHobby("음악듣기");
		System.out.println(s1.getHobb());
		
		System.out.println(s2.getHobb());
		
		Student s3 = new Student();
		System.out.println(s3.getstudName());
		
		Student s4 = new Student("111-234", "주소영");
		System.out.println(s4.showInfo());
		
		Student s5 = new Student("222-222", "송지은", "역사학과");
		System.out.println(s5.showInfo());
	}
}
