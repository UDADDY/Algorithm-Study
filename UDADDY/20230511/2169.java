import java.util.Scanner;

public class No2169 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] board = new int[N][M];
        int[] leftToRight = new int[M];
        int[] rightToLeft = new int[M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                board[i][j] = sc.nextInt();

        int[][] dp = new int[N][M];
        dp[0][0] = board[0][0];

        // 첫째 줄 dp 초기화
        for (int i = 1; i < M; i++)
            dp[0][i] = board[0][i] + dp[0][i - 1];

        for (int i = 1; i < N; i++) {
            leftToRight[0] = dp[i - 1][0] + board[i][0];

            // 왼쪽 -> 오른쪽 방향으로 값들 저장
            for (int j = 1; j < M; j++)
                leftToRight[j] = Math.max(leftToRight[j - 1] + board[i][j], dp[i - 1][j] + board[i][j]);

            rightToLeft[M - 1] = dp[i - 1][M - 1] + board[i][M - 1];

            // 오른쪽 -> 왼쪽 방향으로 값들 저장
            for (int j = M - 2; j >= 0; j--)
                rightToLeft[j] = Math.max(rightToLeft[j + 1] + board[i][j], dp[i - 1][j] + board[i][j]);

            for (int j = 0; j < M; j++)
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
        }

        System.out.println(dp[N - 1][M - 1]);

    }
}