public class CircularSinglyLinkedList {

    private ListNode last;
    private int Length;

    private  class ListNode{

        private ListNode next;
        private int data;

        public ListNode(int data){ // It allows creating a new ListNode object and initializing its data.
            this.data = data;
        }

    }

    public void Circularsinglylinkedlist(){
        this.last = null;
        this.Length = 0;

    }

    public int Length(){
        return Length ;
    }

    public boolean isEmpty(){
        return Length == 0;
    }

    public void CreateCircularsll(){
        ListNode first = new ListNode(21);
        ListNode second = new ListNode(111);
        ListNode third =  new ListNode(22);
        ListNode fourth =  new ListNode(28);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        last = fourth;
    }

    public void Displaycll(){
        if(last == null){
            return;
        }
        ListNode first = last.next;
        while (first != last){
            System.out.print(first.data + " ");
            first = first.next;

        }
        System.out.print(first.data + " ");
    }

    public void AddNodeFirst(int value){
        ListNode newnode = new ListNode(value);

        if (last == null){
            last = newnode;
        }else {
            newnode.next = last.next;
        }
        last.next = newnode;
        Length++;


    }

    public void AddNodeLast(int value){
        ListNode newnode = new ListNode(value);
        if(last == null){
            last = newnode;
            last.next = last;
        }else {
            newnode.next = last.next;
            last.next = newnode;
            last = newnode;
        }

        Length++;
    }

    public static void main(String[] args){
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.CreateCircularsll();
        csll.AddNodeLast(65);
        csll.Displaycll();

    }
}
