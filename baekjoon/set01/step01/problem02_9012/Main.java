package baekjoon.set01.step01.problem02_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {

            String str = br.readLine();
            stack.clear();
            boolean isValid = true;

            for(char ch : str.toCharArray()) {

                if(ch == '(') {
                    stack.push(ch);
                } else {
                    if(stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }

            }

            if(isValid && stack.isEmpty()) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }

            sb.append('\n');

        }

        System.out.print(sb);

    }

}
