package Graph;

public class Vertex {
    private String label;
    private boolean isWasVisited;

    public Vertex(String label) {
        this.label = label;
        isWasVisited = false;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isWasVisited() {
        return isWasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        isWasVisited = wasVisited;
    }

    @Override
    public String toString() {
        return label;
    }
}
