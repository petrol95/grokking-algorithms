package HashMap.Phonebook;

public class MainClass {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "123456");
        phonebook.add("Иванов", "765432");
        phonebook.add("Петров", "545678");
        System.out.println("Иванов: " + phonebook.get("Иванов"));
    }
}
