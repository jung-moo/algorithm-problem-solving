package study.problems.baekjoon.set01.problem05_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static class Docu {

    int index;
    int priority;

    public Docu(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }

  }

  private static int solution(Queue<Docu> q, int target) {

    int cnt = 0;

    while (!q.isEmpty()) {

      Docu docu = q.poll();
      boolean canPrint = true;

      for (Docu d : q) {
        if (docu.priority < d.priority) {
          canPrint = false;
          break;
        }
      }

      if (canPrint) {
        cnt++;
        if (docu.index == target) return cnt;
      } else {
        q.offer(docu);
      }

    }

    return -1;

  }

  public static void main(String[] args) throws IOException {

    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testCnt = Integer.parseInt(br.readLine());

    for (int t=0; t<testCnt; t++) {

      Queue<Docu> q = new ArrayDeque<>();

      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());

      for (int i=0; i<N; i++) {
        int priority = Integer.parseInt(st.nextToken());
        q.offer(new Docu(i, priority));
      }

      sb.append(solution(q, M)).append('\n');

    }

    System.out.print(sb);

  }

}
