package study.problems.baekjoon.set02.p06_12891;

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

    st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());
    String dnaString = br.readLine();
    st = new StringTokenizer(br.readLine());
    int[] countConditions = new int[4];
    for (int i = 0; i < 4; i++) {
      countConditions[i] = Integer.parseInt(st.nextToken());
    }

    Map<Character, Integer> map = new HashMap<>();
    char[] dnaCharacters = {'A', 'C', 'G', 'T'};
    int answer = 0;

    for (int i = 0; i < P - 1; i++) {
      map.put(dnaString.charAt(i), map.getOrDefault(dnaString.charAt(i), 0) + 1);
    }

    for (int i = P - 1; i < S; i++) {
      map.put(dnaString.charAt(i), map.getOrDefault(dnaString.charAt(i), 0) + 1);
      boolean flag = true;
      for (int j = 0; j < 4; j++) {
        if ( map.getOrDefault(dnaCharacters[j], 0) < countConditions[j] ) {
          flag = false;
          break;
        }
      }
      if (flag) answer++;
      map.put(dnaString.charAt(i - (P - 1)), map.get(dnaString.charAt(i - (P - 1))) - 1);
    }

    System.out.print(answer);

  }

}