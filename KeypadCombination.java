import java.util.ArrayList;
import java.util.List;

/*
Given a sequence of numbers between 2 and 9, print all possible combinations of words formed from the mobile keypad which has english alphabets associated with each key.
Input: [2, 3, 4]

Output:
ADG BDG CDG AEG BEG CEG AFG BFG CFG ADH BDH CDH AEH BEH CEH AFH BFH CFH ADI BDI CDI AEI BEI CEI AFI BFI CFI
 */
public class KeypadCombination {

    static String[] keypad = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) {
        int[] input = {2, 3, 4, 5};
        solutionUsingRecurrsion(input);
    }

    private static void solutionUsingRecurrsion(int[] input) {
        List output = new ArrayList<>();
        getCombination(input, 0, null, output);
        System.out.println(output);
    }

    private static void getCombination(int[] input, int target, String result, List<String> output) {
        if (target == input.length) {
            output.add(result);
            return;
        }

        String currentKeyPad = keypad[input[target]];
        for (int j = 0; j < currentKeyPad.length(); j++) {
            result = (target == 0 ? "" : result.substring(0, target)) + currentKeyPad.charAt(j);
            getCombination(input, target + 1, result, output);
        }
    }
}
