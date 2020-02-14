import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {
    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Example:
        Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
     */

    @Test
    public void test(){
        Assert.assertEquals(Arrays.toString(new int[]{3, 4}), Arrays.toString(twoSum(new int[]{2,4,2,5,6}, 11)));
    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int complement = target - nums[i];
            if(numbers.containsKey(complement)){
                result[1] = i;
                result[0] = numbers.get(complement);
                return result;
            }
            numbers.put(nums[i], i);
        }
        return result;
    }
}

