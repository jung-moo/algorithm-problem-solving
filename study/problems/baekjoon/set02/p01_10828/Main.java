package study.problems.baekjoon.set02.p01_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Integer> list = new ArrayList<>();

  private static void push(int target) {

    list.add(target);

  }

  private static int pop() {

    int lastIndex = list.size() - 1;

    return (lastIndex == -1) ? -1 : list.remove(lastIndex);

  }

  private static int size() {

    return list.size();

  }

  private static int empty() {

    return (list.size() == 0) ? 1 : 0;

  }

  private static int top() {

    int lastIndex = list.size() - 1;

    return (lastIndex == -1) ? -1 : list.get(lastIndex);

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i=0; i<N; i++) {

      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      if("push".equals(command)) {
        Integer target = Integer.parseInt(st.nextToken());
        push(target);
      } else if("pop".equals(command)) {
        sb.append(pop()).append('\n');
      } else if("size".equals(command)) {
        sb.append(size()).append('\n');
      } else if("empty".equals(command)) {
        sb.append(empty()).append('\n');
      } else if("top".equals(command)) {
        sb.append(top()).append('\n');
      }

    }

    System.out.print(sb);

  }

}