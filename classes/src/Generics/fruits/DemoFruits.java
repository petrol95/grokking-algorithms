package Generics.fruits;

public class DemoFruits {

    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
//        appleBox1.addFruit(new Orange()); // error

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
//        orangeBox.addFruit(new Apple()); // error

        System.out.println(appleBox1.compare(orangeBox));
        System.out.println(appleBox2.compare(orangeBox));

//        appleBox1.empty(orangeBox); // error
        appleBox1.empty(appleBox2);
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
    }
}
