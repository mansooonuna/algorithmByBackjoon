import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 10_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1; // 길이가 1인 오르막 수
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % MOD);
    }
}
/*
길이 : 1
0 1 2 3 4 5 6 7 8 9
=> 10

길이 : 2
00 01 .. 11 12 ... 22 23 .. 33 34 .. 44 45 .. 55 56 .. 66 67 .. 77 78 .. 88 89 .. 99
10     + 9      +  8      + 7       + 6     + 5       + 4     + 3     + 2      + 1
=> 55

dp[i][j] - j(0 ~ 9까지 숫자) 각 숫자에서 길이가 i인 오르막 수의 갯수
  
  1  1  1  1  1  1  1 1 1 1
 10  9  8  7  6  5  4 3 2 1
 55 45 36 28 21 15 10 6 3 1 
220
 */