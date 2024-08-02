package search;

public class InsertValueSearch {
    public static int insertValueSearch(int[] arr,int left,int right,int target) {
        if (left>right || target<arr[0] || target>arr[arr.length-1]){
            return -1;
        }
        System.out.println("-----");
        int mid = left+(target-arr[left])/(arr[right]-arr[left])*(right-left);
        if (target>arr[mid]){
            return insertValueSearch(arr,mid+1,right,target);
        }else if (target < arr[mid]){
            return insertValueSearch(arr,left,mid-1,target);
        }else {
            return mid;
        }
    }
}
