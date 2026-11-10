package study.problems.baekjoon.set01.p25_1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

  static class Edge implements Comparable<Edge> {

    int to;
    int cost;

    public Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.cost, o.cost);
    }

  }

  private static int solution(int start) {

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(start, 0));
    boolean[] visited = new boolean[N+1];
    int totalCost = 0;
    int visitedCnt = 0;
    int maxCost = 0;

    while (!pq.isEmpty()) {

      Edge now = pq.poll();

      if (visited[now.to]) continue;

      visited[now.to] = true;
      totalCost += now.cost;
      visitedCnt++;
      maxCost = Math.max(maxCost, now.cost);

      if (visitedCnt == N) break;

      for (Edge next : graph.get(now.to)) {
        if (visited[next.to]) continue;
        pq.offer(next);
      }

    }

    return totalCost - maxCost;

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Edge(b, cost));
      graph.get(b).add(new Edge(a, cost));
    }

    System.out.print(solution(1));

  }

}