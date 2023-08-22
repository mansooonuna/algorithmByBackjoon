import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정렬
 * 이분 탐색
 * 두 포인터
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] solutions = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(solutions);

        int startIdx = 0;
        int endIdx = N - 1;

        long ans1 = 0;
        long ans2 = 0;

        long minDiff = Integer.MAX_VALUE;
        while (startIdx < endIdx) {
            // 양수와 음수의 비교를 위해서 절댓값으로 환산
            long diff = Math.abs(solutions[startIdx] + solutions[endIdx]);

            if (diff < minDiff) {
                // 0과 가장 가까운 minDiff 업데이트
                minDiff = diff;
                ans1 = solutions[startIdx];
                ans2 = solutions[endIdx];
            }

            // 두 용액을 합쳤을 때 양수 -> 합을 줄여야 함
            if (solutions[startIdx] + solutions[endIdx] > 0) endIdx--;
            // 두 용액을 합쳤을 때 음수 -> 합이 더 커져야 함
            else startIdx++;
        }

        System.out.println(ans1 + " " + ans2);
    }
}