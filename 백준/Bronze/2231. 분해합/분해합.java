import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    해결 :
    1. N의 자릿수를 구한다.
    2. N-(N의 자릿수*10)부터 N까지 반복문을 돌리고 조건에 맞는지 판단한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int digit = String.valueOf(N).length();


            boolean isFound = false;
            for (int i = N-(digit*10); i < N; i++) {
                int input = i;
                int result = i;


                for (int j = digit - 1; j >=  0; j--) {
                    int d = (int) Math.pow(10, j);
                    result += input/d;
                    input = input % d;
                }

                // 조건문
                if (result == N){
                    isFound = true;
                    System.out.println(i);
                    break;
                }
            }

            if (!isFound) {
                System.out.println(0);
            }
        }




        /*
        input : 2451

        2451/1000 = 2
        input = 2451 % 1000 = 451

        451/100 = 4
        input = 451 % 100 = 51

        51/10 = 5
        input = 51 % 10 = 1

        1 / 1 = 1

         */


    
}