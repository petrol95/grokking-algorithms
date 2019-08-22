package Graph.Dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String name;

    private List<Node> shortestPath;

    private Integer distance;

    private Map<Node, Integer> adjNodes;

    public Node(String name) {
        this.name = name;
        shortestPath = new LinkedList<>();
        distance = Integer.MAX_VALUE;
        adjNodes = new HashMap<>();
    }

    public void addDestination(Node destination, int distance) {
        adjNodes.put(destination, distance);
    }
}
