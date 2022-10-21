package co.edu.morning;

public class Random {
	public static void main(String[] args) {
		String[] nums = new String[21];
		for (int i = 0; i < nums.length; i++) {
			int num = (int) (Math.random() * 21);
			boolean check = true;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] != null && Integer.parseInt(nums[j])  == num) {
					check = false;
					break;
				}
			}
			if (check) {
				nums[i] = String.valueOf(num) ;
			}else {
				i--;
			}
		}
		String[] students = {"권미현","김경미","김동욱","김유리","김지한","김충현","김현지","김홍식","남미주","박정민","배수빈","서강중","송지은","이재원","정호경","주소영","주소현","진재환","천세훈","허수진","허진주","황지현"};
		for(String num : nums) {
			System.out.println(students[Integer.parseInt(num)]);
		}
	}
}
