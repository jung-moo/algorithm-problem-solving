package study.problems.baekjoon.set02.p05_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] steps = new int[N+1];
    int[] dp = new int[N+1];

    for (int i=1; i<=N; i++) {
      steps[i] = Integer.parseInt(br.readLine());
    }

    dp[1] = steps[1];
    if (N >= 2) {
      dp[2] = steps[1] + steps[2];
    }

    for (int i=3; i<=N; i++) {
      dp[i] = Math.max(dp[i-2] + steps[i], dp[i-3] + steps[i-1] +  steps[i]);
    }

    System.out.print(dp[N]);

  }

}