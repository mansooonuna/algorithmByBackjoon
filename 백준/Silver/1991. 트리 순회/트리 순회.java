import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Node[] a;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        a = new Node[26];
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");

            int x = input[0].charAt(0) - 'A';
            char l = input[1].charAt(0);
            char r = input[2].charAt(0);

            int left = -1, right = -1;

            if (l != '.') left = l - 'A';
            if (r != '.') right = r - 'A';

            a[x] = new Node(left, right);
        }

        preorder(0);
        answer.append("\n");
        inorder(0);
        answer.append("\n");
        postorder(0);

        System.out.println(answer);
    }

    static void preorder(int x) { // 전위 순회 (루트 - 왼쪽 - 오른쪽)
        if (x == -1) return;
        answer.append((char) (x + 'A'));
        preorder(a[x].left);
        preorder(a[x].right);
    }

    static void inorder(int x) { // 중위 순회 (왼쪽 - 루트 - 오른쪽)
        if (x == -1) return;
        inorder(a[x].left);
        answer.append((char) (x + 'A'));
        inorder(a[x].right);
    }

    static void postorder(int x) { // 후위 순회 (왼쪽 - 오른쪽 - 루트)
        if (x == -1) return;
        postorder(a[x].left);
        postorder(a[x].right);
        answer.append((char) (x + 'A'));
    }
}

class Node {
    int left, right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}