import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            if (map.get(calling) > 0) {
                int idx = map.get(calling);

                String tmp = players[idx - 1];
                players[idx - 1] = players[idx];
                players[idx] = tmp;

                map.put(players[idx], idx);
                map.put(players[idx - 1], idx - 1);
            }
        }

        return players;
    }
}