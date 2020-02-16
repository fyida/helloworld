package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import charactor.Hero;

public class TestLambda {
    private static void filter(List<Hero> heros) {
        for (Hero hero : heros) {
            if(hero.hp>100 && hero.armor<50)
                System.out.print(hero);
        }
    }
    private static void filter(List<Hero> heros,HeroChecker checker) {
        for (Hero hero : heros) {
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for(int i=0;i<10;i++) {
			heros.add(new Hero("name"+i,r.nextInt(1000),r.nextInt(100)));
		}
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("筛选出 hp>100 && armor<50的英雄");
        HeroChecker checker =new HeroChecker() {

			@Override
			public boolean test(Hero h) {
				// TODO 自动生成的方法存根
				return (h.hp>100&&h.armor<50);
			}};
        filter(heros);
        System.out.println("用匿名类方法，筛选出 hp>100 && armor<50的英雄");
        filter(heros,checker);
        System.out.println("用Lambda方法，筛选出 hp>100 && armor<50的英雄");
        filter(heros,h->h.hp>100 && h.armor<50);
    }
	}
	


