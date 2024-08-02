package algorithm.dynamic;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3};
        int[] val = {1500,3000,2000};
        int m = 4;
        int n = w.length;
        int[][] v = new int[n+1][m+1];
        for (int i = 1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if (w[i-1] >j){
                    v[i][j] = v[i-1][j];
                }else {
                    v[i][j] = Math.max(v[i-1][j],v[i-1][j-w[i-1]]+val[i-1]);
                }
            }
        }
        System.out.println(v[n][m]);
    }
}
