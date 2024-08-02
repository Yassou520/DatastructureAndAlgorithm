package hash;

import java.util.concurrent.SubmissionPublisher;

public class EmpList {
    private Emp head;

    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp cur=head;
        while (cur.next !=null){
            cur = cur.next;
        }
        cur.next=emp;
    }
    public void list(){
        Emp cur = head;
        while (cur!=null){
            System.out.print("id="+cur.id+" name="+cur.name);
            cur = cur.next;
            if (cur!=null){
                System.out.print("=>");
            }
        }
        System.out.println();
    }
    public Emp findById(int id){
        Emp cur = head;
        while (cur!=null){
            if (cur.id == id){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

}
