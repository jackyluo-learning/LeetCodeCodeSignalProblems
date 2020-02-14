import org.junit.*;

import java.io.PrintStream;

public class isPalindrome {
    private int x;
    @Rule
    public MyJUnitStopWatch stopwatch = new MyJUnitStopWatch();


    @Before
    public void before(){
        x = 10;
    }

    @Test
    public void test() {
        Assert.assertFalse(isPalindrome1(x));
    }

    @Test
    public void test2(){
        Assert.assertFalse(isPalindrome2(x));
    }

    @After
    public void after(){
        x = 0;
    }


    public static boolean isPalindrome1(int x) {
        if(x < 0){
            return false;
        }
        String input = String.valueOf(x);
        StringBuilder reverseInput = new StringBuilder(input).reverse();
        if(input.equals(reverseInput.toString())){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isPalindrome2(int x){
        int temp = x;
        int result = 0;
        while(x > 0){
            int i = x % 10;
            result = result*10 + i;
            x /= 10;
        }
        if(result == temp){
            return true;
        }
        else{
            return false;
        }
    }
}