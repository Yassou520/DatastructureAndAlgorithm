package search;

public class SearchTestClient {
    public static void main(String[] args) {
        int n = 1000;
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=i+1;
        }
//        int index = BinarySearch.binarySearch(arr, 0, arr.length - 1, 1);
//        int index = InsertValueSearch.insertValueSearch(arr,0,arr.length-1,1);
        int index = FibonacciSearch.fibonacciSearch(arr,88);
        System.out.println(index);
    }
}
