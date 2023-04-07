class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;                       // 필요한 금액
        for (int i = 1; i <= count; i++) {
            sum += price * i;
        }
        if (sum <= money) {
            answer = 0;
        } else {
            answer = sum - money;
        }
        return answer;
    }
}
