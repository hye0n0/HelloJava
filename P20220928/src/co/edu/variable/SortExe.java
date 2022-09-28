package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {34, 21, 12 };
		
		// 반복적인 처리. 
//		numAry = {12, 21, 34} 로 순서대로 출력 (두개값씩 비교해서 정렬)
		//케이스 : n1 > n2 > n3 =>
		//케이스 : n1 < n2 > n3 => 여러 케이스 생각해서 배열 바꾸기
		
		for(int i=0; i<(numAry.length-1); i++) {
			if(numAry[i] > numAry[i+1]) { // 34 > 21
				int temp = numAry[i];
				numAry[i] = numAry[i+1];  // 21
				numAry[i+1] = temp;		//
			}
		}
		
		for(int n : numAry) {
			System.out.println(n);
		}
	}
}
