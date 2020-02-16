package property;

public abstract class Item {
	String name;
	int price;
	public Item() {}
	public Item(String name,int price) {
		this.name=name;
		this.price=price;
	}
	public void buy() {
		System.out.println("买它");
	}
	public void effect() {
		System.out.println("物品有效果");
	}
	public abstract boolean disposable();
	
}
