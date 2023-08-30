/*
You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.



Example 1:

Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".
Example 2:

Input: command = "G()()()()(al)"
Output: "Gooooal"
Example 3:

Input: command = "(al)G(al)()()G"
Output: "alGalooG"
 */
public class ReplaceLetter {
    public static void main(String[] args) {
//        String command = "G()()()()(al)";
        String command = "(al)G(al)()()G";
//        soultionUsingReplaceMethod(command);
        solutionUsingForLoop(command);
    }

    private static void solutionUsingForLoop(String command) {
        int length = command.length();
        for (int i = 0; i < length; i++) {
            if((""+command.charAt(i)).equals("(")){
                if((""+command.charAt(i+1)).equals(")")){
                    command = command.substring(0,i) + "o" + command.substring(i+2);
                    length--;
                }
                else {
                    command = command.substring(0,i) + "al" + command.substring(i+4);
                    length = length -3;
                }
            }
        }
        System.out.println(command);
    }

    private static void soultionUsingReplaceMethod(String command) {
        String output = command.replaceAll("[(]+[)]", "o").replaceAll("[(]+[al]+[)]", "al");
        System.out.println(output);
    }
}
