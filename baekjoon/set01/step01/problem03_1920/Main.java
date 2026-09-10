package baekjoon.set01.step01.problem03_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static boolean isContain(int[] arr, int num) {

        int left = 0;
        int right = arr.length-1;

        while(left <= right) {

            int midIndex = left + (right - left) / 2;

            if(arr[midIndex] == num) {
                return true;
            } else if(arr[midIndex] > num) {
                right = midIndex - 1;
            } else if(arr[midIndex] < num) {
                left = midIndex + 1;
            }

        }

        return false;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(isContain(arr, num)) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

        System.out.print(sb);

    }

}
