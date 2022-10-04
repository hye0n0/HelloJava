package co.edu.inherit.dbinterface;

import co.edu.inherit.dbinterface.DaoService;

public class MysqlDAO implements DaoService{

	@Override
	public void insert() {
		System.out.println("mysql 저장");
	}

	@Override
	public void modify() {
		System.out.println("mysql 수정");
	}
	
	@Override
	public void search() {
		System.out.println("mysql 조회");
	}

	@Override
	public void remove() {
		System.out.println("mysql 삭제");
	}
	
//	public void insert() {
//		System.out.println("mysql 저장");
//	}
//	public void search() {
//		System.out.println("mysqp 조회");
//	}
//	public void delete() {
//		System.out.println("mysql 삭제");
//	}
//	public void update() {
//		System.out.println("mysql 수정");
//	}
}
