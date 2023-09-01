import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열
 * 브루트포스 알고리즘
 * 재귀
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(recursive(S, T));
    }

    static int recursive(String S, String T) {
        if (S.equals(T)) return 1;

        // 임시 글자수 넣을 변수
        int strNum = 0;
     
        // A로 끝났으면 마지막 글자 A 제외
        if (T.endsWith("A")) {
            strNum += recursive(S, T.substring(0, T.length() - 1));
        }
     
        // B로 시작하면 B 제외하고 뒤집기 반복
        if (T.startsWith("B")) {
            String tmp = T.substring(1);
            StringBuilder sb = new StringBuilder(tmp);
            String str = sb.reverse().toString();
            strNum += recursive(S, str);
        }

        // 임시 글자수가 0보다 크면 변환이 가능하다는 뜻
        return strNum > 0 ? 1 : 0;
    }
}