import java.util.Arrays;
import java.util.Scanner;

public class No1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int goodNumCnt = 0;

        for (int i = 0; i < N; i++) {
            int target = arr[i];

            int start = 0;
            int end = N - 1;

            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == target) {
                    if (i == start)
                        start++;
                    else if (end == i)
                        end--;
                    else {
                        goodNumCnt++;
                        break;
                    }
                }

                // 합보다 타겟이 더 클 때
                if (sum < target) {
                    start++;
                }
                // 합보다 타겟이 더 작을 때
                if (target < sum) {
                    end--;
                }
            }

        }

        System.out.println(goodNumCnt);
    }
}