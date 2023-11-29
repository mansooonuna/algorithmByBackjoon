import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        String pre = phone_book[0];
        
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(pre)) answer = false;
            pre = phone_book[i];
        }
        
        return answer;
    }
}