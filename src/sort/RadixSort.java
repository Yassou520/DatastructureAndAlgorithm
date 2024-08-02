package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void radixSort(int[] arr){
        int n = arr.length;
        int[][] bucket = new int[10][n];
        int[] bucketSize = new int[10];
        int max = arr[0];
        for (int i=1;i<n;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        int maxLen = (max+"").length();
        int bucketIndex;
        for (int i=0,f=1;i<maxLen;i++,f*=10){
            for (int j=0;j<n;j++){
                bucketIndex=arr[j]/f%10;
                bucket[bucketIndex][bucketSize[bucketIndex]++]=arr[j];
            }
            int index=0;
            for (int t=0;t<10;t++){
                if (bucketSize[t]>0){
                    for (int k=0;k<bucketSize[t];k++){
                        arr[index++]=bucket[t][k];
                    }
                }
                bucketSize[t]=0;
            }
        }
    }
}
