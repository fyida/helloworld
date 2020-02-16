package digit;

public class SuShu {
	public static boolean isZhiShu(int num) {
		for(int j=2;j<=Math.sqrt(num);j++) {
			if(num%j==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int n = 1;
		long startTime =System.currentTimeMillis();
		System.out.println("start");
		for(int i =2;i<Math.pow(10, 7);i++) {
			if(isZhiShu(i)) {
				n ++;
				System.out.println("zhishu");
			}
			System.out.println(i);
		}
		long endTime =System.currentTimeMillis();
		long spendTime=endTime-startTime;
		System.out.println(n+"使用时间"+spendTime);
	}
}
