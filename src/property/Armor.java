package property;

public class Armor extends Item{
	int ac;
	public Armor(String name,int price,int ac){
		super(name,price);
		this.ac=ac;
		
	}
	public static void main(String[] args) {
		Armor ahero=new Armor("ad",100,200);
	}
	public boolean disposable() {
        return false;
    }
}


