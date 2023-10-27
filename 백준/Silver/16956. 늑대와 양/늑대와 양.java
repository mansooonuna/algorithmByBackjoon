import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int isProtected = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] map = new String[R][C];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];
                if (map[i][j].equals("W")) queue.add(new int[]{i, j});
            }
        }

        isProtected = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (map[nx][ny].equals("S")) {
                        isProtected = 0;
                        break;
                    } else if (map[nx][ny].equals(".")) {
                        map[nx][ny] = "D";
                    }
                }
            }

        }
        sb.append(isProtected).append("\n");

        if (isProtected == 1) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}

/**
 * 1. 늑대 - 양 바로 옆이면 양을 지킬 수 없음 -> 0
 * 2. 늑대 - 양 사이 한 칸 이상 있으면 울타리 가능 -> 1
 */