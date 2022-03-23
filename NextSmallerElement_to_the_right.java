package Stack;
/*
* Find next smaller element in the given array.
* Input : [2, 4, 6, 1, 3, 9, 7]
* Output : [1, 1, 1, -1, -1, 7, -1]
*/
import java.util.*;

public class NextSmallerElement_to_the_right {
    public static ArrayList<Integer> NextSmallerElementToTheRight(int[] A, int n){
        ArrayList<Integer> v = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=n-1 ; i>=0 ; i--){
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

            ArrayList<Integer> ans = NextSmallerElementToTheRight(array, size);
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}
