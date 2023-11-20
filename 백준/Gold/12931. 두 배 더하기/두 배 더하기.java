import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        while (!isZero(B)) {
            int num = 0; // 1번 연산 수행 횟수 기록
            for (int i = 0; i < N; i++) {
                if (B[i] % 2 != 0) {
                    B[i]--;
                    num++;
                }
            }

            if (num > 0) {
                // 홀수 연산 합
                answer += num;
            } else {
                // 짝수의 경우
                for (int i = 0; i < N; i++) {
                    B[i] /= 2;
                }
                answer++;
            }
        }
        System.out.print(answer);
    }


    public static boolean isZero(int[] arr) {
        for (int value : arr) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}

/*
짝수 ? /2
홀수 ? -1
 */