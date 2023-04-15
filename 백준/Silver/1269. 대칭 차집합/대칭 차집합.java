import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        st = new StringTokenizer(br.readLine());            // 3 5
        int countA = Integer.parseInt(st.nextToken());      // 3
        int countB = Integer.parseInt(st.nextToken());      // 5

        st = new StringTokenizer(br.readLine());            // 1 2 4
        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < countA; i++) {
            setA.add(Integer.valueOf(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());            // 2 3 4 5 6
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < countB; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (setA.contains(num)) {
                setA.remove(num);
            } else {
                setB.add(num);
            }
        }
        System.out.println(setA.size() + setB.size());


    }
}