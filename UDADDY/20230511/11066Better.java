import java.util.PriorityQueue;
import java.util.Scanner;

public class No11066Better {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int numOfPages = sc.nextInt();

            int[] pages = new int[numOfPages];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < numOfPages; i++)
                pq.offer(sc.nextInt());

            System.out.println(func(pq));
        }
    }

    public static int func(PriorityQueue<Integer> pq) {
        int sum = 0;

        while (pq.size() != 1) {
            int tmp = pq.poll() + pq.poll();
            sum += tmp;
            pq.offer(tmp);
        }

        return sum;
    }
}