import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1043_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int knowPeopleCnt = sc.nextInt();
        if (knowPeopleCnt == 0) {
            System.out.println(M);
            return;
        }

        // 방문자 입력
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < knowPeopleCnt; i++)
            visited[sc.nextInt()] = true;

        // 파티 입력
        List<Integer>[] partyPeopleList = new ArrayList[M];
        for (int i = 0; i < M; i++)
            partyPeopleList[i] = new ArrayList<>();

        // 파티 인원 입력
        for (int i = 0; i < M; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++)
                partyPeopleList[i].add(sc.nextInt());
        }

        // 방문 계산
        for (int r = 0; r < M; r++) {
            for (int i = 0; i < partyPeopleList.length; i++) {
                for (int j = 0; j < partyPeopleList[i].size(); j++) {
                    // 파티 멤버 중 visited가 포함되어 있다면
                    if (visited[partyPeopleList[i].get(j)]) {
                        // 리스트의 모든 멤버 visited = True
                        for (int k = 0; k < partyPeopleList[i].size(); k++) {
                            visited[partyPeopleList[i].get(k)] = true;
                        }
                    }
                }
            }
        }

        // 최대 파티 계산
        int cnt = 0;
        for (int i = 0; i < partyPeopleList.length; i++) {
            boolean isOk = true;
            for (int j = 0; j < partyPeopleList[i].size(); j++) {
                if (visited[partyPeopleList[i].get(j)])
                    isOk = false;
            }
            if (isOk)
                cnt++;
        }

        System.out.println(cnt);
    }
}