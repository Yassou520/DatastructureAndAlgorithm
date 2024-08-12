package algorithm.kruskal;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalCase {
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
/*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ { 0, 12, INF, INF, INF, 16, 14},
                /*B*/ { 12, 0, 10, INF, INF, 7, INF},
                /*C*/ { INF, 10, 0, 3, 5, 6, INF},
                /*D*/ { INF, INF, 3, 0, 4, INF, INF},
                /*E*/ { INF, INF, 5, 4, 0, 2, 8},
                /*F*/ { 16, 7, 6, INF, 2, 0, 9},
                /*G*/ { 14, INF, INF, INF, 8, 9, 0}};
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.kruskal();
    }
    private char[] vertex;
    private int[][] matrix;
    private int edgeNum;
    private static final int INF = Integer.MAX_VALUE;

    public KruskalCase(char[] vertex,int[][] matrix){
        int vLen = vertex.length;
        this.vertex = new char[vLen];
        for (int i=0;i<vLen;i++){
            this.vertex[i] = vertex[i];
        }
        this.matrix = new int[vLen][vLen];
        for (int i=0;i<vLen;i++){
            for (int j=i+1;j<vLen;j++){
                this.matrix[i][j] = matrix[i][j];
                if (i!=j && matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }
    public void kruskal(){
        int[] ends = new int[vertex.length];
        Edge[] rets = new Edge[edgeNum];
        Edge[] edges = getEdges();
        sortEdges(edges);
        int index = 0;
        for (int i=0;i<edgeNum;i++){
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);
            if (m!=n){
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }
        for (int i=0;i<index;i++){
            System.out.println(rets[i]);
        }
    }
    private Edge[] getEdges(){
        int index = 0;
        Edge[] edges = new Edge[edgeNum];
        for (int i=0;i< vertex.length;i++){
            for (int j=i+1;j< vertex.length;j++){
                if (matrix[i][j]!=INF){
                    edges[index++]=new Edge(vertex[i],vertex[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }
    private int getPosition(char c){
        for (int i=0;i< vertex.length;i++){
            if (vertex[i] == c){
                return i;
            }
        }
        return -1;
    }
    private int getEnd(int[] ends,int i){
        while (ends[i]!=0){
            i = ends[i];
        }
        return i;
    }
    private void sortEdges(Edge[] edges) {
        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));
    }
}
class Edge {
    char start;
    char end;
    int weight;
    public Edge(char start,char end,int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[<"+start+","+end+">="+weight+"]";
    }
}
