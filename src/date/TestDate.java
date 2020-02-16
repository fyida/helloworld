package date;

//
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static Date randomdate() {
		Date date0 = new Date(70, 0, 1);
		Date date1 = new Date(99, 11, 31, 23, 59, 59);
		long randomtime = (long) ((date1.getTime() - date0.getTime() + 1) * Math.random() + date0.getTime());
		Date date = new Date(randomtime);
		return date;
	}

	public static void main(String[] args) {

		// y 代表年
		// M 代表月
		// d 代表日
		// H 代表24进制的小时
		// h 代表12进制的小时
		// m 代表分钟
		// s 代表秒
		// S 代表毫秒
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date[] = new Date[9];
		System.out.println("得到的随机日期数组:");
		for (int i = 0; i < date.length; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
			}
			date[i] = randomdate();
			System.out.print(sdf.format(date[i]) + " ");
		}
		System.out.println();
		System.out.println("排序后的随机日期数组:");
		for (int i = 1; i < date.length; i++) {
			for (int j = 0; j < date.length - i; j++) {
				if (date[j].getTime() > date[j + 1].getTime()) {
					Date temp = date[j + 1];
					date[j + 1] = date[j];
					date[j] = temp;
				}
			}
		}
		for (int i = 0; i < date.length; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
			}
			System.out.print(sdf.format(date[i]) + " ");
		}

	}
}