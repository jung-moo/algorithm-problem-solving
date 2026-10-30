package study.problems.baekjoon.set01.p21_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  static int N;
  static int[] queen;
  static int answer;

  private static void dfs(int row) {

    if (row >= N) {
      answer++;
      return;
    }

    for (int col=0; col<N; col++) {
      if (isPossible(row, col)) {
        queen[row] = col;
        dfs(row + 1);
      }
    }

  }

  private static boolean isPossible(int row, int col) {

    for (int i=0; i<row; i++) {
      if(queen[i] == col || Math.abs(i - row) == Math.abs(queen[i] - col)) return false;
    }

    return true;

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    queen = new int[N];

    dfs(0);

    System.out.print(answer);

  }

}