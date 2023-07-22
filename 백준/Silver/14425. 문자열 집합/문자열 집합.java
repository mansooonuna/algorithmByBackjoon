import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (String s : S) {
                if (input.equals(s)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}