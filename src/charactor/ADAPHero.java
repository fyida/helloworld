package charactor;

public class ADAPHero extends Hero implements AD,AP,Mortal{
	public void die() {
		System.out.println("ADAPhero die");
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void magicAttack() {
		System.out.println("进行魔法攻击");
		
	}

	@Override
	public void physicAttack() {
		System.out.println("进行物理攻击");
		
	}

	@Override
	public void attack() {
		// TODO 自动生成的方法存根
		AD.super.attack();
	}

}
