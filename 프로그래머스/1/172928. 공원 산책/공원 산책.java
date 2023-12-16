import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int w = park.length;
        int h = park[0].length();

        int startX = 0;
        int startY = 0;

        char[][] arr = new char[w][h];

        for (int i = 0; i < w; i++) {
            arr[i] = park[i].toCharArray();

            if (park[i].contains("S")) {
                startX = park[i].indexOf("S");
                startY = i;
            }
        }

        for (String route : routes) {
            String way = route.split(" ")[0];
            int len = Integer.parseInt(route.split(" ")[1]);

            int nx = startX;
            int ny = startY;

            for (int i = 0; i < len; i++) {
                switch (way) {
                    case "E":
                        nx++;
                        break;
                    case "W":
                        nx--;
                        break;
                    case "S":
                        ny++;
                        break;
                    case "N":
                        ny--;
                        break;
                }

                if (nx >= 0 && ny >= 0 && ny < arr.length && nx < arr[0].length) {
                    if (arr[ny][nx] == 'X') {
                        break;
                    }
                    // 범위내 & 장애물 x
                    if (i == len - 1) {
                        startX = nx;
                        startY = ny;
                    }
                }
            }
        }

        int[] answer = {startY, startX};
        return answer;
    }
}