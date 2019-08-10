package Graph;

import java.util.*;

public class Graph {
    private List<Vertex> vertexes;
    private boolean [][] adjMatrix;
    private int size;

    public Graph(int maxSize) {
        vertexes = new ArrayList<>(maxSize);
        adjMatrix = new boolean[maxSize][maxSize];
        this.size = maxSize;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = false;
            }
        }
    }

    public boolean addEdge(String labelFrom, String labelTo) {
        Vertex vertexFrom = findVertex(labelFrom);
        Vertex vertexTo = findVertex(labelTo);

        if (vertexFrom == null || vertexTo == null) {
            return false;
        }

        int indFrom = vertexes.indexOf(vertexFrom);
        int indTo = vertexes.indexOf(vertexTo);

        adjMatrix[indFrom][indTo] = true;
        adjMatrix[indTo][indFrom] = true;

        return true;
    }

    private Vertex findVertex(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexes.get(i).getLabel().equals(label))
                return vertexes.get(i);
        }
        return null;
    }

    public void addVertex(String label) {
        vertexes.add(new Vertex(label));
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexes.get(i) + " ");
        }
    }

    public void dfs(String startLabel) {
        Vertex vertex = findVertex(startLabel);
        if (vertex == null)
            throw new IllegalArgumentException("Invalid label " + startLabel);
        else {
            Stack<Vertex> stack = new Stack();
            visitVertex(vertex, stack);

            while(!stack.empty()) {
                vertex = getAdjUnvisitedVertex(stack.peek());
                if (vertex == null) {
                    stack.pop();
                } else {
                    visitVertex(vertex, stack);
                }
            }

            for (int i = 0; i < size; i++) {
                vertexes.get(i).setWasVisited(false);
            }
        }
    }

    public void bfs(String startLabel) {
        Vertex vertex = findVertex(startLabel);
        if (vertex == null)
            throw new IllegalArgumentException("Invalid label " + startLabel);
        else {
            Queue<Vertex> queue = new ArrayDeque();
            visitVertex(vertex, queue);

            while(!queue.isEmpty()) {
                vertex = getAdjUnvisitedVertex(queue.peek());
                if (vertex == null) {
                    queue.remove();
                } else {
                    visitVertex(vertex, queue);
                }
            }

            for (int i = 0; i < size; i++) {
                vertexes.get(i).setWasVisited(false);
            }
        }
    }

    private void visitVertex(Vertex vertex, Stack<Vertex> stack) {
        vertex.setWasVisited(true);
        System.out.print(vertex + " ");
        stack.push(vertex);
    }

    private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        vertex.setWasVisited(true);
        System.out.print(vertex + " ");
        queue.add(vertex);
    }

    private Vertex getAdjUnvisitedVertex(Vertex vertex) {
        int startIndex = vertexes.indexOf(vertex);
        for (int i = 0; i < size; i++) {
            if (!vertexes.get(i).isWasVisited() && adjMatrix[startIndex][i]) {
                return vertexes.get(i);
            }
        }
        return null;
    }
}
