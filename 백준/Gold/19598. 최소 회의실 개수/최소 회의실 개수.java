import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Meeting> times = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(times);
        PriorityQueue<Integer> endTimePq = new PriorityQueue<>();
        endTimePq.offer(times.get(0).end);
        for (int i = 1; i < N; i++) {
            if (times.get(i).start >= endTimePq.peek()) endTimePq.poll();
            endTimePq.add(times.get(i).end);
        }
        System.out.println(endTimePq.size());
    }

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (start == o.start) return end - o.end;
            return start - o.start;
        }
    }

}