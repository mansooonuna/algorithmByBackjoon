import java.util.*;

class Solution {
  public Integer[] solution(long n) {
        String str = String.valueOf(n); // 12345
        Integer[] arr = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0'; //1 2 3 4 5
            arr[i] = num;
        }

        List<Integer> list = Arrays.asList(arr);
        Collections.reverse(list);
        Integer[] answer = list.toArray(arr);

        return answer;
    }
}