package study.problems.baekjoon.set01.p16_14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;
  static int[][] map;
  static int[][] dist;
  static final int[] DR = {-1, 0, 1, 0};
  static final int[] DC = {0, 1, 0, -1};

  static class Point {

    int row;
    int col;

    public Point(int row, int col) {
      this.row = row;
      this.col = col;
    }

  }

  private static void bfs(int row, int col) {

    Queue<Point> q = new ArrayDeque<>();
    q.offer(new Point(row, col));
    dist[row][col] = 0;

    while (!q.isEmpty()) {

      Point now = q.poll();

      for (int i=0; i<4; i++) {
        int nextRow = now.row + DR[i];
        int nextCol = now.col + DC[i];
        if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
        if (map[nextRow][nextCol] != 1) continue;
        if (dist[nextRow][nextCol] != -1) continue;
        dist[nextRow][nextCol] = dist[now.row][now.col] + 1;
        q.offer(new Point(nextRow, nextCol));
      }

    }

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    dist = new int[n][m];

    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dist[i][j] = -1;
      }
    }

    for (int row=0; row<n; row++) {
      for (int col=0; col<m; col++) {
        if (map[row][col] == 2) bfs(row, col);
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int row=0; row<n; row++) {
      for (int col=0; col<m; col++) {
        if (map[row][col] == 0) dist[row][col] = 0;
        sb.append(dist[row][col]).append(" ");
      }
      sb.append('\n');
    }

    System.out.print(sb);

  }

}