import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int start = Integer.MAX_VALUE; // 최소 레벨부터

        int[] level = new int[N];
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(br.readLine());
            start = Math.min(start, level[i]);
        }

        int end = start + K; // 최소 레벨 + K 까지

        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;
 
                for (int lv : level) {
                    if (lv < mid) total += mid - lv;
                }
    

            if (total > K) end = mid - 1;
            else start = mid + 1;
        }

        System.out.println(end);
    }
}

/*
K = 10 이하
10 20 15
7     2
=> 17
 */