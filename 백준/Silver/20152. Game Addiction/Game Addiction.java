import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); // 집
        int N = Integer.parseInt(st.nextToken()); // PC방

        // dp의 크기는 H - N 의 차이로 설정
        int HN = Math.abs(H - N) + 1;
        
        long[][] dp = new long[HN][HN];
        for (int i = 0; i < HN; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < HN; i++) {
            for (int j = 1; j < HN; j++) {
                if (j >= i)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        System.out.println(dp[HN - 1][HN - 1]);

    }
}

/*
dp[i][j] = (0,0)부터 (i,j)까지 도달하는 경로의 수

y > x -> 침수
  0 1 2 3 4 5 6 7 8
0
1 x
2 x x
3 x x x
4 x x x x
5 x x x x x
6 x x x x x x
7 x x x x x x x
8 x x x x x x x x

가능 이동 경로 : → ↑ / ↑ →
dp[x-1][y] + dp[x][y-1]
 */