package Competitors;

public interface Competitor {
    boolean isOnDistance();

    void run(int distance);

    void jump(int height);

    void swim(int distance);

    void showResult();
}
