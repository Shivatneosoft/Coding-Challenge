import java.util.Arrays;

/*
Lucky numbers are subset of integers. Rather than going into much theory, let us see the process of arriving at lucky numbers,
Take the set of integers
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,……
First, delete every second number, we get following reduced set.
1, 3, 5, 7, 9, 11, 13, 15, 17, 19,…………
Now, delete every third number, we get
1, 3, 7, 9, 13, 15, 19,….….
Continue this process indefinitely……
Any number that does NOT get deleted due to above process is called “lucky”.

You are given a number N, you need to tell whether the number is lucky or not. If the number is lucky return 1 otherwise 0.

Example 1:

Input:
N = 5
Output: 0
Explanation: 5 is not a lucky number
as it gets deleted in the second
iteration.
Example 2:

Input:
N = 19
Output: 1
Explanation: 19 is a lucky number because
it does not get deleted throughout the process.
 */
public class LuckyNumber {
    public static void main(String[] args) {
        int target = 50;
//        int target = 19;
        solutionUsingForLoop(target);
    }

    private static void solutionUsingForLoop(int target) {
        int[] elements = new int[target];
        for (int i = 0; i < target; i++) {
            elements[i] = i +1;
        }
//        System.out.println(Arrays.toString(elements));

        int[] tempElement;
        for (int i = 2; elements.length >= i && indexOf(elements,target); i++) {
            tempElement = new int[(elements.length/i)*(i-1) + elements.length%i];
            int indexForAddingElement = 0;
            for (int j = 0; j < elements.length; j++) {
                if(j % i != i - 1){
                    tempElement[indexForAddingElement] = elements[j];
                    indexForAddingElement++;
                }
            }
            elements = tempElement;
//            System.out.println(Arrays.toString(elements));
        }

        if(indexOf(elements,target))
            System.out.println(target + " is a lucky number");
        else
            System.out.println(target + " is not a lucky number");
    }

    private static boolean indexOf(int[] elements, int target) {
        for (int i = 0; i < elements.length; i++)
            if(elements[i] == target)
                return true;
        return false;
    }
}
