import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int ans = 0;
        for(int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int preWork = Integer.parseInt(st.nextToken());

            dp[n] = time; // 일단 기본적으로 걸리는 시간

            for (int i = 0; i < preWork; i++) {
                int preWorkNum = Integer.parseInt(st.nextToken());
                dp[n] = Math.max(dp[n], dp[preWorkNum] + time);
            }

            ans = Math.max(ans, dp[n]);
        }

        System.out.println(ans);
    }
}

/**
 * dp[i] = i번 작업 실행 시 필요한 시간
 *  -> 선행 작업이 없다 : 그냥 그 시간
 *  -> 선행 작업이 있다 : 그 작업 시간 + 선행작업 시간 (필요한 최대 시간)
 *
 */