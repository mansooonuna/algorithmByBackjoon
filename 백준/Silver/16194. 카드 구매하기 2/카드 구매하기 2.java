import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }


        /*
        dp[i] = 카드 i개 사는데 필요한 최소 금액
        */
        int[] dp = new int[N + 1];

        dp[1] = cards[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = 10000;
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + cards[j]);
            }
        }

        System.out.println(dp[N]);
    }
}

/*
dp[i] = 카드 i개 사는데 필요한 최소 금액
cards
1 5 6 7
dp
1 2 3 4

dp[2] = d[2], dp[1] card[1]
 */