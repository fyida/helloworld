package charactor;
public class ADHero extends Hero implements AD,Mortal {
	public ADHero() {}
	
	public ADHero(String Name,float HP,float Armor,	int MoveSpeed) {
		super(Name,HP,Armor,MoveSpeed);
	}
	public void die() {
		System.out.println("ADhero die");
	}
	public void physicAttack() {
		System.out.println("进行物理攻击");
	}
    public void attack() {
        System.out.println(name + " 进行了一次攻击 ，但是不确定打中谁了");
    }
 
    // 可变数量的参数
    public void attack(Hero... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + " 攻击了 " + heros[i].name);
 
        }
    }
 
    public static void main(String[] args) {
        ADHero bh = new ADHero("赏金猎人",500,10,430);
        
 
        Hero h1 = new Hero();
        h1.name = "盖伦";
        Hero h2 = new Hero();
        h2.name = "提莫";
 
        bh.attack(h1);
        bh.attack(h1, h2);
 
    }
 
}