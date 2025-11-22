package algortimer2;

import java.util.ArrayList;
import java.util.List; /**
     * create node and its methods
     */
    public class Node {
    String name;
    List<Node> neighbors; //incidenslist

        // Constructor
    public Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>(); //list that collects all the neighbors of a node
    }
    //adds a neighbor node to the list of neighbors
    public void addNeighbor(Node n) {
        neighbors.add(n);
    }

    public String getName() {
        return name;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }
}
