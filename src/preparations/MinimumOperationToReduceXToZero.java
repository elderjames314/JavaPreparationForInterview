package preparations;

/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1

Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 */

public class MinimumOperationToReduceXToZero {
    /*
     arr = [2, 4, 5, 3, 1, 2], x = 12
     total array = 17 -12 == 5
     right == 6
     left == 3
     sum = 4
     mex = 3
     minumum = 6- 3 = 3
     */
    public static void main(String[] args) {

        int[] arr = {2, 4, 5, 3, 1, 2};
        System.out.println(getMinimumOperation(arr, 12));


    }

    public static int getMinimumOperation(int[] arr, int x) {
        int sum =0, k=0;
        for(int num: arr) sum += num;
        if(sum==x) return arr.length;
        if(sum < x) return -1; //not paaible
        k = sum - x;

        int right =0, left = 0, max = Integer.MIN_VALUE, total = 0;
        while (right < arr.length) {
            total += arr[right++];
            while (total > k) total -= arr[left++];
            if(total==k) max = Math.max((right-left), max);
        }
        if(max==Integer.MIN_VALUE) return -1; //not possible
        return arr.length - max;

    }
}
