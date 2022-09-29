package co.edu.variable;

public class MethodExample {
	// 가로, 높이 => 
	public static int getArea(int w, int h) {
		int result = w * h;
		return result;
	}
	
	// 배열요소의 각 값의 합
	public static int sumAry(int[] ary) {
		int sum = 0;
		for(int i=0; i<ary.length; i++) {
			sum = sum + ary[i];
		}
		return sum;
		
	}
	
	// 두수를 나눈 결과를 반환
	public static double divide(double n1, double n2) {
		double result = n1/n2;
		return result;
		
	}
	
	// 두수를 나누는 작업. 매개변수를 int  지정.
	public static double divide(int n1, long n2) {
		// 1bit * 8 => 1byte.
		// 유형: byte(1), short(2), int(4), long(8)
		//	  : float(4), double(4)
		if (n2 == 0) {
			return 0;
		}
		double result = (double) n1/n2; // 3.0 / 2.0 => 1.5
		return result;	// 타입이 다를때는 두개 중에 큰타입으로 변환
						// ==> int n1, long n2일때 n1을 long으로 변환하면 계산
		
	}
	
	public static void main(String[] args) {
		int result = getArea(20,15);
		System.out.println("전체 너비는 " + result);
		
		int[] intAry = {23, 45, 12};
		result = sumAry(intAry);
		System.out.println("전체 배열요소의 합계는 " + result);

		int[] intAry2 = {22, 33, 44, 55};
		result = sumAry(intAry2);
		System.out.println("전체 배열요소의 합계는 " + result);
		
		// 실수. float, double
		double d1 = 23.4567;
		double d2 = 12.34;
		double d3 = d1 + d2; // int d3하면 오류남
		
		d3 = divide(d1, d2);
		System.out.println("나눈 결과는 " + d3);
		
		d3 = divide(3, 2);
		System.out.println("나눈 결과는 " + d3);

	}
}
