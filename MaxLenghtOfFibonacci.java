import javax.sql.rowset.FilteredRowSet;
import java.util.Arrays;

public class MaxLenghtOfFibonacci{
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
//        int arr[] = {1,3,7,11,12,14,18};
        solutionUsingForLoop(arr);
    }

    private static void solutionUsingForLoop(int[] arr) {
        int maxLenght = 0;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                if((arr[i] + arr [j]) > arr[arr.length-1]){
                    break;
                }
                int indexOfNextElement = indexOf(arr, arr[i] + arr[j], j+1);
                if (indexOfNextElement != -1){
                    System.out.print( "[ " + arr[i] + ", " + arr[j]);
                    int moreLenght = findMoreLenght(arr[j], indexOfNextElement, arr, 3);
                    maxLenght = maxLenght < moreLenght ? moreLenght : maxLenght;
                    System.out.println(" ]");
                };

            }
        }
        System.out.println(maxLenght);
    }

    private static int findMoreLenght(int second, int indexOfThirdElement, int[] remainingElements, int maxlenght) {
        System.out.print( ", " + remainingElements[indexOfThirdElement] );
            int indexOfNextElement = indexOf(remainingElements, second + remainingElements[indexOfThirdElement], indexOfThirdElement + 1);
            if (!(indexOfNextElement != -1))
                return maxlenght;
            return findMoreLenght(remainingElements[indexOfThirdElement],indexOfNextElement,remainingElements,++maxlenght);
    }

    private static int indexOf(int[] arr, int target, int start) {
        int end = arr.length -1;
        while (start < end){
            int mid = start + ((end-start)/2);
            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target)
                end = mid;
            else
                start = mid;
        }
        return -1;
    }
}
