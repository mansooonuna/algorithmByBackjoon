class Solution {
    public int[] solution(String[] wallpaper) {
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        
        int lux, luy;
        int rdx, rdy;
        
        lux = luy = Integer.MAX_VALUE;
        rdx = rdy = Integer.MIN_VALUE;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i); // 가장 위
                    luy = Math.min(luy, j); // 가장 왼쪽
                    rdx = Math.max(rdx, i); // 가장 아래
                    rdy = Math.max(rdy, j); // 가장 오른쪽에 있는 파일 위치 갱신
                }
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1}; // 드래그할때 마지막 위치 선택 + 1
    }
}