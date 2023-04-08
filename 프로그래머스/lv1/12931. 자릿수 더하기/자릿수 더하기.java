import java.util.*;

public class Solution {
   public int solution(int n) {
        int answer = 0;
        String strNum = String.valueOf(n);              // "123" 문자형 타입으로 변환
        for (int i = 0; i < strNum.length(); i++) {
            int num = strNum.charAt(i) - '0';                 // String -> char 변환하여 한 자리씩 구분
            answer += num;
        }
        return answer;
    }
}