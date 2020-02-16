package uml;

public class Cat extends Animals implements Pet {
	private String name;

	public Cat(String name){
		super(4);
		this.name=name;
	}
	public Cat(){
		this("");
	}
	public void eat() {
		System.out.println("我爱吃鱼🐟");
	}
	@Override
	public String getName() {

		return this.name;
	}
	@Override
	public void setName(String name) {
		this.name=name;
		
	}
	@Override
	public void play() {
		System.out.println("我喜欢玩毛线团");
		
	}
	
}
