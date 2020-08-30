package Stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class PostExpressionCalculation {
    public int cal(String exp){
        int len = exp.length();
        Stack<Integer> storge = new Stack();
        int result;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(exp.charAt(i))){
                storge.push(Character.getNumericValue(exp.charAt(i)));
            }
            else{
                char op = exp.charAt(i);
                int val1 = storge.pop();
                int val2 = storge.pop();
                result = switch (op) {
                    case '*' -> val2 * val1;
                    case '+' -> val2 + val1;
                    case '-' -> val2 - val1;
                    case '/' -> val2 / val1;
                    default -> throw new IllegalStateException("Unexpected value: " + op);
                };
                storge.push(result);
            }
        }
        return storge.pop();
    }

    @Test
    public void test(){
        String exp = "231*+9-";
        Assert.assertEquals(-4, cal(exp));
    }
}
