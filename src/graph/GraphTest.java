package graph;

public class GraphTest {
    public static void main(String[] args) {
        //测试一把图是否创建 ok
        int n = 8; //结点的个数
        //String Vertexs[] = {"A", "B", "C", "D", "E"};
        String vertexes[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for(String vertex: vertexes) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.dfs();
        System.out.println();
        graph.bfs();
    }
}
