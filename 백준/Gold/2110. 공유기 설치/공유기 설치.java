import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이분 탐색
 * 매개 변수 탐색
 */
public class Main {
    static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int min = 1; // 최소 거리를 1로 초기화
        int max = home[N - 1] - home[0];

        while (min <= max) { // min과 max가 같을 때까지 반복
            int mid = (min + max) / 2;
            if (count(mid) < C) max = mid - 1;
            else min = mid + 1;
        }

        System.out.println(max);
    }

    public static int count(int x) {
        // 1번 집 설치
        int cnt = 1;
        int last = home[0];

        for (int i = 1; i < home.length; i++) {
            int cur = home[i];

            if (cur - last >= x) {
                cnt++;
                last = cur;
            }
        }
        return cnt;
    }
}