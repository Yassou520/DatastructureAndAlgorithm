package search;

public class BinarySearch {
    public static void main(String[] args) {
    }
    public static int binarySearch(int[] arr,int left,int right,int target){
        if(left > right){
            return -1;
        }
        System.out.println("------");
        int mid = (left+right)/2;
        if (target>arr[mid]){
            return binarySearch(arr,mid+1,right,target);
        }else if (target<arr[mid]){
            return binarySearch(arr,left,mid-1,target);
        }else {
            return mid;
        }
    }
}
