class Solution {
    public String solution(String my_string) {
         String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isLowerCase(c)) answer += Character.toUpperCase(c);
            else if (Character.isUpperCase(c)) answer += Character.toLowerCase(c);
        }
        return answer;
    }
}
