import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No1916 { // 다익스트라 알고리즘

    private static int countOfCities;
    private static int countOfBuses;
    private static int startingCity;
    private static int arrivalCity;
    private static LinkedList<Node>[] adjNode;
    private static int cost[];
    private static boolean isVisited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        countOfCities = sc.nextInt(); // 도시 개수
        countOfBuses = sc.nextInt(); // 버스 개수
        cost = new int[countOfCities + 1];
        adjNode = new LinkedList[countOfCities + 1];

        for (int i = 1; i <= countOfCities; i++)
            adjNode[i] = new LinkedList<>();

        for (int i = 1; i <= countOfCities; i++)
            cost[i] = Integer.MAX_VALUE;

        // 입력
        for (int i = 0; i < countOfBuses; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            Node route = new Node(end, cost);
            adjNode[start].add(route);
        }
        startingCity = sc.nextInt();
        arrivalCity = sc.nextInt();

        isVisited = new boolean[countOfCities + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(startingCity, 0));
        cost[startingCity] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            int cur = curNode.end;
            if (!isVisited[cur]) {
                isVisited[cur] = true;

                LinkedList<Node> adj = adjNode[cur];
                for (Node node : adj) {
                    if (!isVisited[node.end]) {
                        if (cost[cur] + node.cost <= cost[node.end]) {
                            cost[node.end] = cost[cur] + node.cost;
                            queue.offer(new Node(node.end, cost[node.end])); // queue.offer(node) 이거랑 뭐가 다름???? 여기서 틀림 뜸
                        }
                    }
                }
            }
        }

        System.out.println(cost[arrivalCity]);

    }

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}

