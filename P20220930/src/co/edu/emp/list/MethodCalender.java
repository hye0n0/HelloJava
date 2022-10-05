package co.edu.emp.list;

import java.util.Calendar;

public class MethodCalender {
	private static MethodCalender instance = new MethodCalender();
	private MethodCalender() {}
	public static MethodCalender getInstance() {
		return instance;
	}
	
	public void makeCal(int month) {
		System.out.println("    >>>>  2022년 " + month + "월   <<<<");
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		// 요일 출력
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		// 1일의 위치를 지정
		for(int i=0; i<getFirstDay(month); i++) {
			System.out.printf("%4s", " ");
		}
		// 날짜 출력
		for(int i=1;i<=getLastDate(month); i++) {
			System.out.printf("%4d", i);
			if( (i+getFirstDay(month)) % 7 == 0) {
				System.out.println();
			}
		}
	}// end of makeCal().
	
	public int getFirstDay(int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(2022, month-1, 1);
		return cal.get(Calendar.DAY_OF_WEEK)-1; // 1부터 시작 
	}// end of getFirstDay()
	
	public int getLastDate(int month) {
		//switch..case..구문
		Calendar cal = Calendar.getInstance();
		cal.set(2022, month-1, 1);
		return cal.getActualMaximum(Calendar.DATE);
	}
}// end of class
