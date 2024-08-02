package sort;

import java.util.Arrays;

import tree.HeapSort;

public class SortTestClient {
    public static final  int N = 8000000;
    public static void main(String[] args) {
        int[] nums = new int[N];
        for (int i=0;i<N;i++){
            nums[i] = (int)(Math.random()*N);
        }
//        SelectSort selectSort = new SelectSort();
        long start = System.currentTimeMillis();
//        QuickSort.quickSort(nums);
//        ShellSort.shellSort(nums);
//        MergeSort.mergeSort(nums);
//        RadixSort.radixSort(nums);
        HeapSort.heapSort(nums);
        long end = System.currentTimeMillis();
        System.out.println("总共用时："+(end-start));
//        System.out.println(Arrays.toString(nums));
    }
}
