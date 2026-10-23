package study.problems.baekjoon.set01.p13_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

  static int N;
  static int size;
  static char[][] map;
  static boolean[][] visited;
  static final int[] DR = {-1, 0, 1, 0};
  static final int[] DC = {0, 1, 0, -1};

  private static void dfs(int row, int col) {

    visited[row][col] = true;
    size++;

    for (int i=0; i<4; i++) {
      int nextRow = row + DR[i];
      int nextCol = col + DC[i];
      if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
      if (map[nextRow][nextCol] != '1') continue;
      if (visited[nextRow][nextCol]) continue;
      dfs(nextRow, nextCol);
    }

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    map = new char[N][N];
    visited = new boolean[N][N];

    for (int i=0; i<N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    int cnt = 0;
    ArrayList<Integer> list = new ArrayList<>();

    for (int row=0; row<N; row++) {
      for (int col=0; col<N; col++) {
        if (map[row][col] != '1' || visited[row][col]) continue;
        dfs(row, col);
        list.add(size);
        size = 0;
        cnt++;
      }
    }

    StringBuilder sb = new StringBuilder();

    sb.append(cnt).append('\n');

    Collections.sort(list);

    for (int size : list) {
      sb.append(size).append('\n');
    }

    System.out.print(sb);

  }

}