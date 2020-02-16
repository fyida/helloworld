package collection;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

public class HeroNode extends Node {
    public HeroNode leftNode;
    // 右子节点
    public HeroNode rightNode;
    // 值
    public Hero hr;// 插入 数据
    public void add(Hero hv){
        
        if(null==hr){
            hr = hv;
        }else{
            if(hv.hp-hr.hp>0){
                if(null==leftNode)
                    leftNode = new HeroNode();
                leftNode.add(hv);
            }else if(hv.hp-hr.hp>=0){
                    if(null==rightNode)
                        rightNode = new HeroNode();
                    rightNode.add(hv);              
            }
        }
    }
    public List<Object> values() {
        List<Object> listvalues = new ArrayList<>();
        // 左节点的遍历结果
        if (null != leftNode) {
            listvalues.addAll(leftNode.values());
            System.out.println("left");
        }
        // 当前节点
        listvalues.add(value);

        // 右节点的遍历结果
        if (null != rightNode) {
        	System.out.println("right");
            listvalues.addAll(rightNode.values());
        }
  
        return listvalues;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HeroNode heroNode = new HeroNode();
		Hero hero = new Hero();
		System.out.println("初始化10个Hero:");
		for (int i=0;i<10;i++) {
			 hero.name="hero "+i;
			 hero.hp=(int)(Math.random()*1000);
			 System.out.println(hero.name + "  hp:" +hero.hp);
			 heroNode.add(hero);
		}
	 	System.out.println(heroNode.values());
	}
		
}
