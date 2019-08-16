package Competitors;

public class MainCompetition {
    public static void main(String[] args) {
        Competitor[] competitors = { new Cat("Барсик"), new Dog("Бобик"), new Human("Боб") };
        Obstacle[] obstacles = { new Cross(500), new Wall(4), new Water(50)};

        for (Competitor competitor : competitors) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(competitor);
                if(!competitor.isOnDistance())
                    break;
            }

        }
    }
}
