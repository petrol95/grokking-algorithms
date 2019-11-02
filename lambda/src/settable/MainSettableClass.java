package settable;

public class MainSettableClass {

    public static void main(String[] args) {
        // empty Cat
        Cat myCat = new Cat();
        System.out.println(myCat);

        Settable<Cat> s = (obj, name, age) -> {
            obj.setName(name);
            obj.setAge(age);
        };

        // changed Cat
        changeEntity(myCat, s);
        System.out.println(myCat);
    }

    private static <T extends WithNameAndAge> void changeEntity(T entity, Settable<T> s) {
        s.set(entity, "Мурзик", 3);
    }
}
