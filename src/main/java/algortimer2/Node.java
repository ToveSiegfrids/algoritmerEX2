package algortimer2;

import java.util.ArrayList;
import java.util.List;
/**
 * Create node and its methods
 */
public class Node {
    int indegree;
    int topNum;
    List<Node> neighbors;

    // Constructor
    public Node() {
        this.indegree = 0;            // Every node has 0 indegree
        this.topNum = 0;              // No topsort number yet (position in topological sort)
        this.neighbors = new ArrayList<>();  // No neighbors yet
    }

}
