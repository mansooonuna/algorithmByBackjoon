import java.util.*;

class Solution {
static List<Integer> sumList = new ArrayList<>();

    public int solution(int[] nums) {
        int answer = 0;
        // 합을 저장할 배열
        boolean[] b = new boolean[nums.length];
        // 3개의 숫자를 중복 없이 선택 후 sum에 합함
        combination(nums, b, 0, nums.length, 3);

        // sum 체크 -> 소수? count++;
        for (int sum : sumList) {
            answer += isPrime(sum);
        }

        return answer;
    }

    public static void combination(int[] nums, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            print(nums, visited, n);
            return;
        }
        if (depth == n) {
            return;
        }
        visited[depth] = true;
        combination(nums, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(nums, visited, depth + 1, n, r);
    }


    public static void print(int[] nums, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += nums[i];
            }
        }
        sumList.add(sum);
    }

    public static int isPrime(int n) {
        if (n < 2) {
            return 0;
        }

        if ( n == 2) {
            return 1;
        }

        for (int i = 2; i < n ; i++) {
            if ( n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}