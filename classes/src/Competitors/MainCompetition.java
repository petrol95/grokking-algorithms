package Competitors;

public class MainCompetition {

    public static void main(String[] args) {
        Team team = new Team("Команда_1", new Cat("Барсик"),
                new Dog("Бобик"), new Human("Боб"), new Cat("Мурзик"));
        Course course = new Course(new Cross(400), new Wall(8),
                new Water(1), new Wall(10));
        course.doIt(team);
        team.showResult();
        team.showWinResult();
    }
}
