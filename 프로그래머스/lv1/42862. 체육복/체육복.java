import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 일단 체육복 다 가지고 있다. 1 1 1 1 1
        int[] hasTraining = new int[n];
        for (int i = 0; i < hasTraining.length; i++) {
            hasTraining[i] = 1;
        }

        // 체육복 도난 당한 애들은 값 : 0      1 0 1 0 1
        for (int i = 0; i < lost.length; i++) {
            hasTraining[lost[i] - 1] = 0;
        }

        // 여벌 체육복 있는 애들 + 1            2 0 2 0 2
        for (int i = 0; i < reserve.length; i++) {
            hasTraining[reserve[i] - 1]++;
        }

        for (int i = 0; i < hasTraining.length; i++) {
            // 체육복이 없음 ? 앞 뒤 비교 2보다 크면 빌려오고 1씩 감소
            if (hasTraining[i] == 0) {
                if (i > 0 && hasTraining[i - 1] >= 2) {
                    hasTraining[i]++;
                    hasTraining[i - 1]--;
                } else if (i < hasTraining.length - 1 && hasTraining[i + 1] >= 2) {
                    hasTraining[i]++;
                    hasTraining[i + 1]--;
                }
            }
        }
        // 배열의 값이 0이 아닌 것 counting
        for (int num : hasTraining) {
            if (num != 0) {
                answer++;
            }
        }

        return answer;
    }
}
