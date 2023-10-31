import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // 각 고객의 x, y 좌표를 저장할 리스트
        List<Integer> xCoords = new ArrayList<>();
        List<Integer> yCoords = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xCoords.add(x);
            yCoords.add(y);
        }

        // 좌표 리스트를 정렬
        Collections.sort(xCoords);
        Collections.sort(yCoords);

        int mid = (int) Math.round((double) n / 2);

        // 중앙값 계산
        int midX = xCoords.get(mid - 1);
        int midY = yCoords.get(mid - 1);

        // 모든 고객과 중간 지점 간 거리의 합 계산
        long totalDistance = 0;
        for (int i = 0; i < n; i++) {
            totalDistance += Math.abs(xCoords.get(i) - midX) + Math.abs(yCoords.get(i) - midY);
        }

        System.out.println(totalDistance);
    }
}