package tree;

public class HeapSort {

    public static void heapSort(int[] arr) {
        int temp;
        int len = arr.length;
        for (int i=len/2-1;i>=0;i--){
            adjustHeap(arr,i,len);
        }
        for (int j=len-1;j>0;j--){
            temp=arr[0];
            arr[0]=arr[j];
            arr[j]=temp;
            adjustHeap(arr,0,j);
        }
    }
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int k=2*i+1;k < length;k=k*2+1){
            if (k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                arr[i] = arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }


}
