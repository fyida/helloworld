package uml;

public abstract class Animals {
	protected Animals(int legs) {
		this.legs=legs;
	}
	protected int legs;
	public void walk() {
		System.out.println("动物行走使用"+legs+"条腿");
	}
	public abstract void eat();
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
