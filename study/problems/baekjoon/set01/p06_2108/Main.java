package study.problems.baekjoon.set01.p06_2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static int solution1(int[] arr, int N) {

    int sum = 0;

    for (int i=0; i<arr.length; i++) {
      sum += arr[i];
    }

    return (int) Math.round((double) sum / N);

  }

  private static int solution2(int[] arr, int N) {

    return arr[N / 2];

  }

  private static int solution3(int[] arr, int N) {

    int[] counts = new int[8001];

    for (int i=0; i<N; i++) {
      counts[ arr[i] + 4000 ]++;
    }

    int maxCnt = 0;

    for (int i=0; i<8001; i++) {
      if (counts[i] > maxCnt) {
        maxCnt = counts[i];
      }
    }

    boolean flag = false;
    int answer = -1;

    for (int i=0; i<8001; i++) {
      if (counts[i] == maxCnt) {
        if(flag) {
          return i - 4000;
        } else {
          flag = true;
          answer = i - 4000;
        }
      }
    }

    return answer;

  }

  private static int solution4(int[] arr, int N) {

    return arr[N-1] - arr[0];

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    for (int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    StringBuilder sb = new StringBuilder();

    sb.append(solution1(arr, N)).append('\n')
        .append(solution2(arr, N)).append('\n')
        .append(solution3(arr, N)).append('\n')
        .append(solution4(arr, N));

    System.out.print(sb);

  }

}
