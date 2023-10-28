import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] treeLength = br.readLine().split(" ");
        String[] growLength = br.readLine().split(" ");

        List<Tree> treeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            treeList.add(new Tree(treeLength[i], growLength[i]));
        }

        treeList.sort((tree1, tree2) -> Integer.compare(tree1.growth, tree2.growth));

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += treeList.get(i).length + ((long) treeList.get(i).growth * i);
        }

        System.out.println(total);
    }
}

class Tree {
    int length;
    int growth;

    public Tree(String length, String growth) {
        this.length = Integer.parseInt(length);
        this.growth = Integer.parseInt(growth);
    }
}

/*
1. 성장속도 기준 정렬
3 4 2 1 6
7 4 3 2 1

2. 성장 속도 작은 나무부터 자름
1일 -> 6 -> 3 4 2 1 0
2일 -> 3 -> 10 8 5 0 1
3일 -> 8 -> 17 12 0 2 2
4일 -> 16 -> 24 0 3 4 3
5일 -> 31 -> 0 4 6 6 4

6 + 3 + 8 + 16 + 31 = 64
 */