package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {5, 4, 3, 2, 34, 21, 12 };
		
		// 반복적인 처리. 
//		numAry = {12, 21, 34} 로 순서대로 출력 (두개값씩 비교해서 정렬)
		//케이스 : n1 > n2 > n3 =>
		//케이스 : n1 < n2 > n3 => 여러 케이스 생각해서 배열 바꾸기
		
		// 1)
//		for(int i=0; i<(numAry.length-1); i++) {
//			if(numAry[i] > numAry[i+1]) {
//				int temp = numAry[i];
//				numAry[i] = numAry[i+1];  
//				numAry[i+1] = temp;	
//			}
//		}
		// 2)
//		for(int i=0; i<(numAry.length-2); i++) {
//			if(numAry[i] > numAry[i+1]) { // 34 > 21
//				int temp = numAry[i];
//				numAry[i] = numAry[i+1];  // 21
//				numAry[i+1] = temp;		//
//			}
//		}
//		
		for (int j=1; j<(numAry.length); j++) {
			for(int i=0; i<numAry.length-1; i++) {  // i:0, i:1, i:2
				if(numAry[i] > numAry[i+1]) {
					int temp = numAry[i];  // 순서가 먼저 있는 값을 temp.
					numAry[i] = numAry[i+1];  
					numAry[i+1] = temp;
				}
			}
		}
		// 3) 출력
		for(int n : numAry) {
			System.out.println(n);
		}
	}
}
