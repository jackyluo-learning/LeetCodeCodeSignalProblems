package Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SecondSmallest {

    public int findSecondSmallest(int[] a){
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (a[i] < first){
                second = first;
                first = a[i];
            }
            else if (a[i] < second && a[i] > first){
                second = a[i];
            }
        }
        return second;
    }

    @Test
    public void test(){
        int[] test = {5, 7, 8, 3, 4, 0, 9, 1};
        Assert.assertEquals(findSecondSmallest(test), 1);
    }
}
