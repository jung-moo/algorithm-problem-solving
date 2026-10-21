package study.problems.baekjoon.set01.p09_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] dfsVisited;
  static boolean[] bfsVisited;
  static StringBuilder sb = new StringBuilder();

  private static void dfs(int start) {

    dfsVisited[start] = true;
    sb.append(start).append(" ");

    for (int next : graph.get(start)) {
      if (dfsVisited[next]) continue;
      dfs(next);
    }

  }

  private static void bfs(int start) {

    Queue<Integer> q = new ArrayDeque<>();
    q.offer(start);
    bfsVisited[start] = true;
    sb.append(start).append(" ");

    while (!q.isEmpty()) {

      int now = q.poll();

      for (int next : graph.get(now)) {
        if (bfsVisited[next]) continue;
        q.offer(next);
        bfsVisited[next] = true;
        sb.append(next).append(" ");
      }

    }

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    dfsVisited = new boolean[N+1];
    bfsVisited = new boolean[N+1];

    for (int i=0; i<=N; i++) graph.add(new ArrayList<Integer>());

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    for (int i=0; i<=N; i++) Collections.sort(graph.get(i));

    dfs(V);
    sb.append('\n');
    bfs(V);

    System.out.print(sb);

  }

}