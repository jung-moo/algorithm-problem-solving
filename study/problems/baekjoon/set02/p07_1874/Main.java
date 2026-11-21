package study.problems.baekjoon.set02.p07_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Stack<Integer> stack = new Stack<>();
    int targetIndex = 0;
    StringBuilder sb = new StringBuilder();
    boolean flag = true;

    for (int i = 1; i <= n; i++) {
      if (!flag) break;
      stack.push(i);
      sb.append('+').append('\n');
      while (!stack.isEmpty() && stack.peek() == arr[targetIndex]) {
        stack.pop();
        sb.append('-').append('\n');
        targetIndex++;
        if (targetIndex == n) {
          flag = false;
          break;
        }
      }
    }

    if (!stack.isEmpty()) {
      System.out.print("NO");
    } else {
      System.out.print(sb);
    }

  }

}