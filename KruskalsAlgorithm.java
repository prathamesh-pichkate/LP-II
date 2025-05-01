import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wgt;

        public Edge(int src, int dest, int wgt) {
            this.src = src;
            this.dest = dest;
            this.wgt = wgt;
        }
    }

    // Union-Find (Disjoint Set) class to handle cycles and merging
    static class UnionFind {
        int parent[];
        int rank[];

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // Path compression
            }
            return parent[u];
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU != rootV) {
                // Union by rank
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            }
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        // Creating the graph as an edge list
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void printMST(ArrayList<Edge> graph[]) {
        // Edge list to sort based on weight
        ArrayList<Edge> allEdges = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            allEdges.addAll(graph[i]);
        }

        // Sort all edges based on weight (ascending order)
        Collections.sort(allEdges, (a, b) -> a.wgt - b.wgt);

        UnionFind uf = new UnionFind(graph.length);
        int finalCost = 0;

        // Kruskal's algorithm
        for (Edge edge : allEdges) {
            int srcParent = uf.find(edge.src);
            int destParent = uf.find(edge.dest);

            // If src and dest belong to different sets, include the edge
            if (srcParent != destParent) {
                uf.union(srcParent, destParent);
                finalCost += edge.wgt;
            }
        }

        System.out.println(finalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        printMST(graph);
    }
}
