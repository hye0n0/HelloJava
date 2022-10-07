package co.edu.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

class Employee {
	int empId;
	String name;
	int salary;
	public Employee(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public int hashCode() {
		return empId;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee target = (Employee) obj; // casting
			return (this.empId == target.empId 
					&& this.name.equals(target.name) 
					&& this.salary == target.salary);
		} else {
			return false;
		}
	}
	
	
	
}

public class SetExample {
	public static void main(String[] args) {
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(new Employee(100, "홍길동", 1000));
		employees.add(new Employee(200, "박유식", 2000));
		employees.add(new Employee(300, "최윤기", 3000));
		employees.add(new Employee(100, "김길동", 4000));
		
		employees.remove(new Employee(100, "김길동", 4000));
		
		System.out.println(employees.size());
		
		Iterator<Employee> iter = employees.iterator();
		while(iter.hasNext()) {
			Employee emp = iter.next();
			System.out.printf("사번은 %d, 이름은 %s, 급여는 %d\n", emp.empId, emp.name, emp.salary );
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		// 중복허용X
		while(set.size() < 7) {
			set.add((int)(Math.random() * 45) +1 );	
		}
		for(int n : set) {
			System.out.printf("%d ", n);
		}
		
		// 중복저장 불가
//		int[] lotto = new int[7];
//		for (int i=0; i<lotto.length; i++) {
//			int temp = (int) (Math.random()*7) + 1;
//			//현재 인덱스 값보다 적은 위치에 temp같은 값이 있는지 체크
//			for (int j=0; j<i ; j++) {
//				//같은 값이 있으면...
//				if(lotto[j] == temp) {
//					temp = -1;
//					break;
//				}
//			}
//			if (temp == -1) {
//				i -= 1;
//				continue;
//			} else 
//				lotto[i] = temp;
//		}
//		for(int n : lotto) {
//			System.out.printf("%d ",n);
//		}
	}
}
