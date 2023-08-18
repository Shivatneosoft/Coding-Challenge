import java.util.List;

/*
Given two circles C1 of radius R1 and C2 of radius R2,centered at (X1,Y1) and (X2,Y2) respectively.Find out whether they touch(at one or more than one points).

Example 1:

Input:
X1=3
Y1=4
R1=5
X2=14
Y2=18
R2=8
Output:
0
Explanation:
The circles centred at (3,4) and (14,18)
and having radii 5 and 8 respectively
do not touch each other.
Example 2:

Input:
X1=3
Y1=4
R1=5
X2=14
Y2=18
R2=18
Output:
1
Explanation:
The circles centred at (3,4) and (14,18)
and having radii 5 and 18 respectively
touch each other at two points.
 */
public class TouchingCircle {

    public static void main(String[] args) {
        int X1=2,Y1=3,R1=3,X2=1,Y2=-1,R2=4;
//        int X1=3,Y1=4,R1=5,X2=14,Y2=18,R2=18;
        solutionOne(X1,Y1,R1,X2,Y2,R2);
    }

    private static void solutionOne(int x1, int y1, int r1, int x2, int y2, int r2) {

        Double distance = findingDistanceBetweenPoints(x1, y1, x2, y2);
        int totalRadiusDistance = r1 + r2;
        if(distance < totalRadiusDistance) {
            List<Integer> expression1 = createExpression(x1, y1, r1);
            List<Integer> expression2 = createExpression(x2, y2, r2);
            List<Double> valueForX = findingValueForX(expression1, expression2);
            List<Double> valueForY = findingValueForY(expression1, valueForX);
            List<Double> finalYValue = cordinate(valueForY);
            List<Double> valueForXCordinate = numberValueForx(valueForX, finalYValue);
            System.out.println("Cordinate Are");
            System.out.print("("+ valueForXCordinate.get(0) + "," + finalYValue.get(0) + ") and ");
            System.out.println("("+ valueForXCordinate.get(1) + "," + finalYValue.get(1) + ")");

        }
        else if (distance == totalRadiusDistance){
            double x3 = x1 +(r1*(Math.abs(x1-x2)))/distance;
            double y3 = y1 +(r1*(Math.abs(y1-y2)))/distance;
            System.out.println(x3);
            System.out.println(y3);
        }
        else
            System.out.println("0");

    }

    private static List<Double> numberValueForx(List<Double> valueForX, List<Double> finalYValue) {
        double valueOne = -1 *(valueForX.get(1) * finalYValue.get(0) + valueForX.get(2))/ valueForX.get(0);
        double valueTwo = -1 * (valueForX.get(1) * finalYValue.get(1) + valueForX.get(2))/ valueForX.get(0);
        return List.of(valueOne,valueTwo);
    }


    private static List<Double> cordinate(List<Double> valueForY) {
        double sqrt = Math.sqrt((valueForY.get(1) * valueForY.get(1)) - (4 * (valueForY.get(0) * valueForY.get(2))));
        double valueOne = ((-1 * valueForY.get(1)) + (sqrt))/(2 * valueForY.get(0));
        double valueTwo = ((-1 * valueForY.get(1)) - (sqrt))/(2 * valueForY.get(0));
        return List.of(valueOne,valueTwo);
    }

    private static List<Double> findingValueForY(List<Integer> expression1, List<Double> valueForX) {
        double constantFromX = valueForX.get(2) / valueForX.get(0);
        double constantForX = (constantFromX * constantFromX) + (expression1.get(1) * constantFromX) - expression1.get(4);
        double yFromX = valueForX.get(1) / valueForX.get(0);
        double ySqrForX = (yFromX * yFromX) + expression1.get(2);
        double yForX = (yFromX * expression1.get(1)) + 2 * ( constantFromX * yFromX ) - expression1.get(3);
        return List.of(ySqrForX,yForX,constantForX);
    }

    private static List<Double> findingValueForX(List<Integer> expressionA, List<Integer> expressionB) {
        int x = expressionB.get(1) - expressionA.get(1);
        int y = expressionB.get(3) - expressionA.get(3);
        int constant = expressionB.get(4) - expressionA.get(4);
        return List.of(Double.valueOf(x),Double.valueOf(y),Double.valueOf(constant));
    }


    private static List<Integer> createExpression(int x, int y, int r) {
        return List.of(1,(2*x),1,(2*y),(r*r) - ((x*x) + (y*y)));
    }

    private static Double findingDistanceBetweenPoints(int x1, int y1, int x2, int y2) {
        int xPoint = x2-x1;
        int yPoint = y2-y1;
        xPoint = xPoint * xPoint;
        yPoint = yPoint * yPoint;
        int sum = xPoint + yPoint;
        return Math.sqrt(sum);
    }

}
