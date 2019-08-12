package Graph;

public class Vertex {
    private final String label;
    private boolean wasVisited;
    private Vertex previousVertex; // next vertex while searching

    public Vertex(String label) {
        this.label = label;
        wasVisited = false;
        previousVertex = null;
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

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    @Override
    public String toString() {
        return label;
    }
}
