import java.util.*;
public class BFSDFS{

    // Function to perform BFS on the graph
    public static void BFS(int graph[][], int start,boolean visited[]){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");

            for(int i : graph[node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    //Function to perform DFS on the graph
    public static void DFS(int graph[][],int start,boolean visited[]){
        visited[start] = true;
        System.out.print(start + " ");

        for(int i : graph[start]){
            if(!visited[i]){
                DFS(graph,i,visited);
            }
        }
    }

    public static void main(String[] args){
        //Adjacency list representation of the graph
        int graph[][] = {{1,2},{0,2,3},{0,1,4},{1,5},{2,5},{3,4,6},{5}};
        int n = graph.length;
        boolean visited[] = new boolean[graph.length];
        System.out.println("BFS Traversal starting from node 3:");
        BFS(graph, 3, visited);

        System.out.println("\nDFS Traversal starting from node 3:");
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }
        DFS(graph, 3, visited);


    }
}