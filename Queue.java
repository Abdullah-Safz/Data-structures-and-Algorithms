import java.rmi.NotBoundException;
import java.util.List;

public class Queue {

    private ListNode front;
    private ListNode rear;

    private int Length;

    private class ListNode{


        private ListNode next;
        private int data;


        private ListNode(int data){
            this.data = data;

        }

    }

    public int Length(){
        return Length;
    }

    public boolean isEmpty(){
        return Length == 0;
    }

    public void Enqueue(int data){
        ListNode newnode = new ListNode(data);
        if(isEmpty()){
            front = newnode;
        }else {
            rear.next = newnode;

        }
        rear = newnode;
        Length++;


    }

    public int Deqeue(){
        if(isEmpty()){
            throw new NotBoundException();
        }
        int result = front.data;
        front = front.next;
        if(front == null){
            rear = null;

        }
        Length--;
        return result;

    }

    public int first(){
        if(isEmpty()){
            throw new NotBoundException();
        }
        return front.data;

    }

    public int last(){
        if(isEmpty()){
            throw new NotBoundException();
        }
        return rear.data;

    }

    public  void Display(){
        if(isEmpty()){
            return;
        }
        ListNode temp = front ;
        while (temp != null){
            System.out.print(temp + "-->");
            temp = temp.next;
        }
        System.out.print("null");
    }


    public static void main(String[] args){
        Queue q = new Queue();
        q.Enqueue(23);
        q.Enqueue(34);
        q.Enqueue(234);
        q.Display();
    }


}
