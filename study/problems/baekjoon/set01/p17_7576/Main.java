package study.problems.baekjoon.set01.p17_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int M;
  static int N;
  static int[][] box;
  static int[][] days;
  static Queue<Point> q = new ArrayDeque<>();
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

  private static void bfs() {

    while (!q.isEmpty()) {

      Point now = q.poll();

      for (int i=0; i<4; i++) {
        int nextRow = now.row + DR[i];
        int nextCol = now.col + DC[i];
        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;
        if (box[nextRow][nextCol] != 0) continue;
        if (days[nextRow][nextCol] != -1) continue;
        days[nextRow][nextCol] = days[now.row][now.col] + 1;
        q.offer(new Point(nextRow, nextCol));
      }

    }

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    box = new int[N][M];
    days = new int[N][M];

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
        days[i][j] = -1;
        if (box[i][j] == 1) {
          q.offer(new Point(i, j));
          days[i][j] = 0;
        }
      }
    }

    bfs();

    int answer = -1;

    for (int i=0; i<N; i++) {
      for (int j=0; j<M; j++) {
        if (box[i][j] == -1) continue;
        if (days[i][j] == -1) {
          System.out.print(-1);
          return;
        }
        answer = Math.max(days[i][j], answer);
      }
    }

    System.out.print(answer);

  }

}