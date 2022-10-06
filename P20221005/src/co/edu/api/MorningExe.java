package co.edu.api;

public class MorningExe {
	public static void main(String[] args) {
		
		// 1
		// 2  3
		// 4  5  6
		// 7  8  9  10
		
		int cut = 1; 
		int cnt = 0; 
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%3d", i);
			cnt++;
			if (cut == cnt) {
				System.out.println();
				cut++;
				cnt = 0;
			}
		}
		
		//          1
		//       2  3
		//    4  5  6
		// 7  8  9 10
		
		cut = 1; 
		cnt = 0; 
		int tab = 1; 
		for (int i = 1; i <= 10; i++) {
			if (cnt == 0) {
				for (int j = 4; j > tab; j--) {
					System.out.printf("%3s", " ");
				}
			}
			System.out.printf("%3d", i);
			cnt++;
			if (cut == cnt) {
				System.out.println();
				cut++;
				cnt = 0;
				tab++;
			}
		}
	}
}
