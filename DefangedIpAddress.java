import java.util.Arrays;
import java.util.stream.Collectors;

/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".


Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
 */
public class DefangedIpAddress {
    public static void main(String[] args) {
        String input = "1.1.1.1";
//        solutionUsingStream(input);
//        solutionUsingReplaceMethod(input);
//        solutionUsingForLoop(input);
        solutionUsingList(input);
    }

    private static void solutionUsingList(String input) {
        String[] stringArray = input.split("[.]");
        String output = Arrays.stream(stringArray).collect(Collectors.joining("[.]"));
        System.out.print(output);
    }

    private static void solutionUsingForLoop(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (("" + input.charAt(i)).equals(".")) {
                input = input.substring(0, i) + "[.]" + input.substring(i + 1);
                i = i + 2;
            }
        }
        System.out.println(input);
    }

    private static void solutionUsingReplaceMethod(String input) {
        String output = input.replaceAll("[.]", "[.]");
        System.out.println(output);
    }

    private static void solutionUsingStream(String input) {
        input.chars()
                .forEach(value -> {
                    if(value == 46)
                        System.out.print("[.]");
                    else
                        System.out.print((char)value);
                });
    }
}
