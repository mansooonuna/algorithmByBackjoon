import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int ans = 0;
        for (String str : strs) {
            if (!str.equals("")) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}