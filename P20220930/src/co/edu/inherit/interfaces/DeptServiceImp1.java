package co.edu.inherit.interfaces;

import co.edu.inherit.interfaces.DaoService;


public class DeptServiceImp1 implements DaoService{
	
	@Override
	public void insert(){
		System.out.println("부서 저장");
	}
	
	@Override
	public void search(){
		System.out.println("부서 조회");
	}
	
	@Override
	public void delete(){
		System.out.println("부서 삭제");
	}

	@Override
	public void remove() {
		System.out.println("부서 삭제");
	}

}
