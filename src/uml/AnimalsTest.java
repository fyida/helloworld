package uml;

public class AnimalsTest {
    public static void main(String[] arga)
    {
        Spider zz=new Spider();
        zz.walk();
        zz.eat();
        Cat mm=new Cat("maomi");
        mm.walk();
        mm.eat();
        mm.play();
        System.out.println(mm.getName());  //Cat类中 name被private修饰，只能用getName间接访问
        mm.setName("狗猫咪");
        System.out.println(mm.getName());
        Fish ff=new Fish();
        ff.walk();
        ff.eat();
        ff.play();
         
    }
}
