package Competitors;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Animal animal) {
        animal.jump(height);
    }
}
