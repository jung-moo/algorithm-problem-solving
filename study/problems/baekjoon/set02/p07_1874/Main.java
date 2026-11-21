package study.problems.baekjoon.set02.p07_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int now = 1;
    Deque<Integer> stack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {

      int target = Integer.parseInt(br.readLine());

      while (now <= target) {
        stack.push(now++);
        sb.append("+\n");
      }

      if (stack.isEmpty() || stack.peek() != target) {
        System.out.print("NO");
        return;
      }

      stack.pop();
      sb.append("-\n");

    }

    System.out.print(sb);

  }

}
