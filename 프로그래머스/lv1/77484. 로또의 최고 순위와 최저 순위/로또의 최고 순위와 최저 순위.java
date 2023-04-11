class Solution {
public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;                          //2개 당첨
        int noCount = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                noCount++;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    count++;
                }
            }
        }

        int topCount = count + noCount; // 4개 당첨
       
        int rank = getRank(topCount);
        int rank2 = getRank(count);
        
        int[] answer = {rank, rank2};
        return answer;
    }

    static int getRank(int count) {
        int rank = 0;
        if (count == 6) {
            rank = 1;
        } else if (count == 5) {
            rank = 2;
        } else if (count == 4) {
            rank = 3;
        } else if (count == 3) {
            rank = 4;
        } else if (count == 2) {
            rank = 5;
        } else {
            rank = 6;
        }
        return rank;
    }
}