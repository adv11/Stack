package Stack;

import java.util.EmptyStackException;

public class stackByArray {
    // Taking fixed size array for implementing the stack
    int[] stack = new int[10];
    public int top; // for accessing the top element and pushing the elements into the stack
    public int length;  // for getting the length of the stack

    // constructor for initialization
    public stackByArray(){
        top = -1;
        length = 0;
    }
    // method for getting the length of the stack
    public int getLength(){
        return length;
    }
    // method for checking is the stack is empty or not
    public boolean isEmpty(){
        return length == 0;
    }
    // method for pushing the element in to the stack
    public void push(int data){
        if(top == 10){
            throw new StackOverflowError();
        }else{
            stack[++top] = data;
            length++;
        }
    }
    // method for popping the elements from the stack
    public int pop(){
        int poppedElement = -1;
        if(top == -1)
            throw new EmptyStackException();
        else{
            poppedElement = stack[top];
            top--;
            length--;
        }
        return poppedElement;
    }
    // method for checking the top most element in to the stack
    public int peek(){
        if(top == -1)
            throw new EmptyStackException();
        else
            return stack[top];
    }
    public static void main(String[] args) {
        stackByArray s1 = new stackByArray();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);

        System.out.println("Top element is : " + s1.peek());
        System.out.println(s1.pop());
        System.out.println("Top element is : " + s1.peek());
        System.out.println("Length of the stack is : " + s1.getLength());
    }
}
