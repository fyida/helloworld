package multiplethread;

import java.util.LinkedList;
/**
 * 练习-生产者消费者问题
 * 
 *  生产者消费者问题是一个非常典型性的线程交互的问题。
 
    1. 使用栈来存放数据
        1.1 把栈改造为支持线程安全
        1.2 把栈的边界操作进行处理，当栈里的数据是0的时候，访问pull的线程就会等待。 当栈里的数据是200的时候，访问push的线程就会等待
    2. 提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
    3. 提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
    4. 提供一个测试类，使两个生产者和三个消费者线程同时运行，结果类似如下 ：
 */
public class ProducerConsumer<T> implements stack2<T>{

	LinkedList<T> list = new LinkedList<T>();
	@Override
	public synchronized void push(T t) {
		while (list.size() == 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        list.addLast(t);
        this.notify();
		
		
	}

	@Override
	public synchronized T pull() {
		while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
//      this.notify();
//      return list.removeLast();
        // 先pull再notify
        T t=list.removeLast();
        this.notify();
		return t;
	}

	@Override
	public synchronized T peek() {
		return list.getLast();
	}
	static class Producer extends Thread  {
		ProducerConsumer<Character> stack ;
		
		public Producer(ProducerConsumer<Character> stack ) {
			this.stack=stack;
		}
		@Override
		public void run() {
			while(true) {
				char strCap=(char) (Math.random() * 26 + 'A');
				stack.push(strCap);
				System.out.println(this.getName() + " 压入：" + strCap);
				try{
						Thread.sleep(1000);
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		}
		
	}
	static class Consumer extends Thread {
		ProducerConsumer<Character> stack ;
		public Consumer(ProducerConsumer<Character>  stack) {
            this.stack = stack;
        }
		@Override
        public void run() {
            while (true) {
                System.out.println(this.getName() + " 弹出：" + stack.pull());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
	}
	
	
	public static void main(String[] args) {
		ProducerConsumer<Character> ms = new ProducerConsumer<Character>();
        for (int i = 0; i < 2; i++) {
            Thread t = new Producer(ms);
            t.setName("Producer" + (i + 1));
            t.start();
        }
        for (int i = 0; i < 3; i++) {
            Thread t = new Consumer(ms);
            t.setName("Consumer" + (i + 1));
            t.start();
        }
	}

}
