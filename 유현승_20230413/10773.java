import java.util.Scanner;

public class No10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int cur = 0;

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();

            if (input == 0) {
                arr[cur] = 0;
                cur--;
            } else {
                arr[cur] = input;
                cur++;
            }
        }

        int sum = 0;
        for (int i = 0; i < cur; i++) {
            sum += arr[i];
        }


//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            int input = sc.nextInt();
//
//            if (input == 0)
//                list.remove(list.size() - 1);
//            else
//                list.add(input);
//        }
//
//        int sum = 0;
//        for (int i : list)
//            sum += i;
//
        System.out.println(sum);


    }
}