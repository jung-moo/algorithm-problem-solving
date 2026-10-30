package study.problems.baekjoon.set01.p21_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  static int N;
  static boolean[][] board;
  static int answer;

  private static void dfs(int row) {

    if (row >= N) {
      answer++;
      return;
    }

    for (int col=0; col<N; col++) {
      if (isPossible(row, col)) {
        board[row][col] = true;
        dfs(row + 1);
        board[row][col] = false;
      }
    }

  }

  private static boolean isPossible(int row, int col) {

    for (int i=0; i<N; i++) {
      if(board[i][col]) return false;
    }

    int[] dr = {-1, 1, 1, -1};
    int[] dc = {1, 1, -1, -1};

    for (int i=1; i<=N; i++) {
      for (int j=0; j<4; j++) {
        int nextRow = row + (i * dr[j]);
        int nextCol = col + (i * dc[j]);
        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
        if (board[nextRow][nextCol]) return false;
      }
    }

    return true;

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    board = new boolean[N][N];

    dfs(0);

    System.out.print(answer);

  }

}