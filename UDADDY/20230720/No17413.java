import java.util.Scanner;
import java.util.Stack;

public class No17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
            }

            if (str.charAt(i) == '>') {
                sb.append(str.charAt(i));
                flag = false;
                continue;
            }

            if (flag) {
                sb.append(str.charAt(i));
            } else if (!flag) {
                if (str.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    stack.push(str.charAt(i));
                }

            }

            if (i == str.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb.toString());
    }
}