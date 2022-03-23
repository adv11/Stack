package Stack;
/*
* Find previous smaller element in the array.
* Input : [2, 4, 6, 1, 3, 7, 9]
* Output : [-1, 2, 4, -1, 1, 3, 3]
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PreviousSmallerElement_to_the_left {
    public static ArrayList<Integer> PreviousSmallerElementToTheLeft(int[] A, int n){
        ArrayList<Integer> v = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=0 ; i<n ; i++){
            // There are 2 cases of failure we simply finding it
            // case 1 : stack is empty
            // case 2 : stack's top ele <= A[i]
            while(!s.isEmpty() && s.peek()>=A[i]){
                s.pop();
            }
            if(s.isEmpty()){
                v.add(-1);
            }else{
                v.add(s.peek());
            }
            s.push(A[i]);
        }
        return v;
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

            ArrayList<Integer> ans = PreviousSmallerElementToTheLeft(array, size);
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}
