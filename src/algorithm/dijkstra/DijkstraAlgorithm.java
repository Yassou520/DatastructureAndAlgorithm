package algorithm.dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        Graph graph = new Graph(vertex, matrix);
        graph.dijkstra(6);
        graph.showDjk();
    }
}
class Graph {
    int[][] matrix;
    char[] vertex;
    VisitedVertex vv;
    public Graph(char[] vertex,int[][] matrix){
        this.vertex = vertex;
        this.matrix = matrix;
    }
    //更通过前驱加上目前和之前的dis比较，更新dis(初始dis为N)
    private void update(int index){
        int len = 0;
        for (int i=0;i<matrix[index].length;i++){
            len = vv.getDis(index) + matrix[index][i];
            if (!vv.isVisited(i) && len<vv.getDis(i)){
                vv.updatePre(i,index);
                vv.updateDis(i,len);
            }
        }
    }
    public void dijkstra(int index){
        vv = new VisitedVertex(vertex.length,index);
        update(index);
        for (int i=1;i< vertex.length;i++){
            index = vv.updateArr();
            update(index);
        }
    }
    public void showDjk(){
        for (int i=0;i<vv.alreadyVisited.length;i++){
            System.out.print(vertex[i]+"("+vv.getDis(i)+")"+" ");
        }
        System.out.println();
    }
}
class VisitedVertex {
    public int[] alreadyVisited;
    public int[] dis;
    public int[] pre;
    public VisitedVertex(int length,int index){
        this.alreadyVisited = new int[length];
        dis = new int[length];
        pre = new int[length];
        Arrays.fill(dis,65535);
        alreadyVisited[index] = 1;
        dis[index] = 0;
    }
    public boolean isVisited(int index){
        return alreadyVisited[index] == 1;
    }
    public void updateDis(int index,int len){
        dis[index] = len;
    }
    public void updatePre(int index,int pre){
        this.pre[index] = pre;
    }
    public int getDis(int index){
        return dis[index];
    }
    public int updateArr() {
        int min = 65535,index = 0;
        for (int i=0;i<alreadyVisited.length;i++){
            if (!isVisited(i) && getDis(i)<min){
                index = i;
                min = getDis(i);
            }
        }
        alreadyVisited[index] = 1;
        return index;
    }
}
