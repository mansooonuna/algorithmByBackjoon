import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N, M, H;
    static int[][] dp;
    static List<Integer>[] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 최대 블록 수
        H = Integer.parseInt(st.nextToken()); // 블록 높이

        dp = new int[N + 1][H + 1];
        dp[0][0] = 1;
        students = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            students[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                students[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= N; i++) {
            // 초기화 -> 학생들 모두 블록 사용 안함
            dp[i][0] = 1;

            for (int j = 1; j <= H; j++) {
                // i번째 학생이 자신의 k번째 블록을 선택하는 경우
                for (int k = 0; k < students[i].size(); k++) {
                    if (j - students[i].get(k) < 0)
                        continue;

                    dp[i][j] += dp[i - 1][j - students[i].get(k)] % 10007;
                }
                // i번째 학생이 블록을 사용하지 않는 경우
                dp[i][j] += dp[i - 1][j] % 10007;

            }
        }

        System.out.println(dp[N][H] % 10007);
    }
}

/**
 * dp[i][j] = i 명 학생들이 j 높이 탑을 쌓을 수 있는 경우의 수
 * j = 0 -> 높이가 0이믈 모든 i에 대해 1 (학생들이 모두 블록을 사용하지 않는 경우)
 *
 * 1. dp[i-1][j-students[k]] : i번 학생 -> 자신의 k번째 블록 사용
 *                             그러니까 i-1번 학생까지 j - block[i][k] 만큼 쌓았음
 *
 * 2. dp[i-1][j] : i번 학생 -> 자신의 블록 사용 안함
 *                여기는 i-1번 학생까지 j 높이 다 쌓았음
 *
 *
 * 1, 0, 0, 0, 0, 0
 * 1, 0, 1, 1, 0, 1
 * 1, 0, 1, 2, 0, 3
 * 1, 1, 2, 4, 3, 6
 */