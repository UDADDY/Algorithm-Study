import java.util.Scanner;

public class No14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] t = new int[N + 15];
        int[] p = new int[N + 15];
        int[] dp = new int[N + 15];

        for (int i = 0; i < N; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int max = 0;

        for (int i = 0; i <= N; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[t[i] + i] = Math.max(dp[t[i] + i], p[i] + dp[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);


    }
}