import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long start = 1;
        long finish = S;
        long ans = 0;

        while (start <= finish) {
            // 등차수열 합 공식 사용하여 중앙값까지의 합
            long mid = (start + finish) / 2;            
            long sum = mid * (mid + 1) / 2;

            // 중앙값까지의 합이 S보다 작거나 같으면 시작점은 중앙값 + 1로 업데이트
            if (sum <= S) {
                ans = mid;
                start = mid + 1;
            } else {
                // 합이 S보다 크면 종료지점을 중앙값 -1로 업데이트
                finish = mid - 1;
            }
        }
        System.out.println(ans);
    }
}