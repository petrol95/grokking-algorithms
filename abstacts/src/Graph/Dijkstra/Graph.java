package Graph.Dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Node> nodes;

    public Graph() {
        nodes = new HashSet<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }
}
