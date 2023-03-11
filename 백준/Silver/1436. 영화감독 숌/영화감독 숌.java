import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 666, 1666, 2666, ... 이어지므로 666에서 시작
        int startNum = 666;

        // 브루트포스 : 전체탐색을 위해 count 변수 설정
        int count = 1;


        // N번째에 해당하는 startNum을 찾아야하기 때문에 count가 N이 될 때까지 반복하며 startNum을 증가시킴
        while (count != N) {
            startNum++;

            // 위에서 증가시킨 startNum이 666을 포함하면 count를 증가시켜서 반복문 수행
            if(String.valueOf(startNum).contains("666")){
                count++;
            }
        }

        // count 변수가 N번째에 도달했으면 해당 startNum을 출력
        System.out.println(startNum);

    }
}