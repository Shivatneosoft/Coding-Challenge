/*
Given a number N. Count the number of digits in N which evenly divides N.

Note :- Evenly divides means whether N is divisible by a digit i.e. leaves a remainder 0 when divided.

Example 1:

Input:
N = 12
Output:
2
Explanation:
1, 2 both divide 12 evenly
Example 2:

Input:
N = 23
Output
0
Explanation:
2 and 3, none of them
divide 23 evenly

 */
public class EvenlyDivided {
    public static void main(String[] args) {
//        int target = 12;
        int target = 232;
        solutionUsingWhileLoop(target);
    }

    private static void solutionUsingWhileLoop(int target) {
        int inputTarget = target;
        int divider = 1, countResult = 0;
        while(inputTarget > 0){
            divider = inputTarget % 10;
            if(target % divider == 0)
                countResult++;
            inputTarget = inputTarget / 10;
        }
        System.out.println(countResult);
    }
}