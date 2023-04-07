class Solution {
      public int solution(int[][] sizes) {
        int max = 1;
        int min = 1;

          for (int i = 0; i < sizes.length; i++) {
              int sizeMax = Math.max(sizes[i][0], sizes[i][1]);
              int sizeMin = Math.min(sizes[i][0], sizes[i][1]);

              if (sizeMax > max) {
                  max = sizeMax;
              }
              if (sizeMin > min) {
                  min = sizeMin;
              }
          }
          return max * min;

    }
}