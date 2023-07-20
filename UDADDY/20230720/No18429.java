import java.util.Scanner;

public class No18429 {

    static int N;
    public static int K;
    public static boolean[] isVisted;

    public static int cnt;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();


        isVisted = new boolean[N];
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        back(500, 0);

        System.out.println(cnt);
    }

    public static void back(int sum, int idx) {
        if (idx == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisted[i] && sum + arr[i] - K >= 500) {
                isVisted[i] = true;
                back(sum + arr[i] - K, idx + 1);
                isVisted[i] = false;
            }
        }
    }
}