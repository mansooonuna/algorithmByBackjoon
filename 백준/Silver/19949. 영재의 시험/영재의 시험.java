import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] YJ, answer;
    static int rs = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        YJ = new int[10];

        answer = new int[10];
        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);
        System.out.println(rs);
    }

    static void backtracking(int num) {
        if (num == 10) {
            int collect = 0;
            for (int i = 0; i < 10; i++) {
                if (answer[i] == YJ[i]) collect++;
            }

            // 5점 이상
            if (collect >= 5) rs++;

            return;
        }

        for (int i = 1; i <= 5; i++) {
            // 3연속 같은 답일 때
            if (num >= 2) {
                if (YJ[num - 1] == i && YJ[num - 2] == i) continue;
            }

            YJ[num] = i;
            backtracking(num + 1);
        }
    }
}