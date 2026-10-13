package baekjoon.set01.step01.problem01_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    //num 을 초과하는 숫자가 처음 등장하는 위치
    private static int upperBound(int[] cards, int num) {

        int left = 0;
        int right = cards.length - 1;
        int answer = cards.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (cards[mid] > num) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return answer;

    }

    //num 이상의 숫자가 처음 등장하는 위치
    private static int lowerBound(int[] cards, int num) {

        int left = 0;
        int right = cards.length - 1;
        int answer = cards.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (cards[mid] >= num) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return answer;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new  StringBuilder();

        Arrays.sort(cards);

        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(cards, num) - lowerBound(cards, num)).append(" ");
        }

        System.out.print(sb.toString());

    }

}
