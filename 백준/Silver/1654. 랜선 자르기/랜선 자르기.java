import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이분 탐색
 * 매개 변수 탐색
 */

public class Main {
    static int K;
    static long N;
    static long[] lan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Long.parseLong(st.nextToken());

        lan = new long[K];
        for (int i = 0; i < K; i++) {
            lan[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(lan);

        long start = 1;
        long end = lan[K - 1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (long l : lan) {
                count += l / mid;
            }

            if (count >= N) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(end);
    }
}