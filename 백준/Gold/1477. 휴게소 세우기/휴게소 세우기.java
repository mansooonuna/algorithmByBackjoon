import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] locations = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            locations[i] = Integer.parseInt(st.nextToken());
        }

        locations[0] = 0;
        locations[N + 1] = L;

        Arrays.sort(locations);

        int left = 1, right = L - 1;
        while (left <= right) {
            int mid = (left + right) / 2; // 현재 구간의 길이
            int cnt = 0; // 추가 휴게소 갯수

            for (int i = 1; i <= N + 1 ; i++) {
                int dist = locations[i] - locations[i - 1] - 1; // 인접한 휴게소 사이의 거리
                cnt += dist / mid;
            }

            // 휴게소가 필요한 것보다 많으면, mid를 증가시켜 필요한 휴게소 줄임
            if (cnt > M) left = mid + 1;
            // 적으면, mid를 감소시켜 필요한 휴게소 늘림
            else right = mid - 1;
        }

        // 휴게소 M개 더 지었을때, 휴게소가 없는 구간의 최댓값의 최소는 left
        System.out.println(left);
    }
}