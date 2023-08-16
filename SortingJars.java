import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Suppose we are given n red and n blue water jugs, all of different shapes and sizes. All red jugs hold different amounts of water, as do the blue ones. Moreover, there is a blue jug for every red jug that holds the same amount of water and vice versa. The task is to efficiently group the jugs into pairs of red and blue jugs that hold the same amount of water.
Example:
Input:
red = {6, 3, 2, 8, 7};
blue = {8, 6, 7, 2, 3};

Output:

Red jugs: [2, 3, 6, 7, 8]
Blue jugs: [2, 3, 6, 7, 8]
 */
public class SortingJars {
    public static void main(String[] args) {
        int[] redJars = {6, 3, 2, 8, 7};
        int[] blueJars = {8, 6, 7, 2, 3};
        solutionUsingForLoop(redJars,blueJars);
//        solutionUsingRecurssion(redJars,blueJars);
    }

//    private static void solutionUsingRecurssion(int[] redJars, int[] blueJars) {
//        sortingOneJars(redJars);
//    }
//
//    private static int[] sortingOneJars(int[] jars) {
//        if(jars.length < 2)
//            return jars;
//        int pivitElement = 0;
//        int[] left = new int[jars.length];
//        int[] right = new int[jars.length];
//        for (int i = jars.length-1; i < 0; i--){
//            if(jars[i] != 0) {
//                pivitElement = jars[i];
//                break;
//            }
//        }
//        for (int i = 0; i < jars.length; i++) {
//            if(jars[i] == pivitElement)
//                break;
//            if(jars[i] < pivitElement)
//                left[]
//        }
//    }

    private static void solutionUsingForLoop(int[] redJars, int[] blueJars) {
        for (int i = 0; i < redJars.length; i++) {
            for (int j = i+1; j < redJars.length; j++) {
                if(redJars[i] > redJars[j])
                    redJars = swap(redJars,i,j);
            }
        }
        for (int i = 0; i < blueJars.length; i++) {
            for (int j = i+1; j < blueJars.length; j++) {
                if(blueJars[i] > blueJars[j])
                    blueJars = swap(blueJars,i,j);
            }
        }
        System.out.println(Arrays.toString(redJars));
        System.out.println(Arrays.toString(blueJars));
    }

    private static int[] swap(int[] redJars, int firstIndex, int secondIndex) {
            redJars[firstIndex] = redJars[firstIndex] + redJars[secondIndex];
            redJars[secondIndex] = redJars[firstIndex] - redJars[secondIndex];
            redJars[firstIndex] = redJars[firstIndex] - redJars[secondIndex];
        return redJars;
    }
}
