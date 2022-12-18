import java.util.ArrayDeque;

class SolutionBad {
    public int evalRPN(String[] tokens) {


        ArrayDeque<Integer> stack = new ArrayDeque<>(2 * (tokens.length / 3) + 1);

        for (String s : tokens) {
            if (s.length() > 1) {
                stack.push(Integer.parseInt(s));
                continue;
            }

            int result;
            switch (s) {
                case "+": {
                    int i2 = stack.pop();
                    int i1 = stack.pop();
                    result = i1 + i2;
                    break;
                }
                case "-": {
                    int i2 = stack.pop();
                    int i1 = stack.pop();
                    result = i1 - i2;
                    break;
                }
                case "*": {
                    int i2 = stack.pop();
                    int i1 = stack.pop();
                    result = i1 * i2;
                    break;
                }
                case "/": {
                    int i2 = stack.pop();
                    int i1 = stack.pop();
                    result = i1 / i2;
                    break;
                }
                default:
                    result = Integer.parseInt(s);
                    break;
            }
            stack.push(result);
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] input = {"4","13","5","/","+"};
        System.out.println(new SolutionBad().evalRPN(input));
    }
}