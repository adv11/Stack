package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Stock_Span_Problem_Leetcode901_Medium {
    public static ArrayList<Integer> NextGreaterElementToTheLeft(int[] a, int n){
        // this will contain all the indexes of the greater elements of the current element
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        // Because we have to find the left greater element so, traverse the array from left side
        for(int i=0 ; i<n ; i++){
            // if the stack is not empty and peek ele <= A[i] then simply pop it
            while(!s.isEmpty() && a[s.peek()]<=a[i]){
                s.pop();
            }
            if(s.isEmpty()){    // if stack is empty then add -1
                index.add(-1);
            }else{
                index.add(s.peek());    // else add the index of the previous greater element
            }
            s.push(i);  // at last add the index of the current element
        }

        // now perform this operation to get the desired answer array
        for(int i=0 ; i<n ; i++){
            ans.add(i - index.get(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            System.out.println("Enter the length of the array:");
            int size = sc.nextInt();
            System.out.println("Enter the elements of the array:");
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
            }
            ArrayList<Integer> answerArray = NextGreaterElementToTheLeft(array, size);
            System.out.println(Arrays.toString(answerArray.toArray()));
        }
    }
}
