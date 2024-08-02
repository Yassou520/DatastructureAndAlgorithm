package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(nums);
        System.out.println(Arrays.toString(nums));

    }
    public void insertSort(int[] nums){
        int n = nums.length;
        for(int i=1;i<n;i++){
            int insertVal = nums[i];
            int insertIndex = i-1;
            while (insertIndex>=0 && insertVal<nums[insertIndex]){
                nums[insertIndex+1]= nums[insertIndex];
                insertIndex--;
            }
            nums[insertIndex+1] = insertVal;
        }
    }
}
