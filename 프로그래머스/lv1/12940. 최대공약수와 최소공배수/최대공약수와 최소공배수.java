class Solution {
     public int[] solution(int n, int m) {
        int x = gcd(n, m);
        int[] answer = {x, (n * m) / x};
        return answer;
    }

    static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return (x);
    }
}