package study.problems.baekjoon.set01.p07_9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int testCase=0; testCase<T; testCase++) {

      Map<String, Integer> map = new HashMap<>();

      int N = Integer.parseInt(br.readLine());

      for (int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        String item = st.nextToken();
        String category = st.nextToken();
        map.put(category, map.getOrDefault(category, 0) + 1);
      }

      int answer = 1;

      for (int value : map.values()) {
        answer *= (value + 1);
      }
      answer = answer - 1;

      sb.append(answer).append('\n');

    }

    System.out.print(sb);

  }

}
