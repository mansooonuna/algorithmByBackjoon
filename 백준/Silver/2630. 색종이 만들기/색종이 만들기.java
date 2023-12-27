import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int white = 0;
    static int blue = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 전체 종이의 한 변 길이
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);

        System.out.println(white + "\n" + blue);
    }

    private static void cut(int row, int col, int size) {
        if (isSameColor(row, col, size)) { // 모든 색이 같다면
            if (map[row][col] == 0) { // 흰색 종이라면
                white++;
            } else { // 파란색 종이라면
                blue++;
            }
        } else { // 같은 색이 아니라면
            int newSize = size / 2; // 크기를 반으로 줄인다
            // 4등분하여 재귀 호출
            cut(row, col, newSize);
            cut(row, col + newSize, newSize);
            cut(row + newSize, col, newSize);
            cut(row + newSize, col + newSize, newSize);
        }
    }

    private static boolean isSameColor(int row, int col, int size) {
        int color = map[row][col]; // 첫 번째 색
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != color) { // 다른 색이 발견되면 false 반환
                    return false;
                }
            }
        }
        return true; // 모든 색이 같다면 true 반환
    }
}