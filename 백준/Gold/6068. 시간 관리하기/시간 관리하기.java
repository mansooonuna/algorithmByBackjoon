import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Work> workList = new PriorityQueue<>((o1, o2) -> o1.endTime - o2.endTime);

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            
            workList.add(new Work(time, endTime));
        }

        int currentTime = 0; // 현재 시간
        int latestStartTime = Integer.MAX_VALUE;
        boolean isDone = true;
        
        while (!workList.isEmpty()) {
            Work current = workList.poll();
            currentTime += current.time; // 필요한 시간만큼 누적해서 더해주면 현재 시간이 업데이트
            latestStartTime = Math.min(latestStartTime, current.endTime - currentTime);

            // 일을 끝낼 수 없다면?
            if (currentTime > current.endTime) {
                isDone = false;
                break;
            }
        }

        if (!isDone) System.out.println(-1);
        else System.out.println(latestStartTime);
    }

    public static class Work {
        int time, endTime;

        public Work(int time, int endTime) {
            this.time = time;
            this.endTime = endTime;
        }
    }
}

/*
반례
4
17 63
32 95
38 129
11 104
답:31
 */