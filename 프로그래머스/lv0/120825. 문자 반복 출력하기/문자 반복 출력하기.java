class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        char[] c = new char[my_string.length()];

        for (int i = 0; i < my_string.length(); i++) {
            c[i] = my_string.charAt(i);
        }

        for (int i = 0; i < my_string.length() ; i++) {
            for (int j = 0; j < n; j++) {
                answer += c[i];
            }
        }

        return answer;
    }
}