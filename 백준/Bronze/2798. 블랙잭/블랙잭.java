import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        int index = N * (N-1) * (N-2) /6;
        int[] sum = new int[index];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int num = 0;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1 ; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    sum[num] = arr[i] + arr[j] + arr[k];
                    num++;
                }
            }
        }

        Integer[] tmp = Arrays.stream(sum).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());

        for (int i = 0; i < tmp.length; i++) {

            if ( tmp[i] <= M) {
                System.out.println(tmp[i]);
                break;
            }
        }
    }


}

 /*
  arr = [1,2,3,4,5,6,7,8]
  875 871

  1 2 3 100 102

  19




 7 + 8 + 6
       +5 ....

       arr[length] + arr[length-1] + arr[length-i] <= M

  */