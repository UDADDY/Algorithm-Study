import java.util.Scanner;

public class No10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N + 1][10]; // row는 자릿수, column은 그에 해당하는 숫자를 의미함. ex) arr[5][3]은 다섯번째 자리가 3인 숫자

        // 1의 자리 숫자들 1로 설정
        for (int i = 0; i < 10; i++)
            arr[1][i] = 1;

        // 2의 자리 숫자들
        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) { // 자리값이 0이면 한자리 작은 수의 자리값이 1인 값만
                    arr[i][j] = arr[i - 1][j + 1] % 1000000000;
                } else if (j == 9) { // 자리값이 9이면 한자리 작은 수의 자리값이 8인 값만
                    arr[i][j] = arr[i - 1][j - 1] % 1000000000;
                } else {
                    arr[i][j] = (arr[i - 1][j + 1] + arr[i - 1][j - 1]) % 1000000000;
                }
            }
        }

        long sum = 0;
        for (int i = 1; i < 10; i++)
            sum += arr[N][i];

        System.out.println(sum % 1000000000);
    }

}