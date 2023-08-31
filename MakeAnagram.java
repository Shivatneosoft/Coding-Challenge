import java.util.Arrays;

/*
Given two strings S1 and S2 in lowercase, the task is to make them anagram. The only allowed operation is to remove a character from any string. Find the minimum number of characters to be deleted to make both the strings anagram. Two strings are called anagram of each other if one of them can be converted into another by rearranging its letters.

Example 1:

Input:
S1 = bcadeh
S2 = hea
Output: 3
Explanation: We need to remove b, c
and d from S1.
Example 2:

Input:
S1 = cddgk
S2 = gcd
Output: 2
Explanation: We need to remove d and
k from S1.
 */
public class MakeAnagram {
    public static void main(String[] args) {
        String S1 = "bcadeh",
                S2 = "hea";
        solutionUsingSeperatePointer(S1, S2);
//        solutionUsingPointerOfOneString(S1,S2);
    }

    private static void solutionUsingPointerOfOneString(String s1, String s2) {
        int outputCounter = 0;
        char[] array = (s1+s2).toCharArray();
        Arrays.sort(array);
        String sortedArray = new String(array);
        int length = sortedArray.length();
        for (int i = 0; i < length - 1; i++) {
            if(sortedArray.charAt(i) != sortedArray.charAt(i+1)) {
                outputCounter++;
                i++;
            }
        }
        System.out.println(outputCounter);
    }

    private static void solutionUsingSeperatePointer(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        String sortedS1 = new String(s1Array);
        String sortedS2 = new String(s2Array);
        int output = 0;
        int firstPointer = 0, secondPointer = 0;
        int length1 = sortedS1.length(), lenght2 = sortedS2.length();
        while (secondPointer != lenght2) {
            if (sortedS1.charAt(firstPointer) == sortedS2.charAt(secondPointer)) {
                if (firstPointer < length1 - 1)
                    firstPointer++;
                secondPointer++;
            } else {
                output++;
                if (firstPointer < length1-1)
                    firstPointer++;
                else
                    secondPointer++;
            }
        }
        System.out.println(output);
    }
}
