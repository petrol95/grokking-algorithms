package Graph;

public class Vertex {
    private String label;
    private boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
        wasVisited = false;
    }

    public String getLabel() {
        return label;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    @Override
    public String toString() {
        return label;
    }
}
