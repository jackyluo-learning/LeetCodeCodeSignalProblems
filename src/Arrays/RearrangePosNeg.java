package Arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RearrangePosNeg {
    /*
    An array contains both positive and negative numbers in random order.
    Rearrange the array elements so that positive and negative numbers are placed alternatively.
    Number of positive and negative numbers need not be equal.
    If there are more positive numbers they appear at the end of the array.
    If there are more negative numbers, they too appear in the end of the array.
    For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
    then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
     */
    public int[] rearrangePosNeg(int[] arr) {
        int len = arr.length;
        int i = 0;
        int j = len - 1;
        int temp = 0;
        while (j > i) {
            while (arr[i] < 0) {
                i++;
            }
            while (arr[j] > 0) {
                j--;
            }
            if (j > i) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        int pos = i;
        int neg = 0;
        while (pos < len && arr[neg] < 0 && neg < pos) {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{-4, 1, -1, 2, 3, 4}, rearrangePosNeg(new int[]{1, 2, 3, -4, -1, 4}));
    }

}
