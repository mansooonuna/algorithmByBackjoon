import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());

            graph.get(input1).add(input2);
            graph.get(input2).add(input1);
        }

        int[] distance = new int[N + 1] ;
        Arrays.fill(distance, -1);
        distance[a] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph.get(cur)) {
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.println(distance[b]);
    }
}