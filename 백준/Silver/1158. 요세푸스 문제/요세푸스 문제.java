import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    // 7
        int K = Integer.parseInt(st.nextToken());    // 3

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);                 // q [1 2 3 4 5 6 7]
        }
        bw.write("<");

        while (!q.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if ( i == K - 1) {
                    if ( q.size() !=1 ) {
                        bw.write(q.poll() + ", ");
                    } else {
                        bw.write(q.poll() + ">");
                    }
                } else {
                    q.offer(q.poll());
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}