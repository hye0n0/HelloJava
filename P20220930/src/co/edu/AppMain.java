package co.edu;

// 하나의 실행클래스와 여러개의 라이브러리클래스.
public class AppMain {
	public static void main(String[] args) {
		// Object -> Class -> Instance
		Person kim = new Person(); // 인스턴스 생성.
		kim.name = "김민기";
		kim.age = 20;
		kim.sleep();
		kim.eat("사과");
		
		Person lee = new Person();
		lee.name = "이순신";
		lee.age = 25;
		lee.sleep();
		lee.eat("피자");
		
		Student stud1 = new Student();
//		stud1.studNo = "11111";
		stud1.setStudNo("11111");
//		stud1.name = "학생1";
		stud1.setstudName("학생1");
//		stud1.major = "컴퓨터공학";
		stud1.setMajor("컴퓨터공학");
		stud1.sleep();
		stud1.game();
		
		Student stud2 = new Student();
//		stud2.studNo = "22222";
		stud2.setStudNo("22222");
//		stud2.name = "학생2";
		stud2.setstudName("학생2");
//		stud2.major = "경영";
		stud2.setMajor("경영");
		
		Student stud3 = new Student();

		Student[] students;
		students = new Student[] {stud1, stud2, stud3};
		for(Student stud : students) {
			System.out.println("학번: " + stud.getStudNo() + ", 학생이름: " + stud.getstudName());
		}
		WorkMan wman = new WorkMan();
		wman.name = "직장인";
		wman.age = 30;
		
		StudMan sman = new StudMan();
		sman.school = "고등학교";
		sman.height = 164.3;
	}
}
