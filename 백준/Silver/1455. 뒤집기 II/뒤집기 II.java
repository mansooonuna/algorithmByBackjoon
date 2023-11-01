import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        coins = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                coins[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int b = m - 1; b >= 0; b--) {
            for (int a = n - 1; a >= 0; a--) {
                if (coins[a][b] == 1) {
                    reverse(a, b);
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }

    static void reverse(int a, int b) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (coins[i][j] == 1) {
                    coins[i][j] = 0;
                } else {
                    coins[i][j] = 1;
                }
            }
        }
    }
}


/**
 * (a,b)를 뒤집으려면 (0,0)부터 (a,b)까지 뒤집어야함
 * -> 끝에서부터 1(뒷면)을 만나면 모두 뒤집기
 */