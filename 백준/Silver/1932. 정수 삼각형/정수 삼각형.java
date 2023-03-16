import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
            여기서 1층은 꼭대기층 (위에서 아래로 탐색)
            dp[][]

            dp[1][1] = numbers[1][1];
            dp[2][1] = 10 dp[2][2] = 15 => 15
            dp[3][1] = 18 dp[3][2] = 16 dp[3][3] = 15
            dp[3][2] = Math.max(dp[2][1], dp[2][2]) + 1

            dp[N][i] = Math.max(dp[N-1][i-1], dp[N-1][i]) + numbers[N][i];

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        int[][] numbers = new int[n + 1][n + 1];
        /*
        dp[n] = [dp[n][0], dp[n][1], ... dp[n][n]] => 최대 dp[n][1]
         */


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = numbers[1][1];
        for (int i = 2; i <= n; i++) { // 층
            for (int j = 1; j <= i; j++) { // i층에서 몇 번째 숫자인지
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + numbers[i][j];
            }
        }

        int max = 0; // n층의 최대값
        for (int i = 1; i <= n ; i++) {
            max = Math.max(dp[n][i], max);
        }
        // dp[n][1], dp[n][2], ..., dp[n][n]
        System.out.println(max);

    }
}