import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;


// 1 1 1 1 2 2 3 4 ,,,
// 1 2 3 4 5 7 9 12 ,,,

// 1 1 1 2 2 3 4 5 7 9 ...
// P(1), P(2), P(3) == 1 로 초기화
// N > 3  ->  P(N) = P(N-2) + P(N-3)
// N > 4 -> P(N) = P(N-1) + P(N-5)


public class Main {


    public static void main(String[] args) throws IOException {
        long dp[] = new long[101];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            dp[0] = 0;
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = 2;
            if (N > 4) {
                for (int j = 5; j < N + 1; j++) {
                    dp[j] = dp[j - 1] + dp[j - 5];
                }
            }
            sb.append(dp[N]).append('\n');

        }

        System.out.println(sb);


    }
}