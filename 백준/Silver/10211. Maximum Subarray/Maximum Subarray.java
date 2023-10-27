import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dp = new int[N + 1];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i - 1] + tmp, tmp);
                max = Math.max(dp[i], max);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}

/*
dp[i] = i까지 원소의 최대 누적합
 */