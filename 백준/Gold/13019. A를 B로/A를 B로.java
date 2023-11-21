import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pre = br.readLine();
        String after = br.readLine();

        int cnt = 0; // 바꿔야하는 문자 갯수
        int j = pre.length() - 1;
        for (int i = pre.length() - 1; i >= 0 ; i--) {
            if (after.charAt(j) != pre.charAt(i)) cnt++;
            else j--;
        }

        // 문자열 정렬해봐서 같은지 비교
        char[] preArr = pre.toCharArray();
        char[] afterArr = after.toCharArray();
        Arrays.sort(preArr);
        Arrays.sort(afterArr);

        pre = new String(preArr);
        after = new String(afterArr);

        if (pre.equals(after)) System.out.println(cnt);
        else System.out.println(-1);
    }
}