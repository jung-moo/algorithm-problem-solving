package study.problems.baekjoon.set01.p23_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int R;
  static int C;
  static char[][] board;
  static int answer;
  static final int[] DR = {-1, 0, 1, 0};
  static final int[] DC = {0, 1, 0, -1};

  private static void dfs(int row, int col, Set<Character> set) {

    answer = Math.max(answer, set.size());

    for (int i=0; i<4; i++) {
      int nextRow = row + DR[i];
      int nextCol = col + DC[i];
      if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;
      if (set.contains(board[nextRow][nextCol])) continue;
      set.add(board[nextRow][nextCol]);
      dfs(nextRow, nextCol, set);
      set.remove(board[nextRow][nextCol]);
    }

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    board = new char[R][C];

    for (int i=0; i<R; i++) {
      board[i] = br.readLine().toCharArray();
    }

    Set<Character> set = new HashSet<>();

    set.add(board[0][0]);

    dfs(0, 0, set);

    System.out.print(answer);

  }

}