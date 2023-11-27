import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> pq = new PriorityQueue<>();

        StringTokenizer st;
        int maxDay = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            maxDay = Math.max(maxDay, d);
            pq.add(new Lecture(p, d));
        }

        boolean[] check = new boolean[maxDay + 1]; // 강연 했는지 체크

        int totalPay = 0;
        while (!pq.isEmpty()) {
            Lecture curLecture = pq.poll();

            for (int i = curLecture.day - 1; i >= 0; i--) { // 최대 강연료를 받기 위해 역순으로 순회
                // 강연 아직 안했으면
                if (!check[i]) {
                    check[i] = true;
                    totalPay += curLecture.pay;
                    break;
                }
            }
        }
        System.out.println(totalPay);
    }
}

class Lecture implements Comparable<Lecture> {
    int pay, day;

    public Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.pay == o.pay) return o.day - this.day;
        return o.pay - this.pay;
    }
}

/*
20 1

100 2

10 3
50 10
5 20
 */