package study.problems.baekjoon.set01.p24_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static class Item {

    int W;
    int V;

    public Item(int W, int V) {
      this.W = W;
      this.V = V;
    }

  }

  private static int dp(ArrayList<Item> list, int K) {

    int[] dp = new int[K+1];

    for (Item item : list) {
      for (int i=K; i>=item.W; i--) {
        dp[i] = Math.max(dp[i], dp[i-item.W] + item.V);
      }
    }

    return dp[K];

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ArrayList<Item> list = new ArrayList<>();

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      list.add(new Item(W, V));
    }

    System.out.print(dp(list, K));

  }

}