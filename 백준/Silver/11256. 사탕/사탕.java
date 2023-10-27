import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
            StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken()); // 사탕 개수
            int N = Integer.parseInt(st.nextToken()); // 상자 개수

            Integer[] canPackage = new Integer[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int iRow = Integer.parseInt(st.nextToken()); // 상자 세로 길이
                int iCol = Integer.parseInt(st.nextToken()); // 상자 가로 길이

                canPackage[i] = iRow * iCol;
            }

            Arrays.sort(canPackage, Comparator.reverseOrder());

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                J -= canPackage[i];
                cnt++;

                if (J <= 0) {
                    break;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}

/*
각 상자 마다 최대 사탕 개수
3 4 = 12 (o)
2 5 = 10 (o)
1 8 = 8
3 3 = 9
2 5 = 10
 */