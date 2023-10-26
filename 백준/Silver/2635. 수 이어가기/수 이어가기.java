import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int maxCnt = 0;

        List<Integer> maxList = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            List<Integer> tmpList = new LinkedList<>();
            tmpList.add(num);
            // i 는 두번째 수
            tmpList.add(i);

            int nextNum = num - i;
            // 음의 정수는 버리므로 양의 정수일 때 반복문 순회
            while (nextNum >= 0) {
                tmpList.add(nextNum);
                // 앞의 앞의 수에서 앞의 수 빼기
                nextNum = tmpList.get(tmpList.size() - 2) - tmpList.get(tmpList.size() - 1);
            }

            if (maxCnt < tmpList.size()) {
                maxCnt = tmpList.size();
                maxList = tmpList;
            }
        }
        
        sb.append(maxCnt).append("\n");
        for (Integer integer : maxList) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }
}

/*
1부터 순서대로 다 넣어보며 반복문 순회
리스트에 숫자 추가하기
 */