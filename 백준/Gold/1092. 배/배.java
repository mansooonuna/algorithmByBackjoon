import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> cranes = new ArrayList<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>(M);
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st2.nextToken()));
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (boxes.get(0) > cranes.get(0)) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        while (!boxes.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < N; ) {
                if (idx == boxes.size()) break;
                else if (cranes.get(i) >= boxes.get(idx)) {
                    boxes.remove(idx);
                    i++;
                } else idx++;
            }
            count++;
        }
        System.out.println(count);
    }
}