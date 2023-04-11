import java.util.*;
import java.util.stream.Collectors;

class Solution {
  public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length ; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        int[] answer = new int[set.size()];
        int idx = 0;
        for(Integer num : set) {
            answer[idx++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }
}