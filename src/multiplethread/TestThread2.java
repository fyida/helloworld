
package multiplethread;

import charactor.Hero;

public class TestThread2 {

	public static void main(String[] args) {

		final Hero gareen = new Hero();
		gareen.name = "盖伦";
		gareen.hp = 1;
		Thread[] addh = new Thread[2];
		Thread[] minush = new Thread[5];
		for (int i = 0; i < addh.length; i++) {
			Thread t2 = new Thread() {
				public void run() {
					while (true) {
						gareen.recover();

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			};
			addh[i] = t2;
			addh[i].start();
		}
		for (int i = 0; i < minush.length; i++) {
			Thread t1 = new Thread() {
				public void run() {
					while (true) {

						// 无需循环判断
//                         while(gareen.hp==1){
//                             continue;
//                         }

						gareen.hurt();

						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			};
			minush[i]=t1;
			minush[i].start();
		}
		
	}

}
