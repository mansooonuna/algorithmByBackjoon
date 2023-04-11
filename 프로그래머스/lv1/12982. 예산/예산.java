import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d); 
        int count = 0; 
        int sum = 0;

        for (int i = 0; i < d.length; i++) {
            sum += d[i]; 
            if (sum <= budget) {
                count++; 
            } else {
                break; 
            }
        }

        return count;
    }
}