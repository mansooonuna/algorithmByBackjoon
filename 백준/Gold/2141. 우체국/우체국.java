import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Town> townList = new ArrayList<>(N);
        long totalPerson = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            townList.add(new Town(x, a));
            totalPerson += a;
        }

        Collections.sort(townList);

        long rs = 0;
        for (int i = 0; i < N; i++) {
            rs += townList.get(i).person;
            if ((totalPerson + 1) / 2 <= rs) {
                System.out.println(townList.get(i).x);
                break;
            }
        }
    }

    static class Town implements Comparable<Town> {
        long x;
        long person;

        public Town(long x, long person) {
            this.x = x;
            this.person = person;
        }

        // 마을 위치 기준 오름차순
        @Override
        public int compareTo(Town o) {
            if (this.x == o.x) return (int) (this.person - o.person);
            return (int) (this.x - o.x);
        }
    }
}