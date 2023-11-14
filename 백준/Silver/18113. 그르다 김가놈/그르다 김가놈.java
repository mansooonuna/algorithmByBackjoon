import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 김밥 개수
        int K = Integer.parseInt(st.nextToken()); // 꼬다리 길이
        int M = Integer.parseInt(st.nextToken()); // 김밥 조각 최소 개수

        int[] kimBob = new int[N];
        for (int i = 0; i < N; i++) {
            kimBob[i] = Integer.parseInt(br.readLine());
            if (kimBob[i] >= 2 * K) {
                kimBob[i] -= 2 * K;
            } else if (kimBob[i] >= K && kimBob[i] < 2 * K) {
                kimBob[i] -= K;
            } else {
                kimBob[i] = 0; // 폐기
            }
        }

        Arrays.sort(kimBob);

        int start = 1;
        int end = kimBob[N - 1];

        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int piece = 0;
            for (int i : kimBob) {
                piece += i / mid;
            }

            if (piece < M) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }

        if (answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }


}

/*
꼬다리 : 6
최소 조각 : 4
20 -> -12 = 8
10 -> -6 = 4
3 (폐기)

4 -> 3조각
3 -> 3조각
2 -> 5조각 >= 4

P : 2
 */