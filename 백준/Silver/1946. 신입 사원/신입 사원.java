import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 지원자
            List<Applicant> applicantList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                applicantList.add(new Applicant(document, interview));
            }

            applicantList.sort((o1, o2) -> o1.document - o2.document);

            int rs = 1;
            int curRank = applicantList.get(0).interview;

            for (int i = 1; i < N; i++) {
                Applicant curPerson = applicantList.get(i);

                if (curPerson.interview < curRank) {
                    rs++;
                    curRank = curPerson.interview;
                }
            }

            sb.append(rs).append("\n");
        }

        System.out.println(sb);
    }
}
class Applicant {
    int document;
    int interview;

    public Applicant(int document, int interview) {
        this.document = document;
        this.interview = interview;
    }
}

/*
1. 서류 1등이면 pick
2. 서류 2등부터 면접 등수 비교
    서류 2등의 면접 등수보다 순위가 높으면 pick
    그 때 pick한 지원자의 면접 등수로 갱신
3. 최고 면접 등수와 계속 비교해서 반복
1 4 o
2 3 o
3 2 o
4 1 o
5 5 x

1 4 o
2 5 x
3 6 x
4 2 o
5 7 x
6 1 o
7 3 x


 */