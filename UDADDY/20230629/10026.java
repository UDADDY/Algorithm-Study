import java.util.LinkedList;
import java.util.Scanner;

public class No10026 {

    private static int N;
    private static int[][] board = null;
    private static int[][] blindnessBoard = null;
    private static boolean[][] visited = null;
    private static boolean[][] blindnessVisited = null;
    private static int cnt = 0;
    private static int blindnessCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());

        board = new int[N][N]; // R=0, G=1, B=2
        blindnessBoard = new int[N][N]; // R, G = 0, B=2;

        visited = new boolean[N][N];
        blindnessVisited = new boolean[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == 'R') {
                    board[i][j] = 0;
                    blindnessBoard[i][j] = 0;
                } else if (input.charAt(j) == 'G') {
                    board[i][j] = 1;
                    blindnessBoard[i][j] = 0;
                } else {
                    board[i][j] = 2;
                    blindnessBoard[i][j] = 2;
                }
            }
        }

        // solution for normal
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        // solution for color blindness
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!blindnessVisited[i][j]) {
                    blindnessCnt++;
                    blindnessBfs(i, j);
                }
            }
        }

        System.out.println(cnt + " " + blindnessCnt);
    }

    public static void bfs(int i, int j) {
        LinkedList<int[]> queue = new LinkedList<>();

        if (visited[i][j])
            return;

        int target = board[i][j];
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {

            int[] point = queue.poll(); // point[0] = i, point[1] = j
            int x = point[0];
            int y = point[1];

            if (y - 1 >= 0) { // 왼쪽 검색
                if (!visited[x][y - 1]) {
                    int left = board[x][y - 1];
                    if (left == target) {
                        visited[x][y - 1] = true;
                        queue.add(new int[]{x, y - 1});
                    }
                }
            }
            if (y + 1 < N) { // 오른쪽 검색
                if (!visited[x][y + 1]) {
                    int right = board[x][y + 1];
                    if (right == target) {
                        visited[x][y + 1] = true;
                        queue.add(new int[]{x, y + 1});
                    }
                }
            }
            if (x - 1 >= 0) { // 위쪽 검색
                if (!visited[x - 1][y]) {
                    int up = board[x - 1][y];
                    if (up == target) {
                        visited[x - 1][y] = true;
                        queue.add(new int[]{x - 1, y});
                    }
                }
            }
            if (x + 1 < N) { // 아래쪽 검색
                if (!visited[x + 1][y]) {
                    int down = board[x + 1][y];
                    if (down == target) {
                        visited[x + 1][y] = true;
                        queue.add(new int[]{x + 1, y});
                    }
                }
            }

        }
    }

    public static void blindnessBfs(int i, int j) {
        LinkedList<int[]> queue = new LinkedList<>();

        if (blindnessVisited[i][j])
            return;

        int target = blindnessBoard[i][j];
        queue.add(new int[]{i, j});
        blindnessVisited[i][j] = true;

        while (!queue.isEmpty()) {

            int[] point = queue.poll(); // point[0] = i, point[1] = j
            int x = point[0];
            int y = point[1];

            if (y - 1 >= 0) { // 왼쪽 검색
                if (!blindnessVisited[x][y - 1]) {
                    int left = blindnessBoard[x][y - 1];
                    if (left == target) {
                        blindnessVisited[x][y - 1] = true;
                        queue.add(new int[]{x, y - 1});
                    }
                }
            }
            if (y + 1 < N) { // 오른쪽 검색
                if (!blindnessVisited[x][y + 1]) {
                    int right = blindnessBoard[x][y + 1];
                    if (right == target) {
                        blindnessVisited[x][y + 1] = true;
                        queue.add(new int[]{x, y + 1});
                    }
                }
            }
            if (x - 1 >= 0) { // 위쪽 검색
                if (!blindnessVisited[x - 1][y]) {
                    int up = blindnessBoard[x - 1][y];
                    if (up == target) {
                        blindnessVisited[x - 1][y] = true;
                        queue.add(new int[]{x - 1, y});
                    }
                }
            }
            if (x + 1 < N) { // 아래쪽 검색
                if (!blindnessVisited[x + 1][y]) {
                    int down = blindnessBoard[x + 1][y];
                    if (down == target) {
                        blindnessVisited[x + 1][y] = true;
                        queue.add(new int[]{x + 1, y});
                    }
                }
            }

        }
    }
}