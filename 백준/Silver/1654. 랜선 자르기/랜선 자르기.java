import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> lan = new ArrayList<>();
        for (int i = 0; i < K; i++) lan.add(Integer.parseInt(br.readLine()));

        Collections.sort(lan);

        long start = 1;
        long finish = lan.get(K - 1);

        while (start <= finish) {
            long mid = (start + finish) / 2;
            long count = 0;

            for (Integer integer : lan) {
                count += integer / mid;
            }

            if ( count >= N) start = mid + 1;
            else finish = mid - 1;
        }
        System.out.println(finish);
    }
}