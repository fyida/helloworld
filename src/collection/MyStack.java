package collection;

import java.util.LinkedList;

import charactor.Hero;

public class MyStack implements Stack {
	LinkedList<Hero> list = new LinkedList<Hero>();
	@Override
	public synchronized void push(Hero h) {
		// TODO 自动生成的方法存根
		list.add(h);
	}

	@Override
	public synchronized Hero pull() {
		
		return list.removeLast();
	}

	@Override
	public synchronized Hero peek() {
		// TODO 自动生成的方法存根
		return list.getLast();
	}



}
