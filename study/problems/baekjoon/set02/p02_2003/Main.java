package study.problems.baekjoon.set02.p02_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int solution(int[] arr, int M) {

    int sum = 0;
    int left = 0;
    int answer = 0;

    for (int right=0; right < arr.length; right++) {
      sum += arr[right];
      while (sum >= M) {
        if (sum == M) answer++;
        sum -= arr[left++];
      }
    }

    return answer;

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());

    for (int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.print(solution(arr, M));

  }

}