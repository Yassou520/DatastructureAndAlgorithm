package sort;

public class QuickSort {
    public static void quickSort(int[] arr){
        int n = arr.length;
        quickSort(arr,0,n-1);
    }
    public static void quickSort(int[] arr,int start,int end){
        if (start>=end){
            return;
        }
        int left=start,right=end;
        int pivot = arr[start];
        while(left<right){
            while (left<right&&arr[right]>=pivot){
                right--;
            }
            arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=pivot;
        quickSort(arr,start,left-1);
        quickSort(arr,left+1,end);
    }
}
