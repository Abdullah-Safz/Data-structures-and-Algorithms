public class Stack {

    private ListNode top;
    private int Length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }
    public Stack(){
        top = null;
        Length = 0;
    }

    public boolean isEmpty(){
        return Length == 0;
    }



    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        Length++;
    }

    public int pop(){
        int result = top.data;
        top = top.next;
        Length--;
        return result;

    }

    public int peek(){
        return top.data;
    }

    public static void main(String[] args){
        Stack stk = new Stack();
        stk.push(10);
        stk.push(15);
        stk.push(34);
        System.out.println(stk.pop());
        System.out.println(stk.peek());
    }


}
