import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);                       // 1 2 3 4 5 6 7
        }

        while (q.size() != 1) {
            bw.write(q.peek() + " ");
            q.poll();
            q.offer(q.poll());
        }
        bw.write(q.peek() + "");

        bw.flush();
        bw.close();
        br.close();
    }
}