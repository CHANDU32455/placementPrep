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

    public static int precedence(char ch){
        switch (ch) {
            case '+':
            case '-':
            return 1;
            case '*':
            case '/':
            return 2;
            case '^':
            return 3;
        }
        return -1;
    }

    public static void infixToPostfix(String s){
        Stack<Character> stk = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                result.append(ch);
            }else if(ch == '('){
                stk.push(ch);
            }else if(ch == ')'){
                while(!stk.isEmpty() && stk.peek() != '('){
                    char popped = stk.pop();
                    result.append(popped);
                }
                if (!stk.isEmpty() && stk.peek() == '(')   stk.pop();  // for (
            }else{
                while(!stk.isEmpty() && precedence(ch) < precedence(stk.peek())){
                    result.append(stk.pop());
                }
                stk.push(ch);
            }
            if(i == s.length()){
                while(!stk.isEmpty()){
                    result.append(stk.pop());
                }
            }
        }
        System.out.println("Postfix Exp for A^B*C/(D*E-F) is : "+ result);
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
        infixToPostfix("A^B*C/(D*E-F)");
    }
}
