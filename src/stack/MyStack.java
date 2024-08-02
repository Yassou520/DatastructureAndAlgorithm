package stack;


public class MyStack<T> {
    private Object[] arr;
    private int top;
    int maxSize;
    public MyStack(int size){
        top = -1;
        maxSize = size;
        arr = new Object[maxSize];
    }
    public void push(T ele){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        arr[top] = ele;
    }
    public T pop() throws Exception {
        if (isEmpty()){
            throw new Exception("栈为空");
        }
        return (T) arr[top--];
    }
    public T peek() throws Exception {
        if (isEmpty()){
            throw new Exception("栈为空");
        }
        return (T) arr[top];
    }
    public boolean isFull(){
        return top == maxSize-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }


}
