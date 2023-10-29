import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
               if (dp[i] > dp[i - j * j] + 1) {
                   dp[i] = dp[i - j * j] + 1;
               }
            }
        }

        System.out.println(dp[N]);
    }
}

/*
1 = 1 = 1
2 = 1 + 1 = 2
3 = 1 + 1 + 1 = 3

4 = 2 = 1
5 = 2 + 1 = 2
6 = 2 + 1 + 1 = 3
7 = 2 + 1 + 1 + 1 = 4
8 = 2 + 2 = 2

9 = 3 = 1
10 = 3 + 1 = 2
...

dp[i] = i의 제곱수 최소로 필요한 항의 개수
        dp[i - j*j] + 1

 */