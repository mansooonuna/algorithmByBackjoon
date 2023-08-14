import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 브루트포스 알고리즘
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] badCombinations = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            badCombinations[a][b] = badCombinations[b][a] = true;
        }

        int rs = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                for (int k = j + 1; k <= N; k++) {
                    if (badCombinations[i][j] || badCombinations[j][k] || badCombinations[k][i]) continue;
                    if (!badCombinations[j][k] && !badCombinations[k][j]) rs++;
                }
            }
        }
        System.out.println(rs);
    }
}