import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;

        // 동전 받을 배열
        int[] coin = new int[N];

        // 동전 배열 입력받아 채움
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = coin.length-1; i >= 0; i--) {
            if ( coin[i] <= K ) {
                result += K / coin[i]; // 4200원 / 1000원 몫을 result에 더해주고
                K = K % coin[i]; // 나머지값을 K로 변경 후 반복
            }
        }

        System.out.println(result);
    }
}