import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 */
public class ReverseWord {
    public static void main(String[] args) {
//        String input = "Let's take LeetCode contest";
//        String input = "Let's";
//        String input = " ";
        String input = null;
        solutionUsingStream(input);
//        solutionUsingTwoForLoop(input);
    }

    private static void solutionUsingTwoForLoop(String input) {
        String output = input != null ? Arrays.stream(input.split(" ")).map(
                word -> swap(word.getBytes())
        ).collect(Collectors.joining(" ")) : null;
        System.out.println(output);
    }

    private static String swap(byte[] bytes) {
        int length = bytes.length-1;
        if(length > 0){
            for (int i = 0; i < (length / 2) +1; i++) {
                if( i != length-i){
                    bytes[i] = (byte) (bytes[i] + bytes[length-i]);
                    bytes[length-i] = (byte) (bytes[i] - bytes[length-i]);
                    bytes[i] = (byte) (bytes[i] - bytes[length-i]);
                }
            }
        }
        return (new String(bytes, StandardCharsets.UTF_8));
    }

    private static void solutionUsingStream(String input) {
        String output = input != null ? Arrays.stream(input.split(" "))
                .map(word -> Arrays.stream(word.split(""))
                        .reduce((a, b) -> b + a).get())
                .collect(Collectors.joining(" ")) : null;
        System.out.println(output);
    }
}
