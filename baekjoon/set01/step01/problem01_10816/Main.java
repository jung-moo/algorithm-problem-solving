package baekjoon.set01.step01.problem01_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static void solution(int N, int[] arr1, int M, int[] arr2) {

        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }

        for(int i=0; i<M; i++) {
            int newNum = (map.get(arr2[i]) == null) ? 0 : map.get(arr2[i]);
            sb.append(newNum).append(' ');
        }

        System.out.print(sb);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, arr1, M, arr2);

    }

}
