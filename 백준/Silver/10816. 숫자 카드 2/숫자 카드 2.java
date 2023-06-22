import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            int question = Integer.parseInt(st2.nextToken());
            ans[i] = cardCount.getOrDefault(question, 0);
        }

        for (int num : ans) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();
    }
}