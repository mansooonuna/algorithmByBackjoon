import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수학
 * 구현
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int x = 0, y = 0;
        for (int i = 2; i >= 0; i--) {
            x += (a.charAt(i) - '0')  * Math.pow(10, i);
            y += (b.charAt(i) - '0') * Math.pow(10, i);
        }
        System.out.println(Math.max(x, y));
    }
}