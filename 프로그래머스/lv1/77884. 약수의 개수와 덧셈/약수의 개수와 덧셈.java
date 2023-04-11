class Solution {
     public int solution(int left, int right) {
        int[] arr = new int[right - left + 1];
        int idx = 0;
        for (int i = left; i <= right; i++) {
            arr[idx++] = i;
        }


        int answer = 0;
        for (int num : arr) {
            int count =0;
            for (int i = 1; i <= num; i++) {
                if ( num % i == 0) {
                    count ++;
                }
            }
            if (count % 2 == 0) {
                answer += num;
            } else if (count % 2 == 1) {
                answer -= num;
            }
        }

        return answer;
    }
}