import java.util.ArrayList;
import java.util.List;

public class ClosestPair {
    public static void main(String[] args) {
        int[] first =  { 10, 12, 15, 18, 20 };
        int[] second = { 1, 4, 6, 8 };
        int target = 29;
        System.out.println(solutionUsingThreeLoops(first, second, target));
    }

    private static List<Integer> solutionUsingThreeLoops(int[] first, int[] second, int target) {

        while (true){
            for (int i = 0; i < first.length; i++)
                for (int j = 0; j < second.length; j++)
                    if (first[i] + second[j] == target)
                        return List.of(first[i], second[j]);
            target --;
        }
    }
}
