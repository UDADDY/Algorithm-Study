import java.util.Scanner;

public class No2606 {
    public static int[] root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countOfComputers = sc.nextInt();
        int countOfPairs = sc.nextInt();

        root = new int[countOfComputers + 1];

        for (int i = 1; i < countOfComputers + 1; i++)
            root[i] = i;

        for (int i = 0; i < countOfPairs; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            union(first, second);
        }

        int cnt = 0;
        int target = find(1);
        for (int i = 1; i < countOfComputers + 1; i++) {
            if (find(i) == target)
                cnt++;
        }

        System.out.println(cnt - 1);
    }

    public static int find(int x) {
        if (root[x] == x)
            return x;
        else
            return find(root[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        root[y] = x;
    }

}