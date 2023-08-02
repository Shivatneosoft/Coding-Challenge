import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositiveCombinationSum {

    static List<String> positiveOutput = new ArrayList<>();

    public static void main(String[] args) {
        int target = 5;
        solutionUsingRecursion(target);
        positiveOutput.stream()
                .forEach(values-> System.out.println(values));
    }

    private static void solutionUsingRecursion(int target) {
        combination(target, new int[0]);
    }

    private static void combination(int target, int[] result) {
        int sum = Arrays.stream(result).sum();
        if(sum == target) {
            Arrays.sort(result);
            if(!contains(positiveOutput,result))
                positiveOutput.add(Arrays.toString(result));
//            System.out.println(Arrays.toString(result));
            return;
        }
        if(result.length == target)
            return;

//        int[] tempResult = new int[result.length+1];
        int[] tempResult = Arrays.copyOf(result, result.length+1);
        for (int i = 0; i < target; i++) {
            tempResult[result.length] = i+1;
            combination(target,tempResult);
        }
    }

    private static boolean contains(List<String> positiveOutput, int[] result) {
        for (String element: positiveOutput) {
            if(element.equals(Arrays.toString(result)))
                return true;
        }
        return false;
    }


}
