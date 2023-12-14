import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] friends = new boolean[N][N];
        int[] twoFriend = new int[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                friends[i][j] = (input.charAt(j) == 'Y');
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                
                if (friends[i][j]) twoFriend[i]++;
                else {
                    for (int k = 0; k < N; k++) {
                        if (friends[i][k] && friends[k][j]) {
                            twoFriend[i]++;
                            break;
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (twoFriend[i] > max) {
                max = twoFriend[i];
            }
        }

        System.out.println(max);
    }
}

/*
2-친구 -> A-B 친구 / A-C B-C 친구

1 - 2 3
2 - 1 3
3 - 1 2
 */