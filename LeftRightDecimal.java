/*
Given an integer N and an integer D, rotate the binary representation of the integer N by D digits to the left as well as right and return the results in their decimal representation after each of the rotation.
Note: Integer N is stored using 16 bits. i.e. 12 will be stored as 0000000000001100.

Example 1:
Input:N = 28, D = 2
Output: 112 7
Explanation: 28 in Binary is: 0000000000011100
Rotating left by 2 positions, it becomes 0000000001110000 = 112 (in decimal).
Rotating right by 2 positions, it becomes 0000000000000111 = 7 (in decimal).
Example 2:
Input: N = 29, D = 2
Output:  116 16391
Explanation: 29 in Binary is: 0000000000011101
Rotating left by 2 positions, it becomes 0000000001110100 = 116 (in decimal).
Rotating right by 2 positions, it becomes 100000000000111 = 16391 (in decimal).
 */
public class LeftRightDecimal {
    public static void main(String[] args) {
        int N = 29, D = 2;
//        int N = 28, D = 2;
        solutionOne(N,D);
    }

    private static void solutionOne(int n, int d) {
        String binary = getBinary(n);
        String leftBinary = binary.substring(d) + binary.substring(0,d);
        String rightBinary = binary.substring(16-d) + binary.substring(0,16-d);
        int leftDecimalOutput = getDecimal(leftBinary);
        int rightDecimalOutput = getDecimal(rightBinary);
        System.out.println(leftDecimalOutput);
        System.out.println(rightDecimalOutput);
    }

    private static int getDecimal(String leftBinary) {
        int output = 0;
        for (int i = 15; i > 0; i--) {
            int powerOfTwo = 0;
            if(leftBinary.charAt(i) == '1') {
                powerOfTwo = 1;
                for (int j = 0; j < 15-i; j++) {
                    powerOfTwo = powerOfTwo * 2;
                }
            }
            output = output + powerOfTwo;
        }
        return output;
    }

    private static String getBinary(int n) {
        String output = "";
        while (output.length() != 16){
            output = (n%2) + output;
            n = n / 2;
        }
        return output;
    }
}
