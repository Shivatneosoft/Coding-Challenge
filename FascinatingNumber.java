/*
Given a number N. Your task is to check whether it is fascinating or not.
Fascinating Number: When a number(should contain 3 digits or more) is multiplied by 2 and 3, and when both these products are concatenated with the original number, then it results in all digits from 1 to 9 present exactly once.
Example 1:

        Input:
        N = 192
        Output: Fascinating
        Explanation: After multiplication with 2
        and 3, and concatenating with original
        number, number will become 192384576
        which contains all digits from 1 to 9.
        Example 2:

        Input:
        N = 853
        Output: Not Fascinating
        Explanation: It's not a fascinating
        number.
 */
public class FascinatingNumber {
    public static void main(String[] args) {
//        int input = 192;
        int input = 853;
        solutionUsingStringBuilder(input);
    }

    private static void solutionUsingStringBuilder(int input) {
        int doubleOfInput = input * 2;
        int tripleOfInput = input * 3;
        StringBuilder output = new StringBuilder();
        output.append(input);
        output.append(doubleOfInput);
        output.append(tripleOfInput);
        if(output.length() != 9 || !checkOutput(output)){
            System.out.println("Not Fascinating");
        }
        else
            System.out.println("Fascinating");
    }

    private static Boolean checkOutput(StringBuilder output) {
        for (int i = 1; i < 10; i++) {
            if(output.indexOf(Integer.toString(i)) == -1)
                return false;
        }
        return true;
    }
}
