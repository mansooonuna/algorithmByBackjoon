import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        Town[] townList = new Town[M + 1];
        for (int i = 1; i <= M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int sender = Integer.parseInt(st2.nextToken());
            int receiver = Integer.parseInt(st2.nextToken());
            int boxWeight = Integer.parseInt(st2.nextToken());

            townList[i] = new Town(sender, receiver, boxWeight);
        }
        // 받는 마을 기준 오름차순 정렬
        Arrays.sort(townList, 1, M + 1);

        // 각 마을당 보낼 수 있는 최대 용량 설정
        int[] weight = new int[N + 1];
        for (int i = 1; i < N; i++) {
            weight[i] = C;
        }

        int maxWeight = 0;
        for (int i = 1; i <= M; i++) {
            Town town = townList[i];

            int maxBoxNum = Integer.MAX_VALUE;

            // 보내는 마을 - 받는 마을 사이 마을 중에서 보낼 수 있는 무게 한도 구하기
            for (int j = town.sender; j < town.receiver; j++) {
                maxBoxNum = Math.min(maxBoxNum, weight[j]);
            }

            // 최대 한도 > 현재 보내려는 택배 개수 -> 마을 택배 용량 - 현재 보내려는 택배 용량
            if (maxBoxNum >= town.boxWeight) {
                for (int j = town.sender; j < town.receiver; j++) {
                    weight[j] -= town.boxWeight;
                }
                maxWeight += town.boxWeight;
            }
            // 최대한도 < 현재 보내려는 택배 개수 -> 최대 한도 기준
            else {
                for (int j = town.sender; j < town.receiver; j++) {
                    weight[j] -= maxBoxNum;
                }
                maxWeight += maxBoxNum;
            }
        }

        System.out.println(maxWeight);
    }

    static class Town implements Comparable<Town> {
        int sender;
        int receiver;
        int boxWeight;

        public Town(int sender, int receiver, int boxWeight) {
            this.sender = sender;
            this.receiver = receiver;
            this.boxWeight = boxWeight;
        }

        @Override
        public int compareTo(Town o) {
            if (receiver == o.receiver) return sender - o.sender;
            return receiver - o.receiver;
        }
    }
}