import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
    public static void main(String[] args) {
        int target = 19;
//        int target = 23;
        solutionUsingList(target);
        solutionUsingTwoPointer(target);
    }

    private static void solutionUsingList(int target) {
        ArrayList<Integer> storedResult = new ArrayList<>();
        int number = valueForNextNumber(target);
        while (number != 1){
            number = valueForNextNumber(number);
            if(storedResult.contains(number))
                break;
            else
                storedResult.add(number);
        }
        if(number == 1)
            System.out.println("Happy Number");
        else
            System.out.println("Not Happy Number");
    }

    private static void solutionUsingTwoPointer(int target) {
        int slow = valueForNextNumber(target);
        int fast = valueForNextNumber(valueForNextNumber(target));
        while (slow != fast){
            slow = valueForNextNumber(slow);
            fast = valueForNextNumber(valueForNextNumber(fast));
        }
        if(slow == 1)
            System.out.println("Happy Number");
        else
            System.out.println("Not Happy Number");
    }

    private static int valueForNextNumber(int target) {
        int value = 0;
        while (target != 0) {
            value = value + (target % 10) * (target % 10);
            target = target / 10;
        }
        return value;
    }
}
