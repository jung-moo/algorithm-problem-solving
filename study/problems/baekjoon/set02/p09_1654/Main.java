package study.problems.baekjoon.set02.p09_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static long solution(int[] arr, int N, int min, int max) {

    long left = min;
    long right = max;
    long answer = 0;

    while (left <= right) {

      long mid = left + (right - left) / 2;

      long lanCnt = getLanCnt(arr, mid);

      if (lanCnt >= N) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }

    }

    return answer;

  }

  private static long getLanCnt(int[] arr, long lanlength) {

    long answer = 0L;

    for (int i = 0; i < arr.length; i++) {

      answer += arr[i] / lanlength;

    }

    return answer;

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[K];
    int kMax = 0;

    for (int i = 0; i < K; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      kMax = Math.max(kMax, arr[i]);
    }

    long answer = solution(arr, N, 1, kMax);
    System.out.print(answer);

  }

}