import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/*
Check if the sentence is pangram.
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false
 */
public class Pangram {
    public static void main(String[] args) {
//        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        String sentence = "leetcode";
//        solutionUsingForLoop(sentence.toLowerCase());
        solutionUsingSet(sentence.toLowerCase());
    }

    private static void solutionUsingSet(String sentence) {
        Set<Integer> collect = sentence.chars().boxed().collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static void solutionUsingForLoop(String sentence) {
        int length = sentence.length();
        if(length < 26) {
            System.out.println("False");
            return;
        }
        boolean flag = true;
        for (int i = 97; i < 123; i++) {
            if(!sentence.contains(""+(char)i)){
                flag = false;
            }
        }
        System.out.println(flag);
    }
}
