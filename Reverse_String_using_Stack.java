package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Reverse_String_using_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string:");
        String string = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        for(char c : string.toCharArray()){
            stack.push(c);
        }

        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()){
            reversedString.append(stack.pop());
        }
        System.out.println(reversedString);
    }
}
