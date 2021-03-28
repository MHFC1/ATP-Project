package algorithms.test;
import algorithms.GraphExample.*;
public class testWeighteGraph {
    public static void main(String[] args) {
        int vertices = 6;
        WeightedGraph graph = new WeightedGraph(vertices);
        graph.addEgde(0, 1, 4);
        graph.addEgde(0, 2, 3);
        graph.addEgde(1, 3, 2);
        graph.addEgde(1, 2, 5);
        graph.addEgde(2, 3, 7);
        graph.addEgde(3, 4, 2);
        graph.addEgde(4, 0, 4);
        graph.addEgde(4, 1, 4);
        graph.addEgde(4, 5, 6);
        graph.printGraph();
    }
}
