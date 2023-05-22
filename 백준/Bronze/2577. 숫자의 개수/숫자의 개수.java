import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        long multiple = (long) A * B * C;
        int[] nums = new int[10];
        String multipleToStr = String.valueOf(multiple);
        for (int i = 0; i < multipleToStr.length(); i++) {
            int digit = multipleToStr.charAt(i) - '0';
            nums[digit]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);


    }
}