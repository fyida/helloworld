package charactor;
import property.*	;
import java.lang.Comparable;
public class Hero implements Comparable<Hero>{
	public String name;
	public double hp;
	public double armor;
	public int damage;
	public int moveSpeed;
	public Hero() {
		
	}
	public  Hero(String Name) {
		this.name=Name;
	}
	public  Hero(String Name,double HP) {
		this(Name);
		this.hp=HP;
	}
	public  Hero(String Name,double HP,double Armor) {
		this(Name,HP);
		this.armor =Armor;
	}
	public  Hero(String Name,double HP,double Armor,	int MoveSpeed) {
		this(Name,HP,Armor);
		this.moveSpeed=MoveSpeed;
	}
	public void equip(Armor A) {}
	
    public void attackHero(Hero hero) {
    	hero.hp -=damage;
    }
    public boolean isDead() {
        return 0>=hp?true:false;
    }
	public Hero revive(Hero h) {
		h=new Hero("提莫",383);
		return h;
	}
	public void useItem(Item i){
        i.effect();
    }
	public void kill(Mortal m) {
		m.die();
	}
	public synchronized void recover() {
        if (hp == 1000) {
            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来

    }
 
    public synchronized void hurt() {
//        if (hp == 1) {
//            try {
//                // 让占有this的减血线程，暂时释放对this的占有，并等待
//                this.wait();
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
 
        hp = hp - 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
        this.notify();
    }
    class BattleScore {
        int kill;
        int die;
        int assit;
 
        public void legendary() {
            if (kill >= 8)
                System.out.println(name + "超神！");
            else
                System.out.println(name + "尚未超神！");
        }
    }
    public String getName() {
    	return name;
    }
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", armor=" + armor + "]\r\n";
    }
	public int compareTo(Hero o) {
			return new Double(hp).compareTo(new Double(o.hp));
	} 

    public static void main(String[] args) {
        Hero garen =  new Hero();
        garen.name = "盖伦";
        garen.hp=616;
        garen.damage=100;

        Hero teemo =  new Hero();
        teemo.name = "提莫";
        teemo.hp=383;
        teemo.damage=120;
        

        garen.attackHero(teemo);
        System.out.println(teemo.hp);
        teemo=teemo.revive(teemo);
        System.out.println(teemo.hp);
        LifePotion lp =new LifePotion();
        MagicPotion mp =new MagicPotion();
         
        garen.useItem(lp);
        garen.useItem(mp);
        ADHero ad =new ADHero();
        APHero ap =new APHero();
        ADAPHero adap =new ADAPHero();
        garen.kill(ad);
        garen.kill(ap);
        garen.kill(adap);
        BattleScore score = garen.new BattleScore();
        score.kill = 9;
        score.legendary();
    }

}
