package charactor;

public class APHero extends Hero implements AP ,Mortal{
	public void die() {
		System.out.println("APhero die");
	}
	public void magicAttack() {
		System.out.println("进行魔法攻击");
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
