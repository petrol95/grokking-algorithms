import java.io.Serializable;
import java.util.Objects;

public class Person extends Human implements Serializable {
    public String name;
    public Person friend;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
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


}
