public class linkedlist {

    private ListNode head ;

    private static class ListNode{
        private int data ;
        private ListNode next;

        private ListNode (int data){
            this.data = data;
            this.next = null;
        }

    }

    public void  display(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next ;
        }
        System.out.println("null");
    }

    public  int Lengthoflist(){
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null){
            count++;
            temp = temp.next ;
        }
        return count;
    }

    public void InsertNodebeforehead( int value){
        ListNode newnode = new ListNode(value);
        newnode.next = head ;
        head = newnode;
    }

    public void InsertNodetoend(int value){
        ListNode newnode = new ListNode(value);
        if(head == null){
            newnode = head ;
            return;

        }
        ListNode temp  = head;
        while (temp.next != null ){
            temp = temp.next ;

        }
        temp.next = newnode;
    }

    public void InsertAtGivenPosition(int position , int data){
        ListNode newnode = new ListNode(data);
        if (position == 1){
            newnode.next = head;
            head = newnode;
        }
        else {
            ListNode previous = head;
            int count = 1;
            while (count < position-1){
                previous = previous.next;
                count++;

            }
            ListNode temp = previous.next;
            previous.next = newnode;

            newnode.next = temp;



        }
    }

    public  ListNode Deletefirstnode(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null ;
        return  temp;
    }

    public  ListNode DeleteLastNode(){
        if (head == null || head.next == null){
            return  head;
        }
        ListNode temp = head;
        ListNode previous = null ;
        while (temp.next != null){
            previous = temp;
            temp = temp.next;

        }
        previous.next = null;
        return temp;

    }

    public  void DeleteAtGivenPosision(int position) {
        if (position == 1) {
            head = head.next;

        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode temp = previous.next;
            previous.next = temp.next;


        }

    }

    // search a relavent data in singly linked list
    public boolean  searchdata(int searchkey){
        ListNode temp = head;
        while (temp != null){
            if(temp.data == searchkey){
                return true;

            }
            temp = temp.next;
        }
        return false;
    }

    public ListNode ReverseLinkedlist(){
        if (head == null){
            return head ;
        }
        ListNode temp = head;
        ListNode previous = null;
        ListNode next = null;
        while (temp != null){
            next = temp.next;  // store the next node
            temp.next = previous ; //reverse the link
            previous = temp; // move previous to temp
            temp = next ; // move temp to next
        }
        return previous;


    }
    public  ListNode Get_Nth_NodefromBack( int n){
        ListNode MainPointer = head ;
        ListNode Referencepointer = head;
        int count = 0;
        while (count < n){
            Referencepointer = Referencepointer.next;
            count++;   // this while loop is to set reference pointer n amount away from mainpointer
        }
        while (Referencepointer != null){
            Referencepointer = Referencepointer.next;
            MainPointer = MainPointer.next;
        }
        return MainPointer;
    }

    /// remove duplicates from SORTED LINKED LIST
    public void RemoveDuplicate(){
        ListNode temp = head ;
        while (temp != null && temp.next != null ){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    /// Add a nod to SORTED SINGLY LINKED LIST
    public ListNode AddNode(int value){
        ListNode newnode = new ListNode(value);
        ListNode temp = head;
        ListNode previous = null;
        while ( temp != null && temp.data < newnode.data){
            previous = temp;
            temp = temp.next;
        }
        previous.next =newnode;
        newnode.next = temp ;
        return head;


    }

    public void DeleteaNode(int Key){

        ListNode temp = head;
        ListNode previous = null;
        while(temp != null && temp.data != Key){
            previous = temp;
            temp = temp.next;

        }
        if(temp == null){
            return;
        }
        previous.next = temp.next;




    }

    public boolean DetectALoopInALinkedlist(){
        ListNode fastptr = head;
        ListNode slowptr = head;
        while (fastptr != null && fastptr.next != null){
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(fastptr == slowptr){
                return true;

            }

        }
        return false;
    }

    private ListNode getStartingNode(ListNode slowptr){
        ListNode temp = head;
        while (slowptr != temp){
            temp= temp.next;
            slowptr = slowptr.next;

        }
        return temp;

    }

    public ListNode GetStartingpointerOfALoopInALinkedlist(linkedlist List){
        ListNode fastptr = head;
        ListNode slowptr = head;
        while (fastptr != null && fastptr.next != null){
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(fastptr == slowptr){
                return getStartingNode(slowptr);
            }

        }
        return null;
    }
    private void removeLoop(ListNode slowptr){
        ListNode temp = head;
        while (slowptr.next != temp.next){
            temp= temp.next;
            slowptr = slowptr.next;

        }
        slowptr.next = null;

    }

    public void RemoveALoop(linkedlist List){
        ListNode fastptr = head;
        ListNode slowptr = head;
        while (fastptr != null && fastptr.next != null){
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(fastptr == slowptr){
                removeLoop(slowptr);
                return ;
            }

        }
        return;
    }





    public static void main(String[] args){
        linkedlist sll = new linkedlist();
        sll.head =  new ListNode(20);
        ListNode second = new  ListNode(21);
        ListNode third =  new ListNode(22);
        ListNode fourth =  new ListNode(28);
        ListNode fifth = new ListNode(34);
        ListNode sixth = new ListNode(78);

        /// connection

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next =sixth;
        sixth.next = third;

        //System.out.println(sll.Lengthoflist());;
        //sll.DeleteAtGivenPosision (2);
        //sll.Deletefirstnode();
        //System.out.println(sll.ReverseLinkedlist());

        //ListNode NthnodefromN = sll.Get_Nth_NodefromBack(3);
        //System.out.println(NthnodefromN.data);
        //System.out.println(sll.AddNode(26));
        //sll.DeleteaNode(22);
        //sll.display();
        //System.out.println( sll.DetectALoopInALinkedlist());
       // System.out.println(sll.GetStartingpointerOfALoopInALinkedlist(sll).data);









    }
}
