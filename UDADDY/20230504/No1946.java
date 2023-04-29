import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            List<Score> scoreList = new ArrayList<>();

            // 랭킹 입력
            while (N-- > 0) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                Score score = new Score(first, second);
                scoreList.add(score);
            }

            // 첫번째 점수로 정렬
            Collections.sort(scoreList);

            // 랭킹 비교
            int answer = 1; // 첫번째 점수가 1등이면 무조건 포함이니 1로 초기화
            int min = scoreList.get(0).second; // 첫번째 점수가 1등인 사람의 두번째 점수를 min으로 설정
            for (int i = 1; i < scoreList.size(); i++) {

                // 비교 대상의 두번째 점수가 min보다 작으면 min 스왑
                if (scoreList.get(i).second < min) {
                    min = scoreList.get(i).second;
                    answer++;
                }
            }

            System.out.println(answer);

        }
    }
}

class Score implements Comparable<Score> {
    public int first;
    public int second;

    Score(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Score o) {
        if (first > o.first)
            return 1;
        return -1;
    }
}