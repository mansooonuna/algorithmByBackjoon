import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                int canJump = arr[i];
                for (int j = 1; j <= canJump; j++) {
                    if (i + j < N) dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        if (dp[N - 1] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[N - 1]);
        br.close();
    }
}

/*
dp[i] = i번까지 도달하기 위한 최소 점프 횟수

1 2 0 1 3 2 1 5 4 2
0 1 2 2 3 4 4 4 5 5
 */