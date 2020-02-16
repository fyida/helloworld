package property;

public class LifePotion extends Item{
	public void effect() {
		System.out.println("血瓶使用后可以回血");
	}
	public boolean disposable() {
        return true;
    }
}
