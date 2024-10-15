import java.util.*;
import java.util.Stack;

public class StackUsingArray {

    private int top;
    private int[] arr;

    public StackUsingArray(int capacity){
        top = -1;
        arr = new int[capacity];
    }

    public StackUsingArray(){ // defalt capacity as 10
        this(10);
    }

    public void push(int data){
       if(isFull()){
           throw new RuntimeException("Stack is full!!!");

       }
        top++;
        arr[top]= data;
    }
    public boolean isFull(){
        return arr.length == size();
    }
    public int size(){
        return top + 1;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty!!!");
        }
        int result=  arr[top];
        top--;
        return result;

    }
    public boolean isEmpty(){
        return top < 0;
    }


    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty !!!");
        }
        return arr[top];
    }

    //// reverse a string using stack

    public String Stringreverse(String str){
        Stack<Character> stack = new Stack<>();
        char[] Char = str.toCharArray();

        for (char c : Char){
            stack.push(c);
        }

        for(int i =0 ; i < str.length() ; i++){
            Char[i] = stack.pop();


        }
        return new String(Char);
    }

    public static void main(String[] args){
        StackUsingArray stua = new StackUsingArray();
        System.out.println(stua.Stringreverse("Abdullah"));
    }




}
