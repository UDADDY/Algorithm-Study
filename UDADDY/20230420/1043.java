import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1043 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] party = new boolean[M];

        int truePeopleCnt = sc.nextInt();

        if (truePeopleCnt == 0) {
            System.out.print(M);
            return;
        }

        //자신과 연결된 루트 노드를 설정
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        boolean[] truePeople;
        truePeople = new boolean[N + 1];
        for (int i = 0; i < truePeopleCnt; i++) {
            int num = sc.nextInt();
            truePeople[num] = true;
        }

        List<List<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < M; i++)
            partyList.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                partyList.get(i).add(sc.nextInt());

                // 같이 파티에 참가한 사람 확인
                if (j != 0) {
                    int nowIdx = partyList.get(i).get(j);
                    int exIdx = partyList.get(i).get(j - 1);

                    union(exIdx, nowIdx);
                }
            }
        }

        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (truePeople[i] && !visited[i]) {
                int root = find(i);

                for (int j = 1; j <= N; j++) {
                    if (find(j) == root) {
                        truePeople[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        // 파티에 진실을 아는 사람이 있는 지 확인
        boolean[] goParty = new boolean[M];
        for (int i = 0; i < M; i++)
            goParty[i] = true;

        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if (truePeople[j]) {
                    if (partyList.get(i).contains(j))
                        goParty[i] = false;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < M; i++)
            if (goParty[i])
                sum++;

        System.out.println(sum);

    }

    //자신과 연결된 노드의 루트 노드를 탐색
    static int find(int idx) {
        if (parent[idx] == idx)
            return idx;
        else {
            parent[idx] = find(parent[idx]);
            return parent[idx];
        }
    }

    //연결된 노드가 다르다면 연결해줌
    static void union(int idx1, int idx2) {
        int parent1 = find(idx1);
        int parent2 = find(idx2);

        if (parent1 != parent2)
            parent[parent2] = parent1;
    }
}