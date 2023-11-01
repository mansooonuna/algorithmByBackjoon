import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] q = new int[]{a, b};
            dp[i][q[0] - 1] += 1; // 각 학생이 받은 그레이드에 따라 dp 배열에 누적
            dp[i][q[1] - 1] += 1;
        }

        List<int[]> answer = new ArrayList<>();
        // 그레이드 1부터 5까지 반복
        for (int i = 0; i < 5; i++) {
            // sum은 현재 그레이드의 학생 수, ans는 최대 학생 수
            int sum = 0, ans = 0;

            for (int j = 0; j < N; j++) {
                int next = dp[j][i] > 0 ? 1 : 0; // 현재 학생이 해당 그레이드를 받았는지 여부
                if (next == 0) {
                    // 이전까지의 학생 수를 초기화
                    sum = 0;
                } else {
                    // 현재 학생을 더함
                    sum += next;
                }
                ans = Math.max(ans, sum); // 최대 학생 수 업데이트
            }
            answer.add(new int[]{i + 1, ans}); // 그레이드 정보와 최대 학생 수 저장
        }

        answer.sort((a, b) -> {
            // 최대 학생 수로 내림차순 정렬, 그레이드로 오름차순 정렬
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        System.out.println(answer.get(0)[1] + " " + answer.get(0)[0]); // 결과 출력
    }
}
/**
 * 연속된 책상의 같은 그레이드를 가진 학생 수
 */