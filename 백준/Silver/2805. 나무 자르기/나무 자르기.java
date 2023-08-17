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
    static int N;
    static long M;
    static long[] treeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        treeList = new long[N];
        for (int i = 0; i < N; i++) {
            treeList[i] = Long.parseLong(st2.nextToken());
        }
        Arrays.sort(treeList);

        long start = 0;
        long end = treeList[N - 1];

        while (start < end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (long i : treeList) {
                if (i - mid > 0) sum += (i - mid);
            }

            if (sum < M) end = mid;
            else start = mid + 1;
        }
        System.out.println(start - 1);
    }
}