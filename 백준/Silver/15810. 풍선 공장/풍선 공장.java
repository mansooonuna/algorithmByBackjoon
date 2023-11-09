import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 스태프 수
        int M = Integer.parseInt(st.nextToken()); // 풍선 개수

        int[] times = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, times[i]);
        }

        long left = 0;
        long right = (long) max * M; // 제일 오래 걸리는 시간 * 필요한 풍선 개수

        long rs = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long total = 0;
            for (int i = 0; i < N; i++) {
                total += mid / times[i];
            }

            if (total >= M) {
                rs = mid;
                right = mid - 1;
            } else left = mid + 1;
        }

        System.out.println(rs);
    }
}

/*
  1 2 3 4 5 6 7 8 9 10 11 12 13 (14) 15
5         1         2                3
7             1                  2
3     1     2     3       4          5

최대 시간 1_000_000 * 1_000_000 > int
그래서 long으로 선언
 */