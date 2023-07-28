import java.util.Arrays;

public class SmallestWindowSorting {
    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 7, 5, 6, 4, 8 };
//        int[] input = { 1, 3, 2, 7, 5, 6, 4, 8 };

        solutionUsingSortComparision(input);
//        solutionUsingTwoPointer(input);
    }

//    private static void solutionUsingTwoPointer(int[] input) {
//        Integer start = null, end = input.length;
//        int firstPointer = 0, secondPointer = 1, tempPointer;
//        while (true){
//            while(input[secondPointer] < input[firstPointer]){
//                if(start == null)
//                    start = firstPointer;
//            }
//            firstPointer = secondPointer - 1;
//            secondPointer ++;
//        }
//
//    }

    private static void solutionUsingSortComparision(int[] input) {
        int[] sortedInput = Arrays.copyOfRange(input,0,input.length);
        Integer start = null, end = 0;
        Arrays.sort(sortedInput);
        for (int i = 0; i < input.length; i++) {
            if(input[i] != sortedInput[i]){
                if(start == null)
                    start = i;
                if(end != input.length)
                    end = i;
            }
        }
        System.out.println(Arrays.toString(input));
        System.out.println(start + " " + end);
    }
}
