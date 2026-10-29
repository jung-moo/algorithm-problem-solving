package study.problems.baekjoon.set01.p19_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

  static int N;
  static final int[] DR = {-1, 0, 1, 0};
  static final int[] DC = {0, 1, 0, -1};

  private static void bfs(char[][] board, boolean[][] visited, int row, int col, char colorCode) {

    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {row, col});
    visited[row][col] = true;

    while (!q.isEmpty()) {

      int[] now = q.poll();

      for (int i=0; i<4; i++) {
        int nextRow = now[0] + DR[i];
        int nextCol = now[1] + DC[i];
        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
        if (visited[nextRow][nextCol]) continue;
        if (board[nextRow][nextCol] != colorCode) continue;
        visited[nextRow][nextCol] = true;
        q.offer(new int[] {nextRow, nextCol});
      }

    }

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    char[][] board1 = new char[N][N];
    char[][] board2 = new char[N][N];
    boolean[][] visited1 = new boolean[N][N];
    boolean[][] visited2 = new boolean[N][N];

    for (int row=0; row<N; row++) {
      char[] arr = br.readLine().toCharArray();
      for (int col=0; col<N; col++) {
        board1[row][col] = arr[col];
        board2[row][col] = (arr[col] == 'R') ? 'G' : arr[col];
      }
    }

    StringBuilder sb = new StringBuilder();

    int cnt = 0;

    for (int row=0; row<N; row++) {
      for (int col=0; col<N; col++) {
        if (visited1[row][col]) continue;
        bfs(board1, visited1, row, col, board1[row][col]);
        cnt++;
      }
    }

    sb.append(cnt).append(' ');

    cnt = 0;

    for (int row=0; row<N; row++) {
      for (int col=0; col<N; col++) {
        if (visited2[row][col]) continue;
        bfs(board2, visited2, row, col, board2[row][col]);
        cnt++;
      }
    }

    sb.append(cnt);

    System.out.print(sb);

  }

}