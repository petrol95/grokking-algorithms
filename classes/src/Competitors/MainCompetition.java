package Competitors;

public class MainCompetition {
    public static void main(String[] args) {
        Animal[] animals = { new Cat("Барсик"), new Dog("Бобик") };
        Obstacle[] obstacles = { new Cross(500), new Wall(4), new Water(50)};

        for (Animal animal : animals) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(animal);
                if(!animal.isOnDistance())
                    break;
            }

        }
    }
}
