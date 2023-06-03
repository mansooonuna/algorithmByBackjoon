import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            for (int j = 0; j < S.length(); j++) {
                char c = S.charAt(j);
                sb.append(String.valueOf(c).repeat(Math.max(0, R)));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}