import java.util.Scanner;

public class No2630 {

    public static int blue = 0; // 1
    public static int white = 0; // 0

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] board = new int[N][N];

        // 입력
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();

        // 로직
        divAndConquer(board);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void divAndConquer(int[][] board) {
        // 체크
        if (isWhiteBoard(board)) {
            white++;
            return;
        }

        if (isBlueBoard(board)) {
            blue++;
            return;
        }

        // 4개로 나누기
        int[][] leftTopBoard = getLeftTopBoard(board);
        int[][] leftBottomBoard = getLeftBottomBoard(board);
        int[][] rightTopBoard = getRightTopBoard(board);
        int[][] rightBottomBoard = getRightBottomBoard(board);

        divAndConquer(leftTopBoard);
        divAndConquer(leftBottomBoard);
        divAndConquer(rightTopBoard);
        divAndConquer(rightBottomBoard);
    }

    public static boolean isWhiteBoard(int[][] board) {
        int length = board[0].length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public static boolean isBlueBoard(int[][] board) {
        int length = board[0].length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    public static int[][] getLeftTopBoard(int[][] board) {
        int length = board[0].length;
        int div = length / 2;

        int[][] leftTopBoard = new int[div][div];

        // 왼쪽 위 박스 지정
        for (int i = 0; i < div; i++)
            for (int j = 0; j < div; j++)
                leftTopBoard[i][j] = board[i][j];
        return leftTopBoard;
    }

    public static int[][] getLeftBottomBoard(int[][] board) {
        int length = board[0].length;
        int div = length / 2;

        int[][] leftBottomBoard = new int[div][div];

        // 왼쪽 위 박스 지정
        for (int i = 0; i < div; i++)
            for (int j = 0; j < div; j++)
                leftBottomBoard[i][j] = board[i + div][j];

        return leftBottomBoard;
    }

    public static int[][] getRightTopBoard(int[][] board) {
        int length = board[0].length;
        int div = length / 2;

        int[][] rightTopBoard = new int[div][div];

        // 왼쪽 위 박스 지정
        for (int i = 0; i < div; i++)
            for (int j = 0; j < div; j++)
                rightTopBoard[i][j] = board[i][j + div];

        return rightTopBoard;
    }

    public static int[][] getRightBottomBoard(int[][] board) {
        int length = board[0].length;
        int div = length / 2;

        int[][] rightBottomBoard = new int[div][div];

        // 왼쪽 위 박스 지정
        for (int i = 0; i < div; i++)
            for (int j = 0; j < div; j++)
                rightBottomBoard[i][j] = board[i + div][j + div];

        return rightBottomBoard;
    }
}