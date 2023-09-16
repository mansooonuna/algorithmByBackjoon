import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            sb.append(isPalindrome(input)).append(" ").append(cnt);
            sb.append("\n");
            cnt = 0;
        }
        System.out.println(sb);
    }

    private static int isPalindrome(String input) {
        return recursion(input, 0, input.length() - 1);
    }

    private static int recursion(String input, int l, int r) {
        cnt++;
        if (l >= r) return 1;
        else if (input.charAt(l) != input.charAt(r)) return 0;
        else return recursion(input, l + 1, r - 1);
    }
}