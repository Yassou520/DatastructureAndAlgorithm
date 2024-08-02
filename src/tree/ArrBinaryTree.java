package tree;

/**
 * 顺序存储二叉树
 * 第n个元素的左子节点为2*n+1
 * 第n个元素的右子节点为2*n+2
 * 第n个元素的父节点为(n-1)/2
 */
public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }
    public void preOrder(){
        preOrder(0);
    }
    private void preOrder(int no){
        if (arr == null || arr.length == 0 || no>arr.length-1){
            return;
        }
        System.out.println(arr[no]);
        preOrder(no*2+1);
        preOrder(no*2+2);
    }
}
