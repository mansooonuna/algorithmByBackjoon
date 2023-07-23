class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        // 최소공배수(LCM) 구하기
        int lcm = getLCM(denom1, denom2);

        // 각 분자에 곱해줄 계수 구하기
        int coef1 = lcm / denom1;
        int coef2 = lcm / denom2;

        // 분모를 LCM으로 통일하고 두 분자를 더한다
        int newNumer = numer1 * coef1 + numer2 * coef2;

        // 분자와 분모의 최대공약수(GCD)를 구한 후 간소화
        int gcd = getGCD(newNumer, lcm);
        answer[0] = newNumer / gcd;
        answer[1] = lcm / gcd;

        return answer;
    }

    // 최대공약수(GCD) 구하는 메서드
    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    // 최소공배수(LCM) 구하는 메서드
    private int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }
}
