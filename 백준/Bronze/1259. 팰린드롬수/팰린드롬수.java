import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0이 나올때까지 입력 받음
        while (true) {
            String str = br.readLine();

            // 팰린드롬인지 체크하기 위한 변수
            boolean ck = true;

            // 입력값이 0이면 while문 탈출
            if (str.equals("0")) break;

            // 입력값 길이의 절반만큼 순회
            for (int i = 0; i < str.length() / 2; i++) {
                // 입력값의 앞의 숫자가 뒤의 숫자와 다르면 팰린드롬이 아님 -> false
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    ck = false;
                }
            }

            // ck 변수가 true 면 팰린드롬임
            if (ck) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }


    }
}