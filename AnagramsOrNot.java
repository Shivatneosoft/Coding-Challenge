/*
Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other.

Note:-

If the strings are anagrams you have to return True or else return False

|s| represents the length of string s.


Example 1:

Input:a = geeksforgeeks, b = forgeeksgeeks
Output: YES
Explanation: Both the string have same characters with
        same frequency. So, both are anagrams.
Example 2:

Input:a = allergy, b = allergic
Output: NO
Explanation: Characters in both the strings are
        not same, so they are not anagrams.
 */
public class AnagramsOrNot {
    public static void main(String[] args) {
//        String input1 = "geeksforgeeks", input2 = "forgeeksgeeks";
        String input1 = "allergy", input2 = "allergic";
        solutionOne(input1,input2);
    }

    private static void solutionOne(String input1, String input2) {
        StringBuilder check = new StringBuilder(input2);
        for (int i = 0; i < input1.length(); i++) {
            int index = check.indexOf(input1.substring(i,i+1));
            if(index != -1)
                check.deleteCharAt(index);
        }
        if(check.isEmpty())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
