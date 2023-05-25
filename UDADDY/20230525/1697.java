import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Position> queue = new LinkedList<>();

        boolean[] visited = new boolean[100001];
        visited[N] = true;
        queue.add(new Position(N, 0));

        while (true) {
            Position position = queue.poll();

            if (position.position == K) {
                System.out.println(position.depth);
                break;
            }

            if (isValid(position.position - 1) && !visited[position.position - 1]) {
                visited[position.position - 1] = true;
                queue.add(new Position(position.position - 1, position.depth + 1));
            }

            if (isValid(position.position + 1) && !visited[position.position + 1]) {
                visited[position.position + 1] = true;
                queue.add(new Position(position.position + 1, position.depth + 1));
            }

            if (isValid(position.position * 2) && !visited[position.position * 2]) {
                visited[position.position * 2] = true;
                queue.add(new Position(position.position * 2, position.depth + 1));
            }

        }
    }

    public static boolean isValid(int position) {
        if (0 <= position && position <= 100000)
            return true;
        return false;
    }
}

class Position {
    public int position;
    public int depth;

    Position(int position, int depth) {
        this.position = position;
        this.depth = depth;
    }
}