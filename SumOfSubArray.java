import java.util.Arrays;

public class SumOfSubArray {
    public static void main(String[] args) {
        int[] num =  {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10};
        int target = -3;

        solutionUsingTwoForLoop(num,target);
//        solutionUsingWhileLoop(num,target);
    }

    private static void solutionUsingWhileLoop(int[] num, int target) {
        int start=0, end= num.length;
        while (start < num.length -1){
            if(end < start){
                start ++;
                end = num.length;
            }
            int[] subArrays = Arrays.copyOfRange(num, start, end);
            int sum = Arrays.stream(subArrays).sum();
            if(sum == target){
                System.out.println(Arrays.toString(subArrays));
                return;
            }
            end --;
        }
    }

    private static void solutionUsingTwoForLoop(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length+1; j++) {
                int[] subArray = Arrays.copyOfRange(num, i, j);
                int sum = Arrays.stream(subArray).sum();
                if(sum == target) {
                    System.out.println(Arrays.toString(subArray));
                    return;
                }
            }
        }
    }
}
