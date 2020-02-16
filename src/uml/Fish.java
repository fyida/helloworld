package uml;

public class Fish extends Animals implements Pet{
	private String name;
	public Fish() {
		super(0);
	}
	public void walk(){
		System.out.println("鱼不能走且没有腿。");
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
		 System.out.println("我游泳"); 
		
	}
	@Override
	public void eat() {
		System.out.println("我吃饲料");
		
	}
}
