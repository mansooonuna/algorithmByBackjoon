import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, budget;
    static int[] cost = new int[10];
    static ArrayList<Integer>[] dp = new ArrayList[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        budget = Integer.parseInt(br.readLine());

        for (int i = 0; i <= budget; i++) {
            dp[i] = new ArrayList<>();
        }

        for (int i = 1; i <= budget; i++) {
            for (int j = 0; j < n; j++) {
                if (i < cost[j]) continue;

                // 현재 숫자(j)를 구매한 경우의 방 번호를 계산
                ArrayList<Integer> temp = new ArrayList<>(dp[i - cost[j]]);
                Collections.sort(temp);
                temp.add(j);
                if (compare(i, temp, dp[i])) dp[i] = temp; // 현재 방 번호가 더 크면, dp 갱신
            }
            if (compare(i, dp[i - 1], dp[i])) dp[i] = dp[i - 1]; // 아무것도 사지 않은 경우와 비교
        }

        if (dp[budget].isEmpty()) dp[budget].add(0); // 불가능할 때, 0
        for (int i = dp[budget].size() - 1; i >= 0; i--)
            System.out.print(dp[budget].get(i)); // 예산으로 살 수 있는 최대 번호 출력
    }

    // 더 큰 숫자 비교 메서드
    static boolean compare(int b, ArrayList<Integer> first, ArrayList<Integer> second) {
        if (b == budget) {
            // 방 번호가 0으로만 구성된 것 제외
            if (first.size() > 0 && first.get(first.size() - 1) == 0) return false;
            if (second.size() > 0 && second.get(second.size() - 1) == 0) return true;
        }

        // 방 번호 길이 비교
        if (first.size() > second.size()) {
            return true;
        }
        if (first.size() < second.size()) {
            return false;
        }

        // 길이가 같으면 자릿수 비교
        int end = first.size() - 1;
        for (int i = end; i >= 0; i--) {
            if (first.get(i) > second.get(i)) return true;
            if (first.get(i) < second.get(i)) return false;
        }
        // 자릿수가까지 같으면 아무 방 번호나 반환
        return false;
    }
}


/*
dp[i] = i 원으로 살 수 있는 가장 높은 수

- 숫자를 많이 사는 것
- 높은 숫자를 사는 것
 */