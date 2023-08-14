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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            money[i] = a;
        }
        int M = Integer.parseInt(br.readLine());

        // 정렬
        Arrays.sort(money);

        long answer = 0;
        long start = 0;
        long end = money[N - 1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long tmp = 0;

            for (int i = 0; i < N; i++) {
                // 중간값보다 크면 현재 상한액인 mid를 저장
                if (money[i] >= mid) tmp += mid;
                    // 작다면 모든 예산 가능
                else tmp += money[i];
            }
            // 예산을 넘었으면 범위 좁히기
            if (tmp > M) end = mid - 1;
                // 예산을 넘지 않으면서 가능한 최대 상한액 찾기
            else {
                start = mid + 1;
                answer = Math.max(mid, answer);
            }
        }
        System.out.println(answer);
    }
}