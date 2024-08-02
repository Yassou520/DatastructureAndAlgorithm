package hash;

import java.util.List;

public class HashTab {
    private EmpList[] empLists;
    private int size;
    public HashTab(int size){
        this.size = size;
        empLists = new EmpList[size];
        for (int i=0;i<size;i++){
            empLists[i] = new EmpList();
        }
    }
    public void add(Emp emp){
        int index = hashFun(emp.id);
        empLists[index].add(emp);
    }
    public Emp findById(int id){
        int index = hashFun(id);
        return empLists[index].findById(id);
    }
    public void list(){
        for (int i=0;i<size;i++){
            System.out.print("第"+(i+1)+"条链表 ");
            empLists[i].list();
        }
    }
    public int hashFun(int id){
        return id % size;
    }
}
