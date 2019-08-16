package Competitors;

public class Team {
    String name;
    Competitor[] competitors;

    public Team(String name) {
        this.name = name;
        competitors = new Competitor[]{new Cat("Барсик"), new Dog("Бобик"), new Human("Боб")};
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showResult() {
        System.out.println("===========");
        for (Competitor competitor : competitors) {
            competitor.showResult();
        }
    }

    public void showWinResult() {
        System.out.println("===========");
        for (Competitor competitor : competitors) {
            if (competitor.isOnDistance())
                competitor.showResult();
        }
    }
}
