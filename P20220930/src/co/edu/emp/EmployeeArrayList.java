package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

class InvalidDeptException extends Exception{
	InvalidDeptException() { }
	InvalidDeptException(String msg){
		super(msg);
	}
}
class NegativeValException extends RuntimeException{
	NegativeValException() {}
	NegativeValException(String msg){
		super(msg);
	}
}

// 컬렉션(ArrayList)을 활용해서 데이터 저장
public class EmployeeArrayList implements EmployeeService{
	// 저장공간 생성
	ArrayList<Employee> list;
	int idx = 0;
	Scanner scn = new Scanner(System.in);
	
	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료");
	}

	@Override
	public void input() {
		int eId = readInt("사번>> ");
		System.out.println("이름>> ");
		String name = scn.nextLine();
		int deptId = -1;
		while(true) {
			deptId = readInt("부서>> ");
			try {
				validDept(deptId);
				break;
			} catch (InvalidDeptException e) {
					System.out.println("잘못된 부서번호입니다");
			}
		}
		int sal = readInt("급여>> ");
		System.out.println("이메일>> ");
		String email = scn.nextLine();
		Employee emp = new Employee(eId, name, sal, deptId, email);
		list.add(emp);
	}

	@Override
	public String search(int employeeId) {
		String result = null;
//		for (int i=0; i<list.size(); i++) {
//			Employee emp = list.get(i); // list[i];
//			if(emp.getEmployeeId() == employeeId) {
//				result = list.get(i).getName();
//				break;
//			}
//		}
		for(Employee emp : list) {
			if(emp.getEmployeeId() == employeeId) {
				result = emp.getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		System.out.printf("%5s %10s %7s\n", //
				"사원번호", //
				"이름   ", //
				"급여   ");
		System.out.println("============================");
		for(int i=0; i<list.size(); i++) {
			System.out.printf("%5d %10s %7s\n", //
					list.get(i).getEmployeeId(), //
					list.get(i).getName(), //
					list.get(i).getSalary());
		}
		System.out.println("============================");
		
	}

	@Override
	public int searchSal(int employeeId) {
		int result = -1;
//		for (int i=0; i<list.size(); i++) {
//			Employee emp = list.get(i);
//			if(emp.getEmployeeId() == employeeId) {
//				result = list.get(i).getSalary();
//				break;
//			}
//		}
		for(Employee emp : list) {
			if(emp.getEmployeeId() == employeeId) {
				result = emp.getSalary();
				break;
			}
		}
		return result;
	}
	
	public static int validDept(int dept) throws InvalidDeptException{
		int validDept = dept%10;
		if(validDept != 0 || dept > 30) {
			throw new InvalidDeptException("잘못된 부서 번호");
		}else {
			return dept;
		}
	}
	
// 음수일	때 오류 발생하게 만들기
//	public static int positiveVal(int num) throws NegativeValException{
//		int result = num
//		if() {
//			throw new InvalidDeptException("잘못된 부서 번호");
//		}else {
//			return dept;
//		}
//	}
	
// 숫자가 아닐시 오류출력하게 만들기	
	public static int readInt(String msg) throws NumberFormatException {
		Scanner scn = new Scanner(System.in);
		int result = -1;
		while (true) {
			System.out.println(msg);
			try {
				result = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요!");
				scn.nextLine();
			}
		}
		return result;
	}

}
