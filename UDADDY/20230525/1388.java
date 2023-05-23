import java.util.Scanner;

public class No1388 {

    public static int[][] board;
    public static int N;
    public static int M;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        board = new int[N][M]; // 1은 가로(-), 2는 세로(|), 3은 이미 사용됨(visited)

        // 입력
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '-')
                    board[i][j] = 1;
                else
                    board[i][j] = 2;
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) { // 가로면
                    board[i][j] = 3;
                    int width = find_width(i, j + 1, 1);
                    cnt++;
                } else if (board[i][j] == 2) {
                    board[i][j] = 3;
                    int height = find_height(i + 1, j, 1);
                    cnt++;
                } else
                    continue;
            }
        }

        System.out.println(cnt);
    }

    public static int find_width(int i, int j, int cnt) {
        if (j == M)
            return cnt;

        if (board[i][j] == 1) {
            board[i][j] = 3;
            return find_width(i, j + 1, cnt + 1);
        } else
            return cnt;
    }

    public static int find_height(int i, int j, int cnt) {
        if (i == N)
            return cnt;

        if (board[i][j] == 2) {
            board[i][j] = 3;
            return find_height(i + 1, j, cnt + 1);
        } else
            return cnt;
    }
}