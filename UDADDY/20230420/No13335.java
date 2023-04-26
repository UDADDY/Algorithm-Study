import java.util.Scanner;

public class No13335 {
    static int[] truckArr;
    static int[] bridge;
    static int bridgeLength;
    static int maxWeight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        bridgeLength = sc.nextInt();
        maxWeight = sc.nextInt();

        bridge = new int[bridgeLength];
        truckArr = new int[n];
        for (int i = 0; i < n; i++)
            truckArr[i] = sc.nextInt();

        int truckPointer = 0;
        int cnt = 0;

        while (true) {
            // 종료 조건
            if (truckPointer >= n && isBridgeEmpty())
                break;

            // 다리에 있는 트럭들 한 칸 이동
            moveTrucksOnBridge();

            // 다리에 트럭 삽입
            // 추가할 시 MaxWeight보다 작다면, 트럭 삽입
            if (truckPointer < n) {
                if (truckArr[truckPointer] + getWeightTrucksOnBridge() <= maxWeight) {
                    bridge[0] = truckArr[truckPointer];
                    truckPointer++;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean isBridgeEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < bridgeLength; i++) {
            if (bridge[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static int getWeightTrucksOnBridge() {
        int weight = 0;
        for (int i = 0; i < bridgeLength; i++)
            weight += bridge[i];

        return weight;
    }

    private static void moveTrucksOnBridge() {
        for (int i = bridgeLength - 1; 1 <= i; i--)
            bridge[i] = bridge[i - 1];
        bridge[0] = 0;
    }
}