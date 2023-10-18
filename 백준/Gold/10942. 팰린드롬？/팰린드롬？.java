import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(isPalindrome(S, E)).append("\n");
        }

        System.out.println(sb);
    }

    private static int isPalindrome(int S, int E) {
        // 방문함? 해당 결과
        if (dp[S][E] != -1) return dp[S][E];

        // 시작, 끝 값 다름? 팰린드롬 아님
        if (arr[S] != arr[E]) return dp[S][E] = 0;

        // 배열 길이 <= 2 ? 팰린드롬 맞음
        if (S == E || S + 1 == E) return dp[S][E] = 1;

        // 방문X, 배열 길이 >= 3, 시작==끝
        return dp[S][E] = isPalindrome(S + 1, E - 1);
    }
}