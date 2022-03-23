package Stack;
/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.

*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class MaximumAreaHistogram {
    // Method for finding the smallest element's index to the left
    public static ArrayList<Integer> previousSmallerElementToTheLeft(int[] heights, int sizeOfArray){
        ArrayList<Integer> nsel = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<sizeOfArray ; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){    // if stack is empty add -1 into nsel array
                nsel.add(-1);
            }else{
                nsel.add(stack.peek());
            }
            stack.push(i);
        }
        return nsel;
    }
    // Method for finding the smallest element's index to the right
    public static ArrayList<Integer> nextSmallerElementToTheRight(int[] heights, int sizeOfArray){
        ArrayList<Integer> nser = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=sizeOfArray-1 ; i>=0 ; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nser.add(sizeOfArray);  // if the stack is empty then push n(size of array) into the nser array
            }else{
                nser.add(stack.peek());
            }
            stack.push(i);
        }
        Collections.reverse(nser);  // reverse the array
        return nser;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            System.out.println("Enter the length of the array:");
            int sizeOfArray = sc.nextInt();
            System.out.println("Enter the elements of the array:");
            int[] heights = new int[sizeOfArray];
            for (int i = 0; i < sizeOfArray; i++) {
                heights[i] = sc.nextInt();
            }

            ArrayList<Integer> nsel = previousSmallerElementToTheLeft(heights, sizeOfArray);
            ArrayList<Integer> nser = nextSmallerElementToTheRight(heights, sizeOfArray);
            // finding maximum area
            int maxArea = Integer.MIN_VALUE;
            for(int i=0 ; i<sizeOfArray ; i++){
                // formula for finding the max area
                int tempResult = heights[i] * (nser.get(i) - nsel.get(i) - 1);
                if(tempResult > maxArea){
                    maxArea = tempResult;
                }
            }
            System.out.println("Max Area Histogram is : " + maxArea);
        }
    }
}
