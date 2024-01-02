import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈
        int K = Integer.parseInt(st.nextToken()); // 동생

        System.out.println(bfs(N, K));
    }

    private static int bfs(int start, int end) {
        int[] times = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == end) break;

            if (cur - 1 >= 0 && !visited[cur - 1]) {
                queue.add(cur - 1);
                visited[cur - 1] = true;
                times[cur - 1] = times[cur] + 1;
            }

            if (cur + 1 <= 100000 && !visited[cur + 1]) {
                queue.add(cur + 1);
                visited[cur + 1] = true;
                times[cur + 1] = times[cur] + 1;
            }

            if (cur * 2 <= 100000 && !visited[cur * 2]) {
                queue.add(cur * 2);
                visited[cur * 2] = true;
                times[cur * 2] = times[cur] + 1;
            }
        }
        return times[end];
    }
}

/*
BFS -> 시작 노드에서 가까운 노트부터 탐색하므로 최단 거리를 찾기에 적합
- 시작노드 : 수빈 위치
- 도착노드 : 동생 위치
- 이동시간 모두 1초 : 모든 간선의 가중치는 1


1. 큐에 방문할 노드의 위치와 도달하기까지 걸린 시간 저장
2. 초기에 수빈이 위치 큐에 넣고 bfs
3. 노드를 하나씩 꺼내어 이동 가능한 위치를 모두 큐에 추가 (방문 체크)
4. 반복하다가, 동생 위치에 도달하면 해당 시간 출력
 */