package Competitors;

public class Team {
    String name;
    Competitor[] competitors;

    public Team(String name, Competitor... competitors) {
        this.name = name;
        this.competitors = competitors;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showResult() {
        System.out.println("=== Team: " + name + "===");
        System.out.println("competitors:");
        for (Competitor competitor : competitors) {
            competitor.showResult();
        }
    }

    public void showWinResult() {
        System.out.println("=== Team: " + name + "===");
        System.out.println("winners:");
        for (Competitor competitor : competitors) {
            if (competitor.isOnDistance())
                competitor.showResult();
        }
    }
}
