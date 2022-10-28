package co.test.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AutoRun implements ServletContextListener {
	Timer timer = null;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		timer = new Timer(true);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(">> You Can Do It!! 오늘은 즐거운 금요일 끝까지 화이팅!!" + ", 현재시간: " + sdf.format(new Date()));
			}
		}, 0, 1000 * 10);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
		System.out.println("timer canceled.");
	}
}
