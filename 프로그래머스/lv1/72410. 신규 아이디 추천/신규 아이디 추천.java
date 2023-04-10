import java.util.regex.*;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        // 1. 소문자로 변경
        new_id = new_id.toLowerCase();

        // 2. 특정 특수문자 제거
        Pattern p = Pattern.compile("[a-z0-9-_.]");
        Matcher m = p.matcher(new_id);

        while (m.find()) {
            sb.append(m.group());
        }

        // 3. 마침표가 2번 이상 연속된 부분 하나로 변경
        answer = sb.toString().replaceAll("\\.{2,}", ".");

        // 4. 마침표는 처음과 끝에 올 수 없다.
        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }

        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length()-1);
        }

        // 5. 빈 문자열일 경우 "a" 대입
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6. 길이가 16자 이상일 경우 첫 15자만 남기고 제거
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.endsWith(".")) {
                answer = answer.substring(0, answer.length()-1);
            }
        }

        // 7. 길이가 2자 이하일 경우 마지막 문자를 길이가 3이 될 때까지 반복
        while (answer.length() <= 2) {
            answer += answer.charAt(answer.length()-1);
        }

        return answer;
    }
}
