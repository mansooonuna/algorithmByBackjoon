import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘 : 매 순간 최적이라고 생각되는 해답을 찾음
 * k개 로프
 * 최대 중량 = 작은 로프의 힘 * 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 주어진 중량 정렬
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        /**
         * 최대 중량을 찾아야하므로 가장 큰 로프의 중량을 먼저 비교
         * 그 다음으로 내려가면서 최대 중량이 있으면 max 교체
         */
        int max = 0;
        for (int i = N - 1; i >= 0; i--) {
            int w = nums[i] * (N - i);
            if ( w > max) {
                max = w;
            }
        }

        System.out.println(max);

    }
}