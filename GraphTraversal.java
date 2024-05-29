import java.util.Iterator;
import java.util.LinkedList;

public class GraphTraversal {
    private int numVertices;
    private LinkedList<Integer> adjList[];

    // Graph constructor
    GraphTraversal(int vertices) {
        numVertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // BFS traversal from a given source node
    void BFS(int startNode) {
        boolean visited[] = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[startNode] = true;
        queue.add(startNode);

        while (queue.size() != 0) {
            startNode = queue.poll();
            System.out.print(startNode + " ");

            Iterator<Integer> i = adjList[startNode].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // DFS traversal from a given source node
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int startNode) {
        boolean visited[] = new boolean[numVertices];
        DFSUtil(startNode, visited);
    }

    public static void main(String args[]) {
        GraphTraversal g = new GraphTraversal(6);

        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(1, 0);
        g.addEdge(1, 5);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(4, 0);
        g.addEdge(4, 5);
        g.addEdge(5, 0);
        g.addEdge(5, 1);
        g.addEdge(5, 4);

        System.out.println("Breadth-First Search (starting from node 3):");
        g.BFS(3);

        System.out.println("\nDepth-First Search (starting from node 3):");
        g.DFS(3);
    }
}
