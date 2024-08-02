package queue;

import java.util.Scanner;

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("a:offer");
            System.out.println("p:pull");
            System.out.println("s:show");
            System.out.println("e:exit");
            char key = scanner.next().charAt(0);
            switch (key){
                case 'a' :
                    System.out.println("请输入一个数字");
                    int num = scanner.nextInt();
                    queue.offer(num);
                    break;
                case 'p' :
                    int res = 0;
                    try {
                        res = queue.pull();
                        System.out.println("取出的数为 "+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's' :
                    queue.show();
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    System.out.println("暂不支持");
                    break;
            }
        }
    }
}
class Queue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;
    public Queue(int maxSize){
        front = 0;
        rear = 0;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    public boolean isEmpty(){
        return front == rear;
    }
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }
    public int getSize(){
        return (rear-front+maxSize)%maxSize;
    }
    public void offer(int num){
        if (isFull()){
            System.out.println("队列已满，不能添加");
        }
        arr[rear] = num;
        rear = (rear+1)%maxSize;
    }
    public int pull() throws Exception {
        if (isEmpty()){
            throw new Exception("队列为空");
        }
        int num = arr[front];
        front = (front+1)%maxSize;
        return num;
    }
    public void show() {
        for (int i =front;i < front+getSize();i++){
            System.out.printf("arr[%d]=%d",i%maxSize,arr[i%maxSize]);
            System.out.println();
        }
    }
}
