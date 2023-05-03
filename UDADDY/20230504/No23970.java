import java.util.Arrays;
import java.util.Scanner;

public class No23970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        // 두 배열 입력
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        for (int i = 0; i < N; i++)
            B[i] = sc.nextInt();

        System.out.println(bubbleSort(A, B, N));
    }

    public static int bubbleSort(int[] A, int[] B, int N) {
        if (Arrays.equals(A, B))
            return 1;

        // 로직
        for (int i = 0; i < N - 1; i++) {
            boolean isChange = false; // 바뀐 값이 전혀 없다면, 정렬이 끝난 배열일테니 break 하기 위한 변수
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) { // 앞 수가 뒷 수 보다 클 때 스왑
                    swap(A, j, j + 1);

                    if (A[j] == B[j] && A[j + 1] == B[j + 1]) { // 스왑한 후 두 수 비교
                        if (Arrays.equals(A, B)) // 전체 비교
                            return 1;
                    }

                    isChange = true; // 스왑했다면 true, 바뀐 것이 없다면 false
                }
            }
            if (!isChange) // 바뀐 값이 없다면 정렬이 끝이므로 종료
                break;
        }

        return 0;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}