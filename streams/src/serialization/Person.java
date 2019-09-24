package serialization;

import java.io.*;
import java.util.Objects;

public class Person extends Human implements Serializable {
    public String name;
    public transient  Person friend;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "serialization.Person{" +
                "name='" + name + '\'' +
                ", friend=" + friend +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(friend, person.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, friend);
    }

//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeObject(name);
//        out.writeObject(friend);
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        name = (String) in.readObject();
//        friend = (serialization.Person) in.readObject();
//    }
}
