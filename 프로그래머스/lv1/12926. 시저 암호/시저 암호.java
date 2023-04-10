class Solution {
 public String solution(String s, int n) {
        StringBuilder sb= new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);             // A B

            if ( c == ' ') {
                sb.append(' ');
                continue;
            }
            
            if ( Character.isLowerCase(c)) {        // 소문자일경우
                c = (char) ((c - 'a' + n) % 26 + 'a');
            } else {
                c = (char) ((c - 'A' + n) % 26 + 'A'); // 대문자일경우
            }
            sb.append(c);
        }

        return sb.toString();
    }
}