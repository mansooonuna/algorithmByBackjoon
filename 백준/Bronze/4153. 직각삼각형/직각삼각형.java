import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                nums.add(Integer.valueOf(st.nextToken()));
            }
            Collections.sort(nums);

            if (Math.pow(nums.get(2), 2) == (Math.pow(nums.get(0), 2) + Math.pow(nums.get(1), 2))) {
                bw.write("right" + "\n");
            } else {
                bw.write("wrong" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();


    }
}