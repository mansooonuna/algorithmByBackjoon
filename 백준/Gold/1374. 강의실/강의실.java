import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>(N); // 강의 목록
        PriorityQueue<Integer> current = new PriorityQueue<>(); // 현재 진행 중 강의 종료 시간 목록

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(num, startTime, endTime));
        }

        lectures.sort(Comparator.comparingInt(lecture -> lecture.startTime)); // 시작 시간으로 정렬

        // 첫 번째 강의
        current.add(lectures.get(0).endTime);

        // 다음 강의부터 순회
        for (int i = 1; i < N; i++) {
            int start = lectures.get(i).startTime;
            int end = lectures.get(i).endTime;

            if(start >= current.peek()) {
                current.poll();
            }
            current.add(end);
        }
        System.out.println(current.size());
    }
}

class Lecture {
    int num;
    int startTime;
    int endTime;

    public Lecture(int num, int startTime, int endTime) {
        this.num = num;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}