class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] arr = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < arr.length; i++) {
            answer = my_string.replace(String.valueOf(arr[i]), "");
            my_string = answer;
        }

        return answer;
    }
}