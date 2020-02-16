package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import charactor.Hero;

public class TestCollection {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        List<Hero> heros = new ArrayList<>();
        
        // 初始化100个对象
        for (int i = 0; i < 100; i++) {
            heros.add(new Hero("hero " + i));
        }
        Iterator<Hero> itt = heros.iterator();
        while(itt.hasNext()) {
        	Hero hero=itt.next();
        	System.out.println(hero);
        }
        for(int i=0;i<heros.size();i++) {
        	String[] split = heros.get(i).name.split(" ");

        	Integer num = Integer.valueOf(split[1]);
        	if(num%8==0) {
        		heros.remove(i);
        	}
        }
        Iterator<Hero> it = heros.iterator();
        while(it.hasNext()) {
        	Hero hero=it.next();
        	System.out.println(hero);
        }
	}

}
