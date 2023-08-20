import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            nums.add(i + 1);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 28; i++) {
            int input = Integer.parseInt(br.readLine());
            nums.remove(Integer.valueOf(input));
        }

        Collections.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (Integer i : nums) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}