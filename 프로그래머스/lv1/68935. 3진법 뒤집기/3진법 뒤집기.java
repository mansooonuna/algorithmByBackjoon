class Solution {
     public int solution(int n) {
        String changeThree = "";
        while (n > 0) {
            changeThree += String.valueOf(n % 3);
            n /=3 ;
        }
        int answer = Integer.parseInt(changeThree, 3);
        return answer;
    }
}