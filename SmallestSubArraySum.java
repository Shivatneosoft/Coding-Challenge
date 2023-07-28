import java.util.Arrays;

public class SmallestSubArraySum {
    public static void main(String[] args) {
        int[] input =  {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 40;

        solutionUsingOneForLoop(input,target);
    }

    private static void solutionUsingOneForLoop(int[] input, int target) {
        int end = input.length;
        for (int i = input.length-1 ; i > 0; i--) {
            int[] subArray = Arrays.copyOfRange(input, i, end);
            int sum = Arrays.stream(subArray).sum();
            if(sum > target) {
                System.out.println(subArray.length);
                return;
            }
        }
        System.out.println("No subarray exists");
    }
}
