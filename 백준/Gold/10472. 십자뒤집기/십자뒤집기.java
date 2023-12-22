import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[][] map = new char[3][3];

            for (int i = 0; i < 3; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < 3; j++) {
                    map[i][j] = input[j];
                }
            }

            sb.append(dfs(0, 0, map)).append("\n"); // DFS를 통해 최소 클릭 횟수를 찾고 출력
        }
        System.out.println(sb);
    }

    private static int dfs(int y, int x, char[][] map) {
        int rs = 987654321; // 결과값을 최대값으로 초기화

        if (y == 3) { // 모든 위치를 검사했을 때
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[i][j] == '*') return 987654321; // 아직 '*'이 남아있다면 불가능하므로 최대값을 반환
                }
            }
            return 0; // 모든 '*'를 '.'으로 바꿨다면 0을 반환
        }

        int nextX = x + 1; // 다음 위치를 설정
        int nextY = y;
        if (nextX >= 3) { // 한 줄을 모두 검사했으면 다음 줄로 넘어감
            nextX = 0;
            nextY = y + 1;
        }

        rs = Math.min(rs, dfs(nextY, nextX, map)); // 클릭하지 않고 넘어가는 경우를 검사

        int[] dx = {0, 0, 1, 0, -1}; // 클릭했을 때 영향을 받는 위치
        int[] dy = {0, -1, 0, 1, 0};

        for (int i = 0; i < 5; i++) { // 클릭했을 때
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 게임판 내에 있고, '*'이면 '.'으로, '.'이면 '*'으로 flip
            if (ny >= 0 && ny < 3 && nx >= 0 && nx < 3) {
                if (map[ny][nx] == '*') map[ny][nx] = '.';
                else map[ny][nx] = '*';
            }
        }
        rs = Math.min(rs, dfs(nextY, nextX, map) + 1); // 클릭하고 넘어가는 경우를 검사

        // DFS가 끝나고 원상태로 복구
        for (int k = 0; k < 5; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (ny >= 0 && ny < 3 && nx >= 0 && nx < 3) {
                if (map[ny][nx] == '*') {
                    map[ny][nx] = '.';
                } else {
                    map[ny][nx] = '*';
                }
            }
        }
        return rs; // 최소 클릭 횟수를 반환
    }
}