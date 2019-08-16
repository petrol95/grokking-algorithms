package Competitors;

public class Course {
    Obstacle[] obstacles;

    public Course(int runDistance, int jumpHeight, int swimDistance) {
        obstacles = new Obstacle[]{ new Cross(runDistance), new Wall(jumpHeight), new Water(swimDistance)};
    }

    public void doIt(Team team) {
        for (Competitor competitor : team.getCompetitors()) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(competitor);
                if(!competitor.isOnDistance())
                    break;
            }
        }
    }


}
