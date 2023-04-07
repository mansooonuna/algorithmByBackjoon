class Solution {
   public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0) { //글자길이 짝수
            answer = s.substring((s.length() / 2-1), (s.length() / 2 +1));
        } else if (s.length() % 2 == 1) { // 글자길이 홀수
            answer = String.valueOf(s.charAt((s.length() / 2)));
        }
        return answer;
    }
}