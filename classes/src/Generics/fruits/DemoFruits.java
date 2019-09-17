package Generics.fruits;

public class DemoFruits {

    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);
        appleBox1.addFruit(apple3);
        appleBox2.addFruit(apple4);
        appleBox2.addFruit(apple5);
//        appleBox1.addFruit(orange1); // error

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);
//        orangeBox.addFruit(apple1); // error

        System.out.println(appleBox1.compare(orangeBox));
        System.out.println(appleBox2.compare(orangeBox));

//        appleBox1.empty(orangeBox); // error
        appleBox1.empty(appleBox2);
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
    }
}
