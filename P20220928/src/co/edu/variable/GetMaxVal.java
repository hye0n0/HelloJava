package co.edu.variable;

public class GetMaxVal {
	public static void main(String[] args) {
		int[] randomAry = new int[5]; //자바는 배열 크기 고정 가능
		randomAry[0] = (int) (Math.random() * 100) + 1; // Math.random => 0 ~ 1 사이의 임의수 생성(실수)
					// (int) => Math.randoem(실수)를 정수로 바꿔줌
		randomAry[1] = (int) (Math.random() * 100) + 1; 
		randomAry[2] = (int) (Math.random() * 100) + 1; 
		randomAry[3] = (int) (Math.random() * 100) + 1; 
		randomAry[4] = (int) (Math.random() * 100) + 1; 
		
		int maxVal = 0; // 배열요소 중 가장 큰값을 저장.
		for(int i=0; i<5; i++) {
			System.out.println(randomAry[i]);
		}
//		 maxVal 변수에 두 값을 비교해서 큰값을 담기.
		for(int i=0; i<randomAry.length; i++) {
			if(maxVal < randomAry[i]) {
				maxVal = randomAry[i];
			}
		}
		System.out.println("생성된 배열의 임의의 값 중 최대값 =>" + maxVal);
		
		int minVal = randomAry[0];
		for(int i=0; i<randomAry.length; i++) {
			if(minVal > randomAry[i]) {
				minVal = randomAry[i];
			}
		}
		System.out.println("생성된 배열의 임의의 값 중 최소값 =>" + minVal);
	}
}
