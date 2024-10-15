import java.util.Stack;

public class InfixtoPrefix {
    // Helper function to check if a character is an operator (+, -, *, /, ^)
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Helper function to get the precedence of an operator
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    // Function to convert infix to prefix expression
    public static String infixToPrefix(String infix) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();

        // Reverse the infix expression
        StringBuilder reversedInfix = new StringBuilder(infix).reverse();

        for (int i = 0; i < reversedInfix.length(); i++) {
            char c = reversedInfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                operandStack.push(Character.toString(c));
            } else if (c == ')') {
                operatorStack.push(c);
            } else if (c == '(') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != ')') {
                    String operand1 = operandStack.pop();
                    String operand2 = operandStack.pop();
                    char operator = operatorStack.pop();
                    String result = operator + operand2 + operand1;
                    operandStack.push(result);
                }
                operatorStack.pop(); // Pop the corresponding '('
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
                    String operand1 = operandStack.pop();
                    String operand2 = operandStack.pop();
                    char operator = operatorStack.pop();
                    String result = operator + operand2 + operand1;
                    operandStack.push(result);
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            String operand1 = operandStack.pop();
            String operand2 = operandStack.pop();
            char operator = operatorStack.pop();
            String result = operator + operand2 + operand1;
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    public static void main(String[] args) {
        String infixExpression = "(3+5)*(2-6)";
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Infix: " + infixExpression);
        System.out.println("Prefix: " + prefixExpression);
    }
}

