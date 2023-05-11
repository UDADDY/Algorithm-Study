import java.util.Scanner;

public class No9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int[][] lcsBoard = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcsBoard[i][j] = lcsBoard[i - 1][j - 1] + 1;
                } else {
                    lcsBoard[i][j] = Math.max(lcsBoard[i - 1][j], lcsBoard[i][j - 1]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                if (max < lcsBoard[i][j])
                    max = lcsBoard[i][j];
            }
        }

        System.out.println(max);
    }
}