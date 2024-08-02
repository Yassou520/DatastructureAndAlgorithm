package recursion;

import java.util.ArrayList;
import java.util.List;

public class QueenN {
    public static void main(String[] args) {
        QueenN queenN = new QueenN();
        System.out.println(queenN.solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] arr = new int[n];
        solveNQueens(n,0,ans,arr);
        return ans;
    }
    public void solveNQueens(int n,int cur,List<List<String>> ans,int[] arr){
        if(cur==n){
            addAns(ans,arr,n);
            return;
        }
        for (int i=0;i<n;i++){
            arr[cur] = i;
            if (check(arr,cur)){
                solveNQueens(n,cur+1,ans,arr);
            }
        }
    }
    public boolean check(int[] arr,int n){
        for (int i=0;i<n;i++){
            if (arr[i]==arr[n] || (Math.abs(arr[i]-arr[n])==Math.abs(i-n))){
                return false;
            }
        }
        return true;
    }
    public void addAns(List<List<String>> ans,int[] arr,int n){
        List<String> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<n;j++){
                if (arr[i]==j){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        ans.add(list);
    }
}
