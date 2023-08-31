import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구현
 * 그래프 이론
 * 그래프 탐색
 * 시뮬레이션
 * 너비 우선 탐색
 */
public class Main {
    static int N, M;
    static int[][] cheeseMap;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheeseMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheeseMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;
        int remainCheese = 0;
        int rs =0;
        while (true) {
            remainCheese = countCheese();
            // 남아있는 치즈 없으면 탈출
            if (remainCheese == 0) break;
            // 시간 지나면서 치즈 녹이기
            rs = meltCheese();
            hour++;
        }
        System.out.println(hour + "\n" + rs);
    }

    private static int countCheese() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheeseMap[i][j] == 1) count++;
            }
        }
        return count;
    }

    private static int meltCheese() {
        int count = 0;
        isVisited = new boolean[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0}); // (0,0) 부터 순회
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                // 상하좌우 범위 내에 있고 방문안했으면
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;

                    // 치즈가 있으면 녹이기
                    if (cheeseMap[nx][ny] == 1) {
                        count++;
                        cheeseMap[nx][ny] = 0;
                    }
                    // 치즈 없으면 queue에 현재 위치 삽입
                    else {
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return count;
    }
}