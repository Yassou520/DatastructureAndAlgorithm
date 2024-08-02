package search;


import javax.xml.stream.XMLEventWriter;
import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] nums = {1,1,5,88,150,12021,12578};
        int index = fibonacciSearch(nums, 150);
        System.out.println(index);
    }
    public static int[] fib(){
        int[] fib = new int[20];
        fib[0] = 1;
        fib[1] = 1;
        for (int i=2;i<20;i++){
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib;
    }
    public static int fibonacciSearch(int[] arr,int target) {
        int low = 0;
        int high = arr.length-1;
        int k=0;
        int[] f = fib();
        int mid;
        while (high > f[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(arr,f[k]);
        for (int i=high+1;i<f[k];i++){
            temp[i] = arr[high];
        }
        while (low <= high){
            mid = low+f[k-1]-1;
            if (target < temp[mid]){
                high = mid-1;
                k--;
            }else if (target > temp[mid]){
                low = mid+1;
                k-=2;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
