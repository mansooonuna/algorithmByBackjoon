import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[21];
        int[] death = new int[21];
        dp[1] = 1;
        death[4] = 1; // 1년에 태어난 벌레 사망

        for (int i = 2; i < 21 ; i++) {
            int birth = dp[i - 1];
            dp[i] = (birth * 2) - death[i];

            // 짝수 년도 벌레 - 4년 후 사망
            if (i % 2 == 0) {
                if (i + 4 <= 20) {
                    death[i + 4] += birth;
                }
            }
            // 홀수 년도 벌레 - 3년 후 사망
            else {
                if (i + 3 <= 20) {
                    death[i + 3] += birth;
                }
            }
        }
        System.out.println(dp[N]);
    }
}

/*
dp[i] = i년도에 존재하는 벌레 수
death[i] = i년도에 죽는 벌레 수
 */