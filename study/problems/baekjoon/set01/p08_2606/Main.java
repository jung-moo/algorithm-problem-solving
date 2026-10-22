package study.problems.baekjoon.set01.p08_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] parents;

  private static void union(int a, int b) {

    int aRoot = findRoot(a);
    int bRoot = findRoot(b);

    if(aRoot != bRoot) {
      parents[aRoot] = bRoot;
    }

  }

  private static int findRoot(int target) {

    if (parents[target] == target) return target;

    return parents[target] = findRoot(parents[target]);

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    parents = new int[N+1];

    for (int i=1; i<=N; i++) parents[i] = i;

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      union(a, b);
    }

    int answer = 0;
    int startRoot = findRoot(1);

    for (int i=2; i<=N; i++) {
      if (startRoot == findRoot(i)) answer++;
    }

    System.out.print(answer);

  }

}