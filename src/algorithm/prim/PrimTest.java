package algorithm.prim;

import java.util.Arrays;

public class PrimTest {
    public static void main(String[] args) {
        char[] data = {'A','B','C','D','E','F','G'};
        int vertex = data.length;
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};
        MGraph mGraph = new MGraph(vertex);
        MiniGraph miniGraph = new MiniGraph();
        miniGraph.createGraph(mGraph,vertex,data,weight);
//        miniGraph.showGraph(mGraph);
        miniGraph.prim(mGraph,1);
    }
}

class MiniGraph {
    public void createGraph(MGraph graph,int vertex,char[] data,int[][] weight) {
        for (int i=0;i<vertex;i++){
            graph.data[i] = data[i];
            for (int j=0;j<vertex;j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    public void showGraph(MGraph graph) {
        for (int[] arr : graph.weight) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public void prim(MGraph graph,int v){
        boolean[] visited = new boolean[graph.vertex];
        int minWeight = 10000;
        int mi = -1;
        int mj = -1;
        visited[v] = true;
        for (int k=1;k<graph.vertex;k++){
            for (int i=0;i<graph.vertex;i++){
                for (int j=0;j< graph.vertex;j++){
                    if (visited[i]&&!visited[j]&&graph.weight[i][j]<minWeight){
                        minWeight = graph.weight[i][j];
                        mi = i;
                        mj = j;
                    }
                }
            }
            visited[mj] = true;
            System.out.println(graph.data[mi]+" - "+ graph.data[mj]+" weight "+graph.weight[mi][mj]);
            minWeight = 10000;
        }
    }
}
class MGraph {
    int vertex;
    char[] data;
    int[][] weight;
    public MGraph(int vertex){
        this.vertex = vertex;
        data = new char[vertex];
        weight = new int[vertex][vertex];
    }
}
