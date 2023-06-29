import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No7576 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int width;
    static int height;
    static int[][] board;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        width = sc.nextInt();
        height = sc.nextInt();

        board = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1)
                    queue.offer(new int[]{i, j});
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;

                if (board[nx][ny] == 0) {
                    board[nx][ny] = board[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        if (checkZero())
            return -1;

        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (max < board[i][j])
                    max = board[i][j];
            }
        }

        return max - 1;
    }

    public static boolean checkZero() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 0)
                    return true;
            }
        }

        return false;
    }

}