import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 구현
 * 브루트포스 알고리즘
 * 시뮬레이션
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gamePeople = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int bbundegi = Integer.parseInt(br.readLine());

        int round = 1;
        int bbun = 0;
        int degi = 0;

        // 이름 붙은 반복문
        loop:
        while (true) {
            // 뻔 - 데기 - 뻔 - 데기
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) bbun++;
                else degi++;

                if (bbundegi == 0 && bbun == T) break loop;
                if (bbundegi == 1 && degi == T) break loop;
            }

            // 뻔 * N - 데기 * N
            for (int i = 0; i <= round; i++) {
                bbun++;
                if (bbundegi == 0 && bbun == T) break loop;
            }
            for (int i = 0; i <= round; i++) {
                degi++;
                if (bbundegi == 1 && degi == T) break loop;
            }
            round++;
        }

        int total = bbun + degi;
        int ans = total % gamePeople;

        if (ans == 0) {
            System.out.println(gamePeople - 1);
        } else {
            System.out.println(ans - 1);
        }
    }
}