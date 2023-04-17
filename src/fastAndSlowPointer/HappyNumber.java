package src.fastAndSlowPointer;

class HappyNumber {

    public static void main(String[] args) {

        System.out.println(isHappyNumber(23));

    }

    static int sumOfSquares(int number) {
        int totalSum = 0;
        while (number != 0) {
            // For a given number extract the last digit.
            int lastDigit = number % 10;
            // Divide with 10 to get the remaining number, except the last digit.
            number = number / 10;
            // Square the last digit and add it to the totalSum
            totalSum += Math.pow(lastDigit, 2);
        }
        return totalSum;
    }

    static boolean isHappyNumber(int number) {
        int slow = number;
        int fast = sumOfSquares(number);

        while (fast != 1 && fast != slow) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast == 1;
    }

}