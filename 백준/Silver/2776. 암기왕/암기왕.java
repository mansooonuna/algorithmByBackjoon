import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());         // 1
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());     // 5

            Set<Integer> note1 = new HashSet<>();        // [4 1 5 2 3]
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());         // 5
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());  // 1 3 7 9 5

                if (note1.contains(num)) bw.write(1 + " ");
                else bw.write(0 + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}