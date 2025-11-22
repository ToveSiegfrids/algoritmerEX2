package algortimer2;

import java.util.ArrayList;
import java.util.List; /**
     * create node and its methods
     */
    public class Node {
    int indegree;
    int topNum;
    List<Node> neighbors;

    // Konstruktor
    public Node() {
        this.indegree = 0;            //every node has 0 indegree
        this.topNum = 0;              //no topsort number yet (position in topological sort)
        this.neighbors = new ArrayList<>();  // no neighbors yet
    }

}
