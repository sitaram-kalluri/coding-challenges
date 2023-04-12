package src.twoPointer;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfThreeNumbers {

    static int[] nums = new int[]{1, -1, 0};
    static int target = -1;

    public static void main(String[] args) {
        System.out.println(findSumOfThree(nums, target));
    }

    public static boolean findSumOfThree(int[] nums, int target) {
        // Sort the numbers in ascending order
        IntStream intStream = Arrays.stream(nums).sorted();
        int[] sortedArray = intStream.toArray();
        // Iterate through the array.
        // If sum of three numbers equals the target value, return true ; else return false
        for (int i = 1; i < sortedArray.length; i++) {
            // Set the low pointer to left most and high pointer to right most.
            int low = 0, high = sortedArray.length - 1;
            // If low and high intersect, it means the whole array is traversed with
            // the current index of the array. Move to next element and reset the
            // low and high pointer.
            while (low < high) {
                // Duplicates are not allowed. So, if both numbers are equal, move to next
                // element.
                if (sortedArray[i] == sortedArray[low]) {
                    low = low + 1;
                    continue;
                }
                // Duplicates are not allowed. So, if both numbers are equal, move to next
                // element.
                if (sortedArray[i] == sortedArray[high]) {
                    high = high - 1;
                    continue;
                }
                int sumOfThreeNumbers = sortedArray[low] + sortedArray[high] + sortedArray[i];
                if (sumOfThreeNumbers < target) {
                    low = low + 1;
                }
                if (sumOfThreeNumbers > target) {
                    high = high - 1;
                }
                if (sumOfThreeNumbers == target) {
                    System.out.println("The numbers are :" + sortedArray[i] + " " + sortedArray[low] + " " + sortedArray[high]);
                    return true;
                }
            }
        }
        return false;
    }
}
