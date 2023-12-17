import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // O

        int[][] dp = new int[N + 1][M + 1];

        dp[0][1] = 1;

        int cnt = 0; // 격자의 칸 번호
        boolean isCircle = false;
        int x = 0, y = 0;
        loop : for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cnt++;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (cnt == K) { // 반드시 지나야하는 원이 존재할 때
                    isCircle = true;
                    x = i;
                    y = j;
                    break loop;
                }
            }
        }

        // 원이 존재한다면
        if (isCircle) {
            for (int i = x; i <= N; i++) {
                for (int j = y; j <= M; j++) {
                    if ((i - 1) >= x) dp[i][j] += dp[i - 1][j];
                    if ((j - 1) >= y) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        System.out.print(dp[N][M]);
    }
}

/*
dp[i][j] = (i,j)까지 오는 경로의 수
         = dp[i-1][j] + dp[i][j - 1];

arr
 1  2   3   4  5
 6  7  (8)  9 10
11 12  13  14 15

dp
1 1 1 1 1
1 2 3 3 3
0 0 3 6 9
 */