import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M; // 가로
    static int N; // 세로

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우위아래
    static int[] dy = {0, 0, -1, 1}; // 상하좌우위아래

    static int[][] tomatoBox; // 토마토 판

    static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoBox = new int[N][M]; // 토마토판

        queue = new LinkedList<Tomato>();

        // 토마토판 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st2.nextToken());
                // 익은 토마토 큐에 넣기
                if (tomatoBox[i][j] == 1)
                    queue.add(new Tomato(i, j));
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            int x = tomato.x; // 세로
            int y = tomato.y; // 가로

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 세로
                int ny = y + dy[i]; // 가로

                // 상하좌우 범위 안에서
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 토마토가 안익었으면
                    if (tomatoBox[nx][ny] == 0) {
                        // 익은 토마토 추가
                        queue.add(new Tomato(nx, ny));

                        // 익은 날짜를 얻기 위해 이전 값에서 1 증가
                        tomatoBox[nx][ny] = tomatoBox[x][y] + 1;
                    }
                }
            }
        }

        // 최대 날짜
        int days = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 토마토가 익지 않았다면
                if (tomatoBox[i][j] == 0)
                    return -1;

                // 날짜 최댓값 구하기
                days = Math.max(days, tomatoBox[i][j]);
            }
        }

        // 토마토가 모두 익은 상태인 경우
        if (days == 1) return 0;
            // 걸린 일수는 최대 날짜에서 1을 빼줘야 함
        else return days - 1;
    }
}

class Tomato {
    int x;
    int y;

    Tomato(int x, int y) {
        this.x = x; // 세로
        this.y = y; // 가로
    }
}