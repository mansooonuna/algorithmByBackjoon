import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            // 날짜 표기하기 위해서 (ex 1130)
            flowers[i] = new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay);
        }

        Arrays.sort(flowers); // 피는 날짜 기준 정렬

        int count = 0, end = 301, idx = 0, lastEnd = 0;
        while (end <= 1130 && idx < N) { // 11월 30일까지 반복
            boolean flag = false;
            for (int i = idx; i < N; i++) { // 현재 심을 수 있는 꽃 확인
                if (flowers[i].start > end) { // 꽃 없으면 탈출
                    break;
                }
                if (lastEnd < flowers[i].end) { // 가장 늦게 지는 꽃 탐색
                    lastEnd = flowers[i].end;
                    flag = true;
                    idx = i;
                }
            }
            if (flag) { // 가장 늦게 지는 꽃 찾았을 경우
                end = lastEnd;
                count++;
                idx++;
            } else {
                System.out.println(0);
                return;
            }
        }
        if (end <= 1130) { // 11월 30일 안되었으면
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
}

class Flower implements Comparable<Flower> {
    int start, end;

    Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Flower o) {
        if (this.start == o.start) {
            return this.end - o.end;
        } else {
            return this.start - o.start;
        }
    }
}