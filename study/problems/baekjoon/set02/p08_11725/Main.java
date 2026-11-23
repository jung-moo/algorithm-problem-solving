package study.problems.baekjoon.set02.p08_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

  private static void bfs(int start) {

    Queue<Integer> q = new ArrayDeque<>();
    q.offer(start);

    int[] parents = new int[N + 1];
    parents[start] = -1;

    while (!q.isEmpty()) {

      int now = q.poll();

      for (int next : tree.get(now)) {
        if (parents[next] != 0) continue;
        q.offer(next);
        parents[next] = now;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 2; i <= N; i++) {
      sb.append(parents[i]).append('\n');
    }

    System.out.print(sb);

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i <= N; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      tree.get(a).add(b);
      tree.get(b).add(a);
    }

    bfs(1);

  }

}