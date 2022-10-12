package co.edu.jdbc;

import java.util.List;

public class EmpApp {
	public static void main(String[] args) {
		EmployeeDAO empDao = new EmployeeDAO();
		
		int empId = 100;
		String lastName = "Hong";
		String email = "hongkil@email";
		String jobId = "ST_MAN";
		String hireDate = "2021-05-20";
		Employee emp1 = new Employee(empId,lastName,email,hireDate,jobId);
		
//		empDao.insert(emp1);
//		empDao.update(emp1);
//		empDao.delete(empId);
		Employee employee = empDao.getEmp(empId);
		System.out.println(employee.toString());
		
		// 조회
//		List<Employee> employees = empDao.search();
//		
//		for (Employee emp : employees) {
//			System.out.println(emp.toString());
//		}
	}
}
