import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 그래프 이론
 * 그래프 탐색
 * 트리
 * 너비 우선 탐색
 * 깊이 우선 탐색
 */

public class Main {
    static int N; // 노드의 개수
    static ArrayList<Integer>[] tree; // 인접 리스트로 트리 구현
    static int[] parents; // 각 노드의 부모 노드 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 구성
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        // 루트 노드(1번 노드)의 부모를 0으로 초기화
        parents[1] = 0;

        // 각 노드의 부모 노드 찾기
        dfs(1);

        // 결과 출력
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    // 깊이 우선 탐색 (DFS)를 이용하여 부모 노드 찾기
    private static void dfs(int node) {
        for (int child : tree[node]) {
            if (parents[child] == 0) { // 아직 부모가 할당되지 않은 경우
                parents[child] = node; // 현재 노드를 부모로 설정
                dfs(child); // 자식 노드에 대해 재귀적으로 탐색
            }
        }
    }
}