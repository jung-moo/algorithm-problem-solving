package baekjoon.set01.step01.problem04_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

  private static int solution(int N) {

    Queue<Integer> q = new ArrayDeque<Integer>();

    for (int i=1; i<=N; i++) q.offer(i);

    while (q.size() > 1) {
      q.poll();
      q.offer(q.poll());
    }

    return q.peek();

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    System.out.print(solution(N));

  }

}
