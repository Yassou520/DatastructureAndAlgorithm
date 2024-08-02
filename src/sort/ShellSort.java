package sort;

public class ShellSort {
    public static void shellSort(int[] nums){
        int n = nums.length;
        for (int gap=n/2;gap>0;gap/=2){
            for (int i=gap;i<n;i++){
                int j=i;
                int temp=nums[j];
                if (nums[j]<nums[j-gap]){
                    while (j-gap>=0 && temp<nums[j-gap]){
                        nums[j] = nums[j-gap];
                        j-=gap;
                    }
                    nums[j] = temp;
                }
            }
        }
    }
}
