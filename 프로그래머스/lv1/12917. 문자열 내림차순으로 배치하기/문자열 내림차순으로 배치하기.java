import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        String[] str = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            str[i] = String.valueOf(s.charAt(i)); //  Z b c d e f g
        }
        Arrays.sort(str, Collections.reverseOrder());
        for (String i : str) {
            sb.append(i);
        }
        answer = sb.toString();
        return answer;
    }
}