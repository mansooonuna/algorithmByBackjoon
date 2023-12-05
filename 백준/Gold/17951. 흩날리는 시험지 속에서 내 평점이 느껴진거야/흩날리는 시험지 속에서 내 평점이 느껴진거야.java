import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        long[] scores = new long[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Long.parseLong(secondLine[i]);
        }

        long left = 0;
        long right = 2000000000; // 10^5 * 20
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossible(scores, mid, K)) {
                // 가능하면, 더 높은 점수를 찾기 위해 범위를 오른쪽으로 이동
                left = mid + 1;
            } else {
                // 불가능하면, 더 낮은 점수를 찾기 위해 범위를 왼쪽으로 이동
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    // mid가 가능한 점수인지 확인 메서드
    static boolean isPossible(long[] scores, long mid, int K) {
        int count = 0; // 현재까지 만들 수 있는 그룹의 수
        long sum = 0; // 현재 그룹의 점수 합계
        for (long score : scores) {
            sum += score;

            // 현재 그룹의 점수 합계가 mid 이상이라면 새로운 그룹 만듬
            if (sum >= mid) {
                sum = 0;
                count++;
            }
        }
        // K그룹 이상이면 mid 는 가능
        return count >= K;
    }
}