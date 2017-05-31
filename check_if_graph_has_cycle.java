import java.util.*;

public class GraphTraversal {

    private static class Graph {

        int nVertices;
        boolean isDirected; // Directed or Undirected graph
        Map<Integer, List<Integer>> adjacencyList;

        Graph(int nVertices, boolean isDirected) {
            this.nVertices = nVertices;
            this.isDirected = isDirected;
            adjacencyList = new HashMap<>();
        }

        void addEdge(int U, int V) {
            List<Integer> URow = adjacencyList.get(U);
            if (URow == null)
                URow = new LinkedList<>();
            URow.add(V);
            adjacencyList.put(U, URow);

            // For Undirected graph add the reverse (V, U) edge
            if (!isDirected) {
                List<Integer> VRow = adjacencyList.get(V);
                if (VRow == null)
                    VRow = new LinkedList<>();
                VRow.add(U);
                adjacencyList.put(V, VRow);
            }
        }

        void checkCycle() {

            boolean visited[] = new boolean[nVertices];

            for (int i = 0; i < nVertices; i++) {
                if (isDirected)
                    dfs(i, visited, "");
                else
                    dfsUndirected(i, visited, "", -1);
            }
            System.out.println();
        }

        // Same as DFS for Directed Graph
        // Except that keep track of parent
        private void dfsUndirected(int i, boolean[] visited, String cycle, int parent) {

            visited[i] = true;
            cycle += i;

            List<Integer> adjacentVertices = adjacencyList.get(i);

            String finalCycle = cycle;

            if (adjacentVertices != null) {

                adjacentVertices.forEach(vertex -> {

                    // second condition to avoid below case
                    // 1 -> 0 -> 1 (or) 0 -> 1 -> 0     (0 <--> 1)

                    if (visited[vertex]) {
                        if (parent != vertex)
                            System.out.println("Has Cycle " + Arrays.toString(visited) + "   " + finalCycle + vertex);
                    } else
                        dfsUndirected(vertex, visited, finalCycle, i);
                });
            }
            visited[i] = false;
        }


        private void dfs(int i, boolean visited[], String cycle) {

            visited[i] = true;
            cycle += i;

            List<Integer> adjecentVertices = adjacencyList.get(i);

            String finalCycle = cycle;

            if (adjecentVertices != null) {

                adjecentVertices.forEach(vertex -> {
                    if (visited[vertex])
                        System.out.println("Has Cycle " + Arrays.toString(visited) + "   " + finalCycle + vertex);
                    else
                        dfs(vertex, visited, finalCycle);
                });
            }

            // remove visited vertex from recursion stack (like backtracking),
            // so that visited array won't be set by other recursive calls

            visited[i] = false;
        }

        void printGraph() {
            adjacencyList.forEach((key, value) -> {
                        System.out.print("[" + key + "] --> ");
                        value.forEach(item -> System.out.print(item + " --> "));
                        System.out.println("NULL");
                    }
            );
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4, true);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        graph.addEdge(1, 2);

        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        graph.addEdge(3, 3);

        graph.printGraph();

        graph.checkCycle();

        Graph graph2 = new Graph(3, true);

        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(0, 2);

        graph2.printGraph();

        graph2.checkCycle();

        Graph undirectedGraph = new Graph(5, false);

        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(0, 3);
        undirectedGraph.addEdge(0, 2);
        undirectedGraph.addEdge(3, 4);

        undirectedGraph.printGraph();

        undirectedGraph.checkCycle();

        Graph undirectedGraph2 = new Graph(3, false);

        undirectedGraph2.addEdge(0, 1);
        undirectedGraph2.addEdge(1, 2);

        undirectedGraph2.printGraph();

        undirectedGraph2.checkCycle();
    }

}
