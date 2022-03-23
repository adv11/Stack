package Stack;

import java.util.EmptyStackException;

public class stackByLinkedList {
    private ListNode top;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
        }
    }
    // constructor for initializing stack
    private stackByLinkedList(){
        top = null;
        length = 0;
    }
    // for getting length of the stack
    public int getLength(){
        return length;
    }
    // for checking if the stack is empty or not
    public boolean isEmpty(){
        return length == 0;
    }
    // push/insert operation
    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }
    // pop/delete operation
    public int pop(){
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        int deletedData = top.data;
        top = top.next;
        return deletedData;
    }
    // peak operation : display top element
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        stackByLinkedList s1 = new stackByLinkedList();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);

        System.out.println("Top element is : " + s1.peek());
    }
}
