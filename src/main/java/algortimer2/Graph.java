package algortimer2;

import java.util.*;

public class Graph {
    private Map<String, Node> nodeMap;
    private List<Node> nodes;            // list in insertion order

    // Constructor
    public Graph() {
        nodeMap = new HashMap<>();
        nodes = new ArrayList<>();
    }

    // Add a node to the graph if it doesn't exist yet
     public void addNode(String name) {
        if (!nodeMap.containsKey(name)) {
            Node n = new Node();
            nodeMap.put(name, n);
            nodes.add(n);
        }
    }

    // Add an edge between two nodes
    public void addEdge(String from, String to) {
        Node n1 = nodeMap.get(from);
        Node n2 = nodeMap.get(to);

        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("Unknown node name in edge: " + from + ":" + to);
        }

        n1.neighbors.add(n2); // Add n2 to the neighborlist of n1
        n2.indegree++; //indegree of n2 increases
    }


    // Topological sort of the graph
    public void topSort() throws CycleFound {
        Queue<Node> zeroIndegreeList = new LinkedList<>();
        int counter = 0;

        // Put all nodes with indegree 0 into queue
        for (Node v : nodes) { //goes though every node
            if (v.indegree == 0) //if no node goes "into" this node
                zeroIndegreeList.add(v); //we add it to the queue of nodes with indegree 0
        }

        //until the queue of nodes with indegree 0 is empty
        while (!zeroIndegreeList.isEmpty()) {
            Node v = zeroIndegreeList.remove(); //we remove the first node in the queue
            v.topNum = ++counter; //we set the topological number of this node and increase the counter (next nodes position number)

            for (Node w : v.neighbors) { //for every neighbor of that node
                if (--w.indegree == 0) //if the neighbor has no more incoming edges
                    zeroIndegreeList.add(w); //we add it to the queue of nodes with indegree 0
            }
        }

        // Cycle check
        if (counter != nodes.size()) //if the counter is not equal to the number of nodes
            throw new CycleFound(); //it means that the graph contains a cycle

        //if that not happens, and we are done with the while loop, the graph is sorted yeyy

        //print the topological order
        System.out.println("Topological order:");
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(" " + nodes.get(i).topNum);
        }

    }
}

// Exception class
class CycleFound extends Exception {
    public CycleFound() {
        super("Graph contains a cycle, cannot be sorted =(");
    }
}

