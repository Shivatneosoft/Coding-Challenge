public class MaximumProfitStock {
    public static void main(String[] args) {
//        int[] price = {1, 5, 2, 3, 7, 6, 4, 5};
        int[] price = {1, 2, 25, 75, 100, 6, 4, 5};
//        int[] price = {10, 8, 6, 5, 4, 2};
        solutionUsingMinMax(price);
    }

    private static void solutionUsingMinMax(int[] price) {
        int buy , sell , profit = 0, pointer = 0;

        while (pointer != -1){
            pointer = findIndexOfNearestMin(price, pointer);
            if(pointer == -1) break;
            buy = price[pointer];
            pointer = findIndexOfNearestMax(price, pointer);
            if(pointer == -1) break;
            sell = price[pointer];
            profit = profit + (sell - buy);
        }
        System.out.println(profit);
    }

    private static int findIndexOfNearestMax(int[] price, int pointer) {
        while(pointer < price.length-1) {
            if (price[pointer] > price[pointer + 1])
                return pointer;
            else
                pointer ++;
        }
        if(pointer == price.length-1)
            return price.length - 1;
        return -1;
    }

    private static int findIndexOfNearestMin(int[] price, int pointer) {
        while(pointer < price.length-1) {
            if (price[pointer] < price[pointer + 1])
                return pointer;
            else
                pointer ++;
        }
        return -1;
    }
}
