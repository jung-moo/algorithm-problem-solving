package study.problems.baekjoon.set01.p11_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static int[][] map;
  static boolean[][] visited;
  static final int[] DR = {-1, 0, 1, 0};
  static final int[] DC = {0, 1, 0, -1};

  private static void dfs(int row, int col) {

    visited[row][col] = true;

    for (int i=0; i<4; i++) {
      int nextRow = row + DR[i];
      int nextCol = col + DC[i];
      if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;
      if (map[nextRow][nextCol] != 1) continue;
      if (visited[nextRow][nextCol]) continue;
      dfs(nextRow, nextCol);
    }

  }

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int testCase=0; testCase<T; testCase++) {

      st = new StringTokenizer(br.readLine());

      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      map = new int[N][M];
      visited = new boolean[N][M];

      for (int i=0; i<K; i++) {
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        map[Y][X] = 1;
      }

      int answer = 0;

      for (int row=0; row<N; row++) {
        for (int col=0; col<M; col++) {
          if (map[row][col] == 1 && !visited[row][col]) {
            dfs(row, col);
            answer++;
          }
        }
      }

      sb.append(answer).append('\n');

    }

    System.out.print(sb);

  }

}