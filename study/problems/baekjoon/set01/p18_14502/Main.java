package study.problems.baekjoon.set01.p18_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static int[][] map;
  static int answer;
  static final int[] DR = {-1, 0, 1, 0};
  static final int[] DC = {0, 1, 0, -1};

  private static void makeWall(int startRow, int startCol, int wallCnt) {

    // 벽이 3개면 종료
    if (wallCnt == 3) {

      int[][] mapCopy = new int[N][M];
      boolean[][] visited = new boolean[N][M];

      for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
          mapCopy[i][j] = map[i][j];
        }
      }

      // 바이러스 확산
      spreadVirus(mapCopy, visited);

      // 안전지대 사이즈 확인
      answer = Math.max(answer, checkSize(mapCopy));

      return;

    }

    for (int row=startRow; row<N; row++) {
      int col = (row == startRow) ? startCol+1 : 0;
      for (; col<M; col++) {
        if (map[row][col] != 0) continue;
        map[row][col] = 1;
        makeWall(row, col, wallCnt+1);
        map[row][col] = 0;
      }
    }

  }

  private static void spreadVirus(int[][] mapCopy, boolean[][] visited) {

    for (int i=0; i<N; i++) {
      for (int j=0; j<M; j++) {
        if (mapCopy[i][j] != 2) continue;
        if (visited[i][j]) continue;
        bfs(mapCopy, visited, i, j);
      }
    }

  }

  private static void bfs(int[][] mapCopy, boolean[][] visited, int row, int col) {

    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {row, col});
    visited[row][col] = true;

    while (!q.isEmpty()) {

      int[] now = q.poll();

      for (int i=0; i<4; i++) {
        int nextRow = now[0] + DR[i];
        int nextCol = now[1] + DC[i];
        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;
        if (mapCopy[nextRow][nextCol] != 0) continue;
        if (visited[nextRow][nextCol]) continue;
        visited[nextRow][nextCol] = true;
        mapCopy[nextRow][nextCol] = 2;
        q.offer(new int[] {nextRow, nextCol});
      }

    }

  }

  private static int checkSize(int[][] mapCopy) {

    int size = 0;

    for (int i=0; i<N; i++) {
      for (int j=0; j<M; j++) {
        if (mapCopy[i][j] == 0) size++;
      }
    }

    return size;

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int row=0; row<N; row++) {
      for (int col=0; col<M; col++) {
        if (map[row][col] == 0) {
          map[row][col] = 1;
          makeWall(row, col, 1);
          map[row][col] = 0;
        }
      }
    }

    System.out.print(answer);

  }

}