import java.util.Scanner;

public class No14503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialization
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] room = new int[N][M]; // 0==Not Cleaned, 1==Wall, 2==Cleaned

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt(); // if d==0) North, d==1) East, d==2) South, d==3) West
        int countOfCleaningRoom = 0;
        boolean done = false;

        // Input
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                room[i][j] = sc.nextInt();
        }

        while (true) {
            // Course 1
            // Not Cleaned
            if (room[r][c] == 0) {
                room[r][c] = 2;
                countOfCleaningRoom++;
                continue;
            }

            // Course 2
//            if ((room[r][c - 1] == 2 || room[r][c - 1] == 1) && (room[r][c + 1] == 2 || room[r][c + 1] == 1) && (room[r - 1][c] == 2 || room[r - 1][c] == 1) && (room[r + 1][c] == 2 || room[r - 1][c] == 1)) {// room[r][c + 1] == 2 && room[r - 1][c] == 2 && room[r + 1][c] == 2) {
            if (room[r][c - 1] != 0 && room[r][c + 1] != 0 && room[r - 1][c] != 0 && room[r + 1][c] != 0) {
                // Course 2-1, 2-2
                switch (d) {
                    case 0: // North
                        // 2-1
                        if (room[r + 1][c] == 2) {
                            r++;
                            continue;
                        }
                        // 2-2 Done
                        if (room[r + 1][c] == 1)
                            done = true;
                        break;

                    case 1: // East
                        // 2-1
                        if (room[r][c - 1] == 2) {
                            c--;
                            continue;
                        }
                        // 2-2 Done
                        if (room[r][c - 1] == 1)
                            done = true;

                        break;

                    case 2: // South
                        // 2-1
                        if (room[r - 1][c] == 2) {
                            r--;
                            continue;
                        }
                        // 2-2 Done
                        if (room[r - 1][c] == 1)
                            done = true;

                        break;

                    case 3: // West
                        // 2-1
                        if (room[r][c + 1] == 2) {
                            c++;
                            continue;
                        }
                        // 2-2 Done
                        if (room[r][c + 1] == 1)
                            done = true;

                        break;
                }
            }

            if (done)
                break;

            // Course 3
            if (room[r][c - 1] == 0 || room[r][c + 1] == 0 || room[r - 1][c] == 0 || room[r + 1][c] == 0) {
                if (d-- < 0)
                    d = 3;

                switch (d) {
                    case 0: // North
                        if (room[r - 1][c] == 0)
                            r--;
                        break;

                    case 1: // East
                        if (room[r][c + 1] == 0)
                            c++;

                        break;

                    case 2: // South
                        if (room[r + 1][c] == 0)
                            r++;

                        break;

                    case 3: // West
                        if (room[r][c - 1] == 0)
                            c--;

                        break;
                }
            }
        }

        System.out.println(countOfCleaningRoom);
    }
}