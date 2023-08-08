import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> file = new PriorityQueue<>(N);
        for (int i = 0; i < N; i++) {
            file.add(Long.parseLong(br.readLine()));
        }

        long total = 0;
        while (file.size() > 1) {
            long tmp = file.poll() + file.poll();
            total += tmp;
            file.offer(tmp);
        }
        sb.append(total).append("\n");

        System.out.println(sb);
    }
}