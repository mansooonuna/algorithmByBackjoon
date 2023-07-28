import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int fiveCount = n / 5;
        int remain = n % 5;

        while (fiveCount >=0){
            if (remain % 2 == 0) {
                int twoCount = remain /2 ;
                System.out.println(fiveCount + twoCount);
                break;
            } else {
                fiveCount--;
                remain += 5;
            }
        }

        if (fiveCount < 0) {
            System.out.println(-1);
        }
    }

}