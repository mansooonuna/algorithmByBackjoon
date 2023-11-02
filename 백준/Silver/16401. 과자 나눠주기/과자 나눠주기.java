import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 조카
        int N = Integer.parseInt(st.nextToken()); // 과자
        int[] snack = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(snack[i], max);
        }

        int left = 1;
        int right = max;

        int rs = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 나눠줄 수 있는 과자 개수
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += snack[i] / mid;
            }

            if (cnt >= M) {
                // 조카 수보다 과자 수가 많으면
                rs = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(rs);
    }
}