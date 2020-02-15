import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    @Rule
    public MyJUnitStopWatch stopwatch = new MyJUnitStopWatch();


    @Test
    public void test() {
        Assert.assertFalse(validParentheses("{}(){]}["));
        Assert.assertTrue(validParentheses(""));
        Assert.assertFalse(validParentheses("(("));
        Assert.assertTrue(validParentheses("()"));
        Assert.assertFalse(validParentheses("("));
    }

    public static boolean validParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') return false;
                stack.push(c);
                continue;
            }
            char top = stack.peek();
            switch (top) {
                case '(':
                    if (c == ')') {
                        stack.pop();
                        continue;
                    }
                    break;
                case '[':
                    if (c == ']') {
                        stack.pop();
                        continue;
                    }
                    break;
                case '{':
                    if (c == '}') {
                        stack.pop();
                        continue;
                    }
                    break;
            }
            stack.push(c);
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }
}
