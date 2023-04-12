import java.util.*;

class Solution {
   public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length/2;      // 가져갈 수 있는 폰켓몬의 수

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);           // 중복이 제거된 nums 배열 생성
        }

        if ( set.size() <= N) {      // 내가 가져갈 수 있는 숫자가 더 많으면 그냥 set의 size 반환
            answer = set.size();
        } else {
            answer = N;
        }
        
        return answer;
    }
}