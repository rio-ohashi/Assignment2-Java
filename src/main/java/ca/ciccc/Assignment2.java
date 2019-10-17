package ca.ciccc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * This is the starter file for the Assignment 2
 *
 * @author Derrick Park
 * @version 1.0
 */
public class Assignment2 {
    public static void main(String[] args) {

        int n = 4;

    }

    /**
     * Write nested for-loops to produce the following output from the given input n.
     * @param n number to create a pattern.
     * @return pattern
     *
     * Sample Input / Output
     * numberLoops(3);
     *
     * Sample Output
     * ..1
     * .22
     * 333
     *
     */
    public String numberLoops(int n) {
        // Todo: your code goes here


        String total = "";
        for (int i=0;i<n;i++) {
            String row = "";
            for (int j=0;j<n;j++) {
                if ((i+1) + (j+1) > n) {
                    row += String.valueOf(i+1);
                } else {
                    row += ".";
                }
                if (j+1 == n) {
                    total += row;
                    if (i+1 < n) {
                        total += "\n";
                    }
                }
            }
        }
        return total;
    }


    /**
     * Given an array of integers, return true if the number of 1s is greater than the number of 7s
     * @param nums array of ints
     * @return true if the number of 1s is greater than the number of 7s
     */
    public boolean countNumbers(int[] nums) {
        // Todo: your code goes here
        long one = Arrays.stream(nums).filter(i->i==1).count();
        long seven = Arrays.stream(nums).filter(i->i==7).count();
        return one > seven ? true:false;
    }

    /**
     * Return the sum of numbers in the array, returning 0 for an empty array. Except the number 13
     * is very unlucky, so it does not count the number that comes immediately after a 13, also 13 itself
     * does not count.
     * @param nums array of numbers
     * @return the sum except for 13
     *
     * Sample Input / Output
     * sumExcept13({1, 2, 2, 1}) -> 6
     * sumExcept13({1, 2, 2, 1, 13} -> 6
     * sumExcept13({1, 2, 13, 2, 1, 13} -> 4
     */
    public int sumExcept13(int[] nums) {
        // Todo: your code goes here
        int sum = 0;
        boolean flg = false;
        if (nums.length > 0) {
            for (int i : nums) {
                if (flg) {
                    flg = false;
                } else if (i == 13) {
                    flg = true;
                } else {
                    sum += i;
                }
            }
        }
        return sum;
    }

    /**
     * Return an array that is "left shifted" by one -- so {6, 2, 5, 3} return {2, 5, 3, 6}.
     * You may modify and return the given array, or return a new array.
     * @param nums array of ints
     * @return shifted array
     *
     * Sample Input / Output
     * shiftArray({6, 2, 5, 3}) -> {2, 4, 3, 6}
     * shiftArray({2, 3}) -> {3, 2}
     * shiftArray({7}) -> {7}
     */
    public int[] shiftArray(int[] nums) {
        // Todo: your code goes here

        int[] shifted_nums = new int[nums.length];
        if (nums.length > 0) {
            for (int i=0;i<nums.length;i++) {
                if (i+1==nums.length) {
                    shifted_nums[i] = nums[0];
                } else {
                    shifted_nums[i] = nums[i+1];
                }
            }
        }
        return shifted_nums;
    }

    /**
     * Return true if the array contains three increasing adjacent numbers, otherwise false.
     * @param nums array of ints.
     * @return true if the array contains three increasing adjacent numbers, otherwise false.
     */
    public boolean tripleIncreasingOrder(int[] nums) {
        // Todo: your code goes here

        if (nums.length > 0) {
            int count = 1;
            int pre = 0;
            for (int i=0;i<nums.length;i++) {
                if (i != 0 && nums[i] == pre+1) {
                    count++;
                } else {
                    count = 1;
                }
                if (count == 3) {
                    return true;
                }
                pre = nums[i];
            }
        }
        return false;
    }

    /**
     * Return true if the array contains the same number of odds and even numbers, otherwise false.
     * @param nums array of ints.
     * @return true if the array contains the same number of odds and even numbers, otherwise false.
     */
    public boolean evenOrOdd(int[] nums){
        // Todo: your code goes here
        long count_odd = 0;
        long count_even = 0;
        count_odd = Arrays.stream(nums).filter(i->i%2==0).count();
        count_even = Arrays.stream(nums).filter(i->i%2==1).count();
        return count_odd == count_even ? true:false;
    }
}

