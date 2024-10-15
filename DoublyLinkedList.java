import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private  int Length;

    private class ListNode{
        private  int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;

        }


    }

    public void  Doublylinkedlist(){
        this.head = null;
        this.tail = null;
        this.Length = 0;


    }

    public boolean isEmpty(){
        return Length == 0;
    }

    public  int length(){
        return Length;
    }

    public void insertAtBegining(int Value){
        ListNode newNode = new ListNode(Value);
        if(isEmpty()){
            tail = newNode;
        }else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        Length++; //
    }

    public void InsertAtEnd(int value){
        ListNode newnode =new ListNode(value);
        if(isEmpty()){
            head = newnode;
        }
        else {

            tail.next = newnode;
            newnode.previous = tail;

        }
        tail = newnode;
        Length++;
    }

    public void DisplayForward(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void DisplayBackward(){
        if(tail == null){
            return;
        }

        ListNode temp = tail ;

        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }
        System.out.println("null");

    }

    public ListNode RemovingFirstNode(){
        if (isEmpty()){
           // throw NoSuchElementException();
        }
        ListNode temp = head;
        if (head == tail){
            tail = null;
        }else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        Length--;
        return temp;


    }

    public ListNode RemoveLastnode(){
        if(isEmpty()){
            //throw NoSuchElementException();
        }
        ListNode temp = tail;
        if(head == tail){
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        Length--;
        return temp;

    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.InsertAtEnd(22);
        dll.InsertAtEnd(34);
        dll.InsertAtEnd(45);
        dll.InsertAtEnd(56);
        /// connection

        dll.RemoveLastnode();
        dll.DisplayForward();
        //dll.DisplayBackward();
    }



}
