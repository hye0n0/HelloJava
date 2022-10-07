package co.edu.api;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

class Box<T> {
	T obj;
	void set(T obj) {
		this.obj = obj;
	}
	T get() {
		return obj;
	}
}

class Member {
	private String name;
	private String id;
	private int point;
	
	public Member(String name, String id, int point) {
		super();
		this.name = name;
		this.id = id;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}


class Employee {
	private String empName;
	private String empId;
	private int salary;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}

public class StringExe3 {
	public static void main(String[] args) {
		
		Box<String> box = new Box<String>();
		box.set("Hello");
//		box.set(200); error
		String result = box.get();
		System.out.println(result);
		
		String[] stAry;
		List<String> list = new ArrayList<String>();
		list.add("Hello");
//		list.add(200);
		
		List<Member> members = new ArrayList<Member>();
		members.add(new Member("홍길동", "hong", 10000));
		members.add(new Member("김민기", "kim", 20000));
		members.add(new Member("박인기", "park", 30000));
		
		List<Employee> employees = changeType(members); // Member => Employee
		for(Employee emp : employees) {
			System.out.println("Name: "+emp.getEmpName()+", Id: "+emp.getEmpId()+", Salary: "+emp.getSalary());
		}
		
	}
	
	public static List<Employee> changeType(List<Member> collect) {
		// 3 -> 3 개
		// coding
		List<Employee> empls = new ArrayList<Employee>();
		for(Member member : collect) {
			Employee emp = new Employee();
			emp.setEmpId(member.getId());
			emp.setEmpName(member.getName());
			emp.setSalary(member.getPoint());

			empls.add(emp);
		}
		return empls;
	}
}
