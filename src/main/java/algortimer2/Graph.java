package algortimer2;

import java.util.*;

public class Graph {

        private Map<String, Node> nodes = new HashMap<>();

        public Node addNode(String name) {
            nodes.putIfAbsent(name, new Node(name));
            return nodes.get(name);
        }

        public void addEdge(String from, String to) {
            Node n1 = addNode(from);
            Node n2 = addNode(to);
            n1.addNeighbor(n2);
        }

        public void topSort() {
            // Compute in-degree for all nodes
            Map<Node, Integer> inDegree = new HashMap<>();
            for (Node n : nodes.values()) {
                inDegree.putIfAbsent(n, 0);
            }

            for (Node n : nodes.values()) {
                for (Node neigh : n.getNeighbors()) {
                    inDegree.put(neigh, inDegree.get(neigh) + 1);
                }
            }

            // Queue for nodes with in-degree 0
            Queue<Node> queue = new LinkedList<>();
            for (Node n : inDegree.keySet()) {
                if (inDegree.get(n) == 0) {
                    queue.add(n);
                }
            }

            List<String> topOrder = new ArrayList<>();

            while (!queue.isEmpty()) {
                Node n = queue.poll();
                topOrder.add(n.getName());

                for (Node neigh : n.getNeighbors()) {
                    inDegree.put(neigh, inDegree.get(neigh) - 1);
                    if (inDegree.get(neigh) == 0) {
                        queue.add(neigh);
                    }
                }
            }

            // Check for cycles
            if (topOrder.size() != nodes.size()) {
                System.out.println("Grafen innehåller en cykel. Topologisk sortering är inte möjlig.");
                return;
            }

            // Print result
            System.out.println("Topologisk ordning:");
            for (String s : topOrder) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
