package sort;


import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,1,2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        mergeSort(arr,0,n-1,temp);
    }

    static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left==right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid+1,right,temp);
        merge(arr,left,mid,right,temp);
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left,j = mid+1;
        int t = 0;
        while (i<=mid && j <= right){
            temp[t++] = arr[i]<=arr[j]?arr[i++]:arr[j++];
        }
        while (i<=mid){
            temp[t++]=arr[i++];
        }
        while (j<=right){
            temp[t++]=arr[j++];
        }
        //从left开始拷贝到right
        i=left;
        t=0;
        while (i<=right){
            arr[i++]=temp[t++];
        }
    }
}
