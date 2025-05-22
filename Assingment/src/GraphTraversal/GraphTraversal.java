package GraphTraversal;

import java.util.*;

public class GraphTraversal {
    private static HashMap<Integer, String> nodeNames = new HashMap<>();
    private static HashMap<Integer, ArrayList<Integer>> childNodes = new HashMap<>();
    private static HashMap<Integer, Integer> parentCount = new HashMap<>();
    private static ArrayList<String> executionOrder = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes
        int numNodes = scanner.nextInt();
        scanner.nextLine(); // Move to next line

        // Read each node's details
        for (int i = 0; i < numNodes; i++) {


            String[] parts = scanner.nextLine().split(":");
            int nodeId = Integer.parseInt(parts[0]);
            String nodeName = parts[1];
            nodeNames.put(nodeId, nodeName);
            childNodes.put(nodeId, new ArrayList<>());
            parentCount.put(nodeId, 0);
        }

        // Read number of edges
        int numEdges = scanner.nextInt();
        scanner.nextLine(); // Move to next line

        // Read each edge and update child nodes and parent counts
        for (int i = 0; i < numEdges; i++) {
            String[] parts = scanner.nextLine().split(":");
            int fromNode = Integer.parseInt(parts[0]);
            int toNode = Integer.parseInt(parts[1]);
            childNodes.get(fromNode).add(toNode);
            parentCount.put(toNode, parentCount.get(toNode) + 1);
        }

        // Start processing from the root node (ID 1)
        processNode(1);

        // Print the execution order and total count
        for (String node : executionOrder) {
            System.out.println(node);
        }
        System.out.println(executionOrder.size());
    }

    private static void processNode(int currentNodeId) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentNodeId);

        while (!queue.isEmpty()) {
            int nodeId = queue.poll();

            // Only process if all parent nodes have been executed
            if (parentCount.get(nodeId) != 0) {
                continue;
            }

            // Add current node to the execution order
            executionOrder.add(nodeNames.get(nodeId));

            // Process all child nodes
            for (int childId : childNodes.get(nodeId)) {
                // Decrease the parent count for the child node
                parentCount.put(childId, parentCount.get(childId) - 1);

                // Add child node to the queue
                queue.add(childId);
            }
        }
    }
}