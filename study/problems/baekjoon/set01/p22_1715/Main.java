package study.problems.baekjoon.set01.p22_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i=0; i<N; i++) pq.offer(Integer.parseInt(br.readLine()));

    int mixCnt = 0;

    for (int i=1; i<=N-1; i++) {
      int tmp = pq.poll() + pq.poll();
      pq.offer(tmp);
      mixCnt += tmp;
    }

    System.out.print(mixCnt);

  }

}