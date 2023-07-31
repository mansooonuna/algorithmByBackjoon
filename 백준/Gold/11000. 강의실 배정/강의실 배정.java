import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 조건에 맞는 종료 시간 넣을 큐
        PriorityQueue<Integer> endTimePq = new PriorityQueue<>();

        List<Lecture> lectures = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 시작 시간 기준 오름차순 정렬
        Collections.sort(lectures);

        // 1번 강의 먼저 큐에 추가
        endTimePq.offer(lectures.get(0).end);

        for (int i = 1; i < N; i++) {
            if (lectures.get(i).start >= endTimePq.peek()) endTimePq.poll();
            endTimePq.add(lectures.get(i).end);
        }
        System.out.println(endTimePq.size());
    }

    static class Lecture implements Comparable<Lecture> {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (start == o.start) return end - o.end;
            return start - o.start;
        }
    }
}