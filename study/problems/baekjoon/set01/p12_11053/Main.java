package study.problems.baekjoon.set01.p12_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int solution(int[] arr) {

    int answer = 1;
    int[] dp = new int[arr.length];

    for (int i=0; i<arr.length; i++) {
      dp[i] = 1;
      for (int j=0; j<i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      answer = Math.max(answer, dp[i]);
    }

    return answer;

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());

    for (int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.print(solution(arr));

  }

}