import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수학
 * 사칙연산
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(br.readLine()) - 543);
    }
}