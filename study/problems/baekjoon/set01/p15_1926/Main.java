package study.problems.baekjoon.set01.p15_1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;
  static int[][] board;
  static boolean[][] visited;
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

  private static int bfs(int row, int col) {

    Queue<Point> q = new ArrayDeque<>();
    q.offer(new Point(row, col));
    visited[row][col] = true;
    int size = 1;

    while (!q.isEmpty()) {

      Point now = q.poll();

      for (int i=0; i<4; i++) {
        int nextRow = now.row + DR[i];
        int nextCol = now.col + DC[i];
        if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
        if (board[nextRow][nextCol] != 1) continue;
        if (visited[nextRow][nextCol]) continue;
        visited[nextRow][nextCol] = true;
        q.offer(new Point(nextRow, nextCol));
        size++;
      }

    }

    return size;

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    visited = new boolean[n][m];

    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int maxSize = 0;
    int cnt = 0;

    for (int row=0; row<n; row++) {
      for (int col=0; col<m; col++) {
        if (board[row][col] != 1) continue;
        if (visited[row][col]) continue;
        maxSize = Math.max(maxSize, bfs(row, col));
        cnt++;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(cnt).append('\n').append(maxSize);

    System.out.print(sb);

  }

}