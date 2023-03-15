import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    dp[N] = N번째 계단까지 도착했을 때 얻을 수 있는 총점의 최대값
    dp[N]
    1) N-1번째 계단까지의 최대값 + N번째 계단의 점수(N-2번째 계단은 밟을 수 없음)
    2) N-2번째 계단까지의 최대값 + N번째 계단의 점수

    1) vs 2) 중 더 큰 값이 dp[N]

    1) N-3번째, N-1번째, N번째 밟는다. dp[N-3] + (N-1번째 계단의 점수) + (N번째 계단의 점수)
    2) dp[N-2] + N번째 계단의 점수
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N+1 크기의 배열 생성
        int N = Integer.parseInt(br.readLine());
        int[] stepPoint = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stepPoint[0] = 0;
            stepPoint[i] = Integer.parseInt(br.readLine()); // stepPoint : 0 10 20 15 25 10 20
        }

        //계단의 합을 저장해나갈 dp 생성
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = stepPoint[1];

        if(N == 1) {
            System.out.println(dp[N]);
        } else {
            dp[2] = dp[1] + stepPoint[2];
            for (int i = 3; i < N + 1; i++) {
                dp[i] = Math.max(dp[i - 3] + stepPoint[i - 1] + stepPoint[i], dp[i - 2] + stepPoint[i]);
            }

            System.out.println(dp[N]);

        }

    }
}