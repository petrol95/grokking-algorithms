package Competitors;

public class Cross extends Obstacle {
    private int distance;

    public Cross(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Animal animal) {
        animal.run(distance);
    }
}
