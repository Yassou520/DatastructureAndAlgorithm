package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int n = 1000000;
    }
    public void selectSort(int[] nums){
        int n = nums.length;
        for(int i=0;i < n-1;i++){
            int min = nums[i];
            int minIndex = i;
            for (int j=i+1;j<n;j++){
                if (nums[j] < min){
                    minIndex=j;
                    min = nums[j];
                }
            }
            if (minIndex!=i){
                nums[minIndex] = nums[i];
                nums[i] = min;
            }

        }
    }
}
