package Competitors;

public class Water extends Obstacle {
    private int distance;

    public Water(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Animal animal) {
        animal.swim(distance);
    }
}
