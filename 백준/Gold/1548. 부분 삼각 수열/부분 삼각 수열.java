import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘
 * 브루트포스 알고리즘
 * 정렬
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if (N > 2) {
            int result = 2;
            for (int start = 0; start < N - 2; start++) {
                int end = start + 2;
                while (true) {
                    // 작은 수 + 다음으로 작은 수 > 가장 큰 수
                    if (arr[start] + arr[start + 1] > arr[end]) {
                        result = Math.max(result, end - start + 1);
                        end++;
                        if (end == N) break;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(result);
        } else {
            System.out.println(N);
        }
    }
}