package Stack;

import java.util.Scanner;
import java.util.Stack;

// In this problem we have given a string containing different type of brackets, and we have to check if the given string is balanced or not.
// Example :
// 1) "[({})]"  -> Balanced
// 2) "[(])"  -> Not Balanced
public class BalancingParenthesisProblem {
    public static boolean isBalanced(String string){
        Stack<Character> stack = new Stack<>();
        for(char c : string.toCharArray()){
            if(stack.isEmpty())
                stack.push(c);
            else if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else if(c == ')' && stack.peek() == '('){
                stack.pop();
            }else if(c == '}' && stack.peek() == '{'){
                stack.pop();
            }else if(c == ']' && stack.peek() == '['){
                stack.pop();
            }else{
                break;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter testcases:");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter the string:");
            String string = sc.next();
            boolean flag = isBalanced(string);
            if (flag)
                System.out.println("Balanced");
            else
                System.out.println("Not Balanced");
        }
    }
}
