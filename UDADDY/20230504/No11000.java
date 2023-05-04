import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures); // 시작 순서 오름차순, 시작 같을 시 종류 순서 오름차순

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].start) {
                pq.poll();
            }
            pq.add(lectures[i].end);
        }

        System.out.println(pq.size());
    }
}

class Lecture implements Comparable<Lecture> {
    public int start;
    public int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
        if (start > o.start) // 시작 시간 오름차순
            return 1;
        else if (start == o.start) { // 시작 시간이 같을 시
            if (end < o.end) { // 종료 시간 오름차순
                return -1;
            } else {
                return 1;
            }
        } else
            return -1;
    }
}