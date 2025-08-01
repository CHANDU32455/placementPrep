import java.util.*;

public class stackApks {

    public static void reverseString(char[] s) {
        Stack<Character> stk = new Stack<>();
        for (char ch : s) {
            stk.push(ch);
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = stk.pop();
        }

    }

    public static int evalPostfix(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int b = stk.pop();
                int a = stk.pop();
                switch (token) {
                    case "+" -> stk.push(a + b);
                    case "-" -> stk.push(a - b);
                    case "*" -> stk.push(a * b);
                    case "/" -> stk.push(a / b);
                }
            } else {
                stk.push(Integer.parseInt(token));
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        String s = "helloworld";
        char[] res = s.toCharArray();
        reverseString(res);
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println("after evaluating( 21+3* ):" + evalPostfix(tokens)); // Output: 9
    }
}
