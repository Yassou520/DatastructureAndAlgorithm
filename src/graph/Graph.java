package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Graph {
    private List<String> vertexList;
    private int[][] edges;
    private int numOfEdges;

    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }
    public int getFirstNeighbor(int index){
        for (int i=0;i < vertexList.size();i++){
            if (edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    public int getNextNeighbor(int v1,int v2){
        for (int i=v2+1;i<vertexList.size();i++){
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
    public String getValueByIndex(int index){
        return vertexList.get(index);
    }
    private void dfs(boolean[] visited,int i){
        System.out.print(getValueByIndex(i)+"->");
        visited[i]=true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!visited[w]){
                dfs(visited,w);
            }
            w=getNextNeighbor(i,w);
        }
    }
    public void dfs(){
        boolean[] visited = new boolean[vertexList.size()];
        for (int i=0;i<vertexList.size();i++){
            if (!visited[i]){
                dfs(visited,i);
            }
        }
    }

    public void bfs() {
        boolean[] visited = new boolean[vertexList.size()];
        for (int i=0;i<vertexList.size();i++){
            if (!visited[i]){
                bfs(visited,i);
            }
        }
    }

    private void bfs(boolean[] visited, int i) {
        Deque<Integer> queue = new ArrayDeque<>();
        System.out.print(getValueByIndex(i)+"->");
        visited[i] = true;
        queue.addLast(i);
        int u,w;
        while (!queue.isEmpty()){
            u = queue.pollFirst();
            w = getFirstNeighbor(u);
            while (w!=-1){
                if (!visited[w]){
                    System.out.print(getValueByIndex(w)+"->");
                    visited[w]=true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }
}
