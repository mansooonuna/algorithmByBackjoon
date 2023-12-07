import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int ans = input.length();

        for (int i = 0; i < input.length(); i++) {
            if (isPalindrome(input.substring(i))) break;

            ans++;
        }
        System.out.println(ans);
    }

    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) return false;

            start++;
            end--;
        }
        return true;
    }
}


/*
주어진 문자열에서, "_ _ _ _ _ aaa" 펠린드롬을 발견한 순간, 
대칭이 되도록 오른쪽에 발견한 펠린드롬 왼쪽의 글자수만큼 붙는다고 생각하면 쉽다. 
"_ _ _ _ _ aaa _ _ _ _ _ "
 */