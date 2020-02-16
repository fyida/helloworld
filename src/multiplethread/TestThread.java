package multiplethread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import charactor.Hero;

public class TestThread {
	public static void pojie(String str) {
		int len = str.length();
		List<String> list = new ArrayList<>();
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					String guess = randomstr(len);
					list.add(guess);
					if (guess.equals(str)) {
						try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
						System.out.println("成功匹配密码为:"+guess);
						break;
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					if (!list.isEmpty()) {
						String s = list.get(0);
						System.out.println("可能的密码是：" + s);
						list.remove(0);
					} else {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				}

			}
		};
		t2.setDaemon(true);
		t1.start();
		t2.start();
	}

	public static String randomstr(int num) {
		char[] chars = new char[num];
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			while (true) {
				char c = (char) random.nextInt(127);
				if (Character.isLetterOrDigit(c)) {
					chars[i] = c;
					break;
				}
			}
		}
		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		String mima = "abc";
		System.out.println(mima);
		pojie(mima);
	}
}
