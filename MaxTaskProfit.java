/*
Given a list of tasks with deadlines and total profit earned on completing a task, find the maximum profit earned by executing the tasks within the specified deadlines. Assume that each task takes one unit of time to complete, and a task can’t execute beyond its deadline. Also, only a single task will be executed at a time.

For example, consider the following set of tasks with a deadline and the profit associated with it. If we choose tasks 1, 3, 4, 5, 6, 7, 8, and 9, we can achieve a maximum profit of 109. Note that task 2 and task 10 are left out.
Tasks	Deadlines	Profit
1	    9	        15
2	    2	        2
3	    5	        18
4	    7	        1
5	    4	        25
6	    2	        20
7	    5	        8
8	    7	        10
9	    4	        12
10	    3	        5
 */

import java.util.Arrays;

public class MaxTaskProfit {
    public static void main(String[] args) {
        int[] inputTask = {9,2,5,7,4,2,5,7,4,3};
        int[] inputDeadLine = {15,2,18,1,25,20,8,10,12,5};
        solutionUsing(inputTask,inputDeadLine);
    }

    private static void solutionUsing(int[] inputTask, int[] inputDeadLine) {
        int[] sortedDeadLine = Arrays.copyOf(inputDeadLine,inputDeadLine.length);
        Arrays.sort(sortedDeadLine);
        int[] output = new int[Arrays.stream(inputTask).max().getAsInt()];
//        System.out.println(Arrays.toString(inputDeadLine));
//        System.out.println(Arrays.toString(sortedDeadLine));
        for (int i = sortedDeadLine.length-1; i >= 0; i--) {
            int indexOfElementInInputDeadLine = indexOf(inputDeadLine, sortedDeadLine[i]);
            output = addElementInOutput(output, indexOfElementInInputDeadLine, inputTask[indexOfElementInInputDeadLine]);
        }
//        System.out.println(Arrays.toString(output));
        int totalProfit = findSum(output, inputTask, inputDeadLine);
        System.out.println(totalProfit);
    }

    private static int findSum(int[] output, int[] inputTask, int[] inputDeadLine) {
        int sum = 0;
        for (int i = 0; i < output.length; i++) {
            if(output[i] != 0) {
                sum = sum + inputDeadLine[indexOf(inputTask, output[i])];
            }
        }
        return sum;
    }

    private static int[] addElementInOutput(int[] output, int index, int valueToAdd) {
        while(true){
            if(index < 0)
                break;
            if(index < output.length-1 && output[index] == 0) {
                output[index] = valueToAdd;
                break;
            }
            index--;
        }
        return output;
    }

    private static int indexOf(int[] inputArray, int target) {
        for (int j = 0; j < inputArray.length; j++) {
            if(inputArray[j] == target)
                return j;
        }
        return -1;
    }
}
