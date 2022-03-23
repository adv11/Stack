package Stack;

import java.util.*;

/*
* Given an array of integers. For each element in the array, find it's next greater element in that array.
* The next greater element is the first element towards right, which is greater than the current element.
* Example :
* Input : arr = [4, 7, 3, 4, 8, 1]
* Output : arr = [7, 8, 4, 8, -1, -1]
*/
public class NextGreaterElement_to_Right {
    public static ArrayList<Integer> NextGreaterElementToTheRight(int[] A, int n){
        ArrayList<Integer> v = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for(int i=n-1 ; i>=0 ; i--){
            // There are 2 cases of failure we simply finding it
            // case 1 : stack is empty
            // case 2 : stack's top ele <= A[i]
            while(!s.isEmpty() && s.peek()<=A[i]){
                s.pop();
            }
            // case 1 : when stack is empty
            // then add -1 to the answer list
            if(s.isEmpty()){
                v.add(-1);
            }
            // case 2 : when stack's top > A[i]
            // then add stack's top element into the answer list
            else{
                v.add(s.peek());
            }
            s.push(A[i]);   // at last add element into the stack
        }
        Collections.reverse(v);
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

            ArrayList<Integer> ans = NextGreaterElementToTheRight(array, size);
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}
