package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
    public void bubbleSort(int[] nums){
        int t;
        for (int i=0;i<nums.length-1;i++){
            for (int j=0;j<nums.length-i-1;j++){
                if (nums[j]>nums[j+1]){
                    t=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=t;
                }
            }
        }
    }
}
