import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class No11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<Integer>[] node_adj = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++)
            node_adj[i] = new ArrayList<>();


        for (int i = 0; i < N - 1; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            node_adj[first].add(second);
            node_adj[second].add(first);
        }

        boolean[] isVisited = new boolean[N + 1];
        int[] parent = new int[N + 1];
        parent[1] = 1;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            List<Integer> linkedNode = node_adj[node];

            for (Integer n : linkedNode) {
                if (!isVisited[n]) {
                    parent[n] = node;
                    queue.add(n);
                    isVisited[n] = true;
                }
            }
        }

        for (int i = 2; i < N + 1; i++)
            System.out.println(parent[i]);
    }
}