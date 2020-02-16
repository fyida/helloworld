package charactor;
public class SupportHero extends Hero implements Healer{
	public void heal() {
		System.out.println(name +"进行了一次治疗 ，但是不确定打中谁了" );
	}
	public void heal(Hero...Heros){
		for(int i=0;i<Heros.length;i++) {
			System.out.println(name+"治疗了"+Heros[i].name);
		}
	}
	public static void main(String[] args) {
		SupportHero naima=new SupportHero();
		
	}
}
