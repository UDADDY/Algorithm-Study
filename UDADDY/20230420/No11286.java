import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // PriorityQueue 사용, 절댓값이 더 작거나, 같더라도 수가 더 작으면 우선순위 높음.
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int A = Math.abs(a);
                int B = Math.abs(b);

                // return 값이 양수면 바꾸고, 음수면 안바꿈.

                // 비교 대상보다 내가 클 경우 바꿈.
                if (A > B)
                    return 1;
                else if (A == B) {
                    // 비교 대상과 절댓값은 같지만, 내가 더 크면 바꿈
                    if (a > b) return 1;
                    else return -1;
                } else
                    return -1;
            }
        });

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input != 0)
                pq.add(input);
            else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }
    }

}