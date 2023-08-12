import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구현
 * 그리디 알고리즘
 * 문자열
 * 브루트포스 알고리즘
 */
public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        int hammingDistance = 0;
        for (int i = 0; i < M; i++) {
            int[] tmp = new int[4];
            for (int j = 0; j < N; j++) {
                char ch = strings[j].charAt(i);
                if (ch == 'A') tmp[0]++;
                if (ch == 'C') tmp[1]++;
                if (ch == 'G') tmp[2]++;
                if (ch == 'T') tmp[3]++;
            }
            int max = 0;
            int idx = 0;
            for (int j = 0; j < 4; j++) {
                if (tmp[j] > max) {
                    max = tmp[j];
                    idx = j;
                }
            }

            if (idx == 0) sb.append('A');
            if (idx == 1) sb.append('C');
            if (idx == 2) sb.append('G');
            if (idx == 3) sb.append('T');
            hammingDistance += N - max;
        }
        sb.append("\n").append(hammingDistance);

        System.out.println(sb);
    }
}