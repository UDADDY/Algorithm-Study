import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1005 {

    static int N;
    static int K;
    static int[] buildings;
    static LinkedList<Integer>[] adj;
    static int[] indegree;
    static int[] buildCost;

    static int target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt(); // 건물 개수
            K = sc.nextInt(); // 건설 순서 규칙 개수

            buildings = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                int cost = sc.nextInt();
                buildings[i] = cost;
            }

            adj = new LinkedList[N + 1];
            for (int i = 1; i <= N; i++)
                adj[i] = new LinkedList<>();

            indegree = new int[N + 1];

            for (int i = 0; i < K; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                adj[start].add(end);
                indegree[end]++;
            }

            target = sc.nextInt();

            buildCost = new int[N + 1];
            topologySort();
            System.out.println(buildCost[target]);
        }
    }

    public static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                buildCost[i] = buildings[i];
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < adj[cur].size(); i++) {
                int next = adj[cur].get(i);
                buildCost[next] = Math.max(buildCost[cur] + buildings[next], buildCost[next]);
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.offer(next);
            }
        }
    }

    static class Node {
        public int num;
        public int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}