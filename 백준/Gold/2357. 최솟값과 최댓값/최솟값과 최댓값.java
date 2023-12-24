import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree seg = new SegmentTree(N);
        seg.init(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            Node node = seg.find(1, 1, N, left, right);
            sb.append(node.min).append(" ").append(node.max).append("\n");
        }

        System.out.println(sb);
    }

}

class Node {
    int min;
    int max;

    public Node(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

class SegmentTree {
    Node[] tree;

    public SegmentTree(int arrSize) {
        tree = new Node[arrSize * 4];
    }

    // 배열을 입력받은 후 트리 초기화
    public Node init(int[] arr, int node, int start, int end) {
        // 리프노드에 값을 넣고 반환한다
        if (start == end) {
            return tree[node] = new Node(arr[start], arr[start]);
        }

        // 리프노드가 아닌 경우 자식 노드로 들어간다
        Node a = init(arr, node * 2, start, (start + end) / 2);
        Node b = init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
        return tree[node] = new Node(Math.min(a.min, b.min), Math.max(a.max, b.max));
    }

    // left ~ right 구간까지 합을 찾는다
    public Node find(int node, int start, int end, int left, int right) {
        // 구간에 포함되지 않을 경우
        if (left > end || right < start) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // 구하려고 하는 구간에 노드의 구간이 포함되어 있을 경우
        if (left <= start && end <= right) {
            return tree[node];
        }

        // 그 외의 경우 자식노드를 탐색
        Node a = find(node * 2, start, (start + end) / 2, left, right);
        Node b = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return new Node(Math.min(a.min, b.min), Math.max(a.max, b.max));
    }
}