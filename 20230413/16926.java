import java.util.Scanner;

public class No16926 {

    // Global Variable
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Local Variable
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        // Initialization
        board = new int[N][M];

        // Input
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                board[i][j] = sc.nextInt();

        // Excution
        for (int i = 0; i < R; i++) round(N, M);

        // Output
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    // Logic
    public static void round(int N, int M) {
        int[][] newBoard = new int[N][M];

        int min = Math.min(N, M) / 2;

        for (int cnt = 0; cnt < min; cnt++) {
            // Top-Left-Down
            for (int i = cnt; i < N - 1 - cnt; i++) {
                newBoard[i + 1][cnt] = board[i][cnt];
            }

            // Bottom-Left-Right
            for (int i = cnt; i < M - 1 - cnt; i++) {
                newBoard[N - 1 - cnt][i + 1] = board[N - 1 - cnt][i];
            }

            // Bottom-Right-Up
            for (int i = cnt; i < N - 1 - cnt; i++) {
                newBoard[i][M - 1 - cnt] = board[i + 1][M - 1 - cnt];
            }

            // Top-Right-Left
            for (int i = cnt; i < M - 1 - cnt; i++) {
                newBoard[cnt][i] = board[cnt][i + 1];
            }
        }

        board = newBoard;
    }
}