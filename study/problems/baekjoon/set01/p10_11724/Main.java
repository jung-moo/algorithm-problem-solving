package study.problems.baekjoon.set01.p10_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] visited;

  private static void dfs(int start) {

    visited[start] = true;

    for (int next : graph.get(start)) {
      if (visited[next]) continue;
      dfs(next);
    }

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for (int i=0; i<=N; i++) graph.add(new ArrayList<Integer>());

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    visited = new boolean[N+1];
    int answer = 0;

    for (int i=1; i<=N; i++) {
      if(visited[i]) continue;
      dfs(i);
      answer++;
    }

    System.out.print(answer);

  }

}