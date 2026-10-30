package study.problems.baekjoon.set01.p20_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

  static int L;
  static int C;
  static char[] arr;
  static ArrayList<String> list;

  private static void dfs(int start, int cnt) {

    if (cnt == L) {
      if(checkArr(arr)) {
        for (int i=0; i<L; i++) {
          System.out.print(arr[i]);
        }
        System.out.println();
      }
      return;
    }

    for (int i=start; i<C; i++) {
      arr[cnt] = list.get(i).charAt(0);
      dfs(i+1, cnt+1);
    }

  }

  private static boolean checkArr(char[] arr) {
    int cnt = 0;
    for (int i=0; i<L; i++) {
      if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
        cnt++;
      }
    }
    if(cnt >= 1 && L - cnt >= 2) return true;
    return false;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    arr = new char[L];

    st = new StringTokenizer(br.readLine());
    list = new ArrayList<>();

    for (int i=0; i<C; i++) {
      list.add(st.nextToken());
    }

    Collections.sort(list);

    dfs(0, 0);

  }

}