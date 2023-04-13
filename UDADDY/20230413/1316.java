import java.util.Scanner;

public class No1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int sum = 0;

        for (int z = 0; z < N; z++) {
            String input = sc.nextLine();
            boolean[] alphabet = new boolean[26];
            for (int i = 0; i < 26; i++)
                alphabet[i] = true;

            boolean flag = true;
            for (int i = 0; i < input.length(); ) {
                int index = input.charAt(i) - 'a';

                if (alphabet[index] == false) {
                    flag = false;
                    break;
                }

                if (alphabet[index] == true) {

                    alphabet[index] = false;
                    int j;
                    for (j = 1; ; ) {
                        if (i + j == input.length())
                            break;
                        if (input.charAt(i + j) == input.charAt(i)) {
                            j++;
                        } else {
                            break;
                        }
                    }
                    i += j;
                }
            }

            if (flag)
                sum++;
        }

        System.out.println(sum);

    }
}