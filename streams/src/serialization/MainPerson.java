package serialization;

import java.io.*;

public class MainPerson {

    public static void main(String[] args) throws Exception {
        Person p1 = new Person("person 1");
        Person p2 = new Person("person 2");
        Person p3 = new Person("person 3");

        p1.friend = p3;
        p1.age = 25;
        p2.friend = p3;

        System.out.println(p1);
        System.out.println(p2);

//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(os);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("streams/objects.txt"));
        oos.writeObject(p1);
        oos.writeObject(p2);
//        p1.writeExternal(oos);
//        p2.writeExternal(oos);

//        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(is);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("streams/objects.txt"));
        Person p4 = (Person) ois.readObject();
        Person p5 = (Person) ois.readObject();
//        Person p4 = new Person();
//        Person p5 = new Person();
//        p4.readExternal(ois);
//        p5.readExternal(ois);

        System.out.println(p4);
        System.out.println(p5);
    }
}
