package co.edu.except;

public class RectPrint {
	public static void main(String[] args) {
		int cnt = 1;
		int h = 5; // 세로줄
		int w = 5; // 가로줄
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				System.out.printf("%3d",cnt+h*j);
			}
			cnt++;
			System.out.println();
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<5; j++) {
//				System.out.printf("%3d",cnt+5*j);
//			}
//			cnt++;
//			System.out.println();
		}
	}
}
