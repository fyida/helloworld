package charactor;

public interface AP {
	public void magicAttack();
	default public void attack() {
        System.out.println(this.getClass().getName() + "攻击AD");
    }
}
