package Competitors;

public class MainCompetition {

    public static void main(String[] args) {
        Team team = new Team("Команда 1");
        Course course = new Course(400, 8, 1);
        course.doIt(team);
        team.showResult();
        team.showWinResult();
    }
}
