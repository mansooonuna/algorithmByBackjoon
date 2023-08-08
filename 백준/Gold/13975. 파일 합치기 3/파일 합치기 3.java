import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<Long> file = new PriorityQueue<>(K);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                file.add(Long.parseLong(st.nextToken()));
            }

            long total = 0;
            while (file.size() > 1) {
                long tmp = file.poll() + file.poll();
                total += tmp;
                file.offer(tmp);
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}