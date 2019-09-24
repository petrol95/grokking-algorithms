package serialization;

import java.io.Serializable;

public class Human implements Serializable {
    public int age;

    public Human() {
    }

    @Override
    public String toString() {
        return "serialization.Human{" +
                "age=" + age +
                '}';
    }
}
