import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class No2447 {

    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Writer writer = new PrintWriter(System.out);

        N = sc.nextInt();

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = ' ';
        }

        three(0, 0, N);

        for (char[] chars : map) {
            writer.write(chars);
            writer.write('\n');
        }

        writer.flush();
    }

    public static void three(int x, int y, int N) {

        if (N == 1) {
            map[x][y] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1))
                    three(x + i * (N / 3), y + j * (N / 3), N / 3);
            }
        }
    }
}