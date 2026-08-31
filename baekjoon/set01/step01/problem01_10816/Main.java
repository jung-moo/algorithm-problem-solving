package baekjoon.set01.step01.problem01_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_01_01_10816_05 {

    private static int upperBound(int[] arr, int num) {

        int left = 0;
        int right = arr.length;

        while(left < right) {

            int midIndex = left + (right - left)/2;

            if(arr[midIndex] <= num) {
                left = midIndex + 1;
            } else {
                right = midIndex;
            }

        }

        return left;

    }

    private static int lowerBound(int[] arr, int num) {

        int left = 0;
        int right = arr.length;

        while(left < right) {

            int midIndex = left + (right - left)/2;

            if(arr[midIndex] >= num) {
                right = midIndex;
            } else {
                left = midIndex+1;
            }

        }

        return left;

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
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, num) - lowerBound(arr, num)).append(' ');
        }

        System.out.print(sb);

    }

}
