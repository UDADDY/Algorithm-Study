import java.util.Scanner;

public class No6236 {

    static int N;
    static int M;
    static int[] costs;
    static int max = 0;
    static int result;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        costs = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            costs[i] = sc.nextInt();
            max = Math.max(max, costs[i]);
        }

        int left = max;
        int right = 10_000 * 100_000;
        int count = 0;

        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            int ret = getCount(mid);
            if (M >= ret) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);


    }

    public static int getCount(int mid) {
        int count = 1;
        int money = mid;

        for (int i : costs) {
            money -= i;
            if (money < 0) {
                ++count;
                money = mid - i;
            }
        }

        return count;
    }
}