import java.util.*;

public class CollectInOrder {
    public static void main(String[] args) {
//        int[] input = { 1, 2, 3, 1, 2, 1 };
        int[] input = { 5, 4, 5, 5, 3, 1, 2, 2, 4 };
        solutionUsingListReference(input);
    }

    private static void solutionUsingListReference(int[] input) {
        List<Integer> sequence = new ArrayList<>();
        int[] output = new int[input.length];
        Map<Integer,Integer> count = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            if(count.containsKey(input[i])) count.put(input[i],count.get(input[i])+1);
            else count.put(input[i],1);
        }
        int indexOfOutput = 0;
        for (Map.Entry<Integer,Integer> countElement: count.entrySet()) {
            for (int i = 0; i < countElement.getValue(); i++) {
                output[indexOfOutput] = countElement.getKey();
                indexOfOutput++;
            }
        }
        System.out.println(Arrays.toString(output));

    }
}
