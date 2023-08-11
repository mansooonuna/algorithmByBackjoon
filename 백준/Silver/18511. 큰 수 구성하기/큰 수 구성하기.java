import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 브루트포스 알고리즘
 * 재귀
 */
public class Main {
    static int N;
    static int K;
    static int ans;
    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        nums = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            nums.add(Integer.parseInt(st2.nextToken()));
        }

        nums.sort(Collections.reverseOrder());
        dfs(0);
        System.out.println(ans);
    }

    // 0부터 시작하여 K의 원소들 중 큰 걸 넣어가면서 비교
    // now 가 입력 값 N보다 크면 return, 작으면 비교 후 최대값 갱신
    private static void dfs(int now) {
        if (now > N) return;
        if (ans < now) ans = now;

        for (int i = 0; i < K; i++) {
            dfs(now * 10 + nums.get(i));
        }
    }
}