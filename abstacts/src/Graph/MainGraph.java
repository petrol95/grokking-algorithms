package Graph;

import java.util.Stack;

public class MainGraph {
    public static void main(String[] args) {
//        testGraph();
        testDZ();
    }

    private static void testDZ() {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Москва", "Рязань");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Москва", "Калуга");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

        Stack<String> root = graph.findBestRoot("Москва", "Воронеж");
        System.out.println("\nThe best root:");
        System.out.println(String.join(" -> ", root));
    }

    private static void testGraph() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");
        graph.addEdge("E", "H");

        graph.display();
        System.out.println();

        graph.dfs("A");
        System.out.println();

        graph.bfs("A");
    }
}
