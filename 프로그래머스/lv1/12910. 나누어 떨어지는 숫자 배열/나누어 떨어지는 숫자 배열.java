import java.util.*;

class Solution {
  public List<Integer> solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer.add(arr[i]);
            }
        }
        if (answer.isEmpty()) {
            return Collections.singletonList(-1);
        }
        return answer;
    }
}