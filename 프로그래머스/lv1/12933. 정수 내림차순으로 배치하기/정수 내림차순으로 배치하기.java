import java.util.*;

class Solution {
 public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);  //118372
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0'; // 1 1 8 3 7 2
            arr[i] = num;
        }
        Arrays.sort(arr); // 1 1 2 3 7 8

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] * (Math.pow(10, i));
        }

        return answer;
    }
}