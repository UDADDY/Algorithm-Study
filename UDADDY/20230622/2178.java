import java.util.LinkedList;
import java.util.Scanner;

public class No2178 {

    public static int[][] board = null;

    public static boolean[][] isVisited = null;

    public static int N;
    public static int M;

    public static int[] dx = {-1, 1, 0, 0}; // x방향배열 상하
    public static int[] dy = {0, 0, -1, 1}; // x방향배열 좌우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        board = new int[N + 1][M + 1];

        // 입력
        for (int i = 1; i < N + 1; i++) {
            String str = sc.nextLine();
            for (int j = 1; j < M + 1; j++) {
                board[i][j] = str.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);

        System.out.println(board[N][M]);

    }

    public static void bfs(int x, int y) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        isVisited = new boolean[N + 1][M + 1];
        isVisited[1][1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if (nextX < 1 || nextX > N || nextY < 1 || nextY > M)
                    continue;
                if (isVisited[nextX][nextY] || board[nextX][nextY] == 0)
                    continue;

                queue.offer(new Node(nextX, nextY));
                board[nextX][nextY] = board[node.x][node.y] + 1;
                isVisited[nextX][nextY] = true;
            }
        }
    }
}

class Node {
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/*
4 5
12345
20006
30787
45608
 */