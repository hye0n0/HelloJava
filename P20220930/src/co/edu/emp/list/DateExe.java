package co.edu.emp.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateExe {
	// 날짜, 시간
	public static void main(String[] args) {
		Date today = new Date(); // 1970.1.1. 2022.10.5 => 52*12*30*24*60*60*1000
//		today.setYear(2022);
//		today.setMonth(11);
		String ymd = "2022-10-05 13:14:15";
		// 2022-10-05
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(today));
		try {
			today = sdf.parse(ymd);
			System.out.println(today);
		} catch (ParseException e) {
			e.printStackTrace();
		} //
		
		// 날짜(LocalDate), 시간(LocalTime), => LocalDateTime
		LocalDateTime day = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh시mm분ss초");
//		day.format(dtf);
		day = LocalDateTime.of(2022, 10, 5, 10, 20);
		System.out.println(day.format(dtf));
		
	}
}
