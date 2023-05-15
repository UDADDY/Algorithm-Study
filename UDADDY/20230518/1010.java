import java.util.Scanner;

public class No1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(solution(N, M));
        }


    }

    // Combination(조합)
    public static int solution(int N, int M) {
        int ret = combination(M, N);
        return ret;
    }

    // nCr
    public static int combination(int n, int r) {
        if (r > n / 2)
            r = n - r;

        int ret = 1;
        for (int i = 1; i <= r; i++)
            ret = ret * (n - i + 1) / i;

        return ret;
    }
}