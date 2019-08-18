package Competitors;

public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
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
