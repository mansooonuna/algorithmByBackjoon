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
        int B = Integer.parseInt(st.nextToken());

        int[] ground = new int[N * M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i * M + j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 땅의 높이가 될 수 있는 범위는 ground[0] ~ ground[N*M]
        Arrays.sort(ground);
        int minHeight = ground[0];
        int maxHeight = ground[N * M - 1];

        int minTime = Integer.MAX_VALUE;
        int optimalHeight = 0;

        for (int height = minHeight; height <= maxHeight; height++) {
            int inventory = B;
            int time = 0;
            for (int currentHeight : ground) {
                if (currentHeight < height) { // 블록 추가(인벤토리 -1), 시간 +1
                    inventory -= (height - currentHeight);
                    time += (height - currentHeight);
                } else if (currentHeight > height) { // 블록 제거(인벤토리 +1), 시간 +2
                    inventory += (currentHeight - height);
                    time += (currentHeight - height) * 2;
                }
            }

            if (inventory >= 0 && time <= minTime) {
                minTime = time;
                optimalHeight = height;
            }
        }

        System.out.println(minTime + " " + optimalHeight);
    }
}