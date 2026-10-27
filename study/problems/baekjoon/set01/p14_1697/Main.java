package study.problems.baekjoon.set01.p14_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static int bfs(int N, int K) {

    if (N == K) return 0;

    Queue<Integer> q = new ArrayDeque<>();

    int[] time = new int[100001];
    Arrays.fill(time, -1);

    q.offer(N);
    time[N] = 0;

    while (!q.isEmpty()) {

      int now = q.poll();

      int[] nextPositions = {now + 1, now - 1, now * 2};

      for (int next : nextPositions) {
        if (next == K) return time[now] + 1;
        if (next < 0 || next > 100000) continue;
        if (time[next] != -1) continue;
        time[next] = time[now] + 1;
        q.offer(next);
      }

    }

    return -1;

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    System.out.print(bfs(N, K));

  }

}