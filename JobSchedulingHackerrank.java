import java.util.*;

public class JobSchedulingHackerrank {
    public static int getCount(List<Integer> jobList, int x, int y) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(jobList);

        int count = 0;
        while (!queue.isEmpty()) {
            PriorityQueue<Integer> newQueue = new PriorityQueue<>(Collections.reverseOrder());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer job = queue.poll();
                if (i == 0) {
                    if (job - x > 0) {
                        newQueue.add(job - x);
                    }
                } else {
                    if (job - y > 0) {
                        newQueue.add(job - y);
                    }
                }
            }

            count++;
            queue = newQueue;
        }

        return count;
    }

    public static int getCount2(List<Integer> jobList, int x, int y) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(jobList);

        int count = 0;
        while (!queue.isEmpty()) {
            Integer max = queue.poll();
            Integer secondMax = queue.poll();
            int currentCount = 0;

            if (secondMax != null) {
                if (max <= x) {
                    currentCount = 1;
                } else {
                    currentCount = Math.min((max - secondMax) / (x - y) + 1, secondMax / y + 1);
                }
                int size = queue.size();
                PriorityQueue<Integer> newQueue = new PriorityQueue<>(Collections.reverseOrder());
                for (int i = 0; i < size; i++) {
                    Integer integer = queue.poll();
                    int remain = integer - (currentCount * y);
                    if (remain > 0) {
                        newQueue.add(remain);
                    }
                }

                if (max - (currentCount * x) > 0) {
                    newQueue.add(max - (currentCount * x));
                }

                if (secondMax - (currentCount * y) > 0) {
                    newQueue.add(secondMax - (currentCount * y));
                }

                queue = newQueue;
            } else {
                if (max <= x) {
                    currentCount = 1;
                } else if (max % x == 0) {
                    currentCount = max / x;
                } else {
                    currentCount = max / x + 1;
                }
            }

            count += currentCount;
        }

        return count;
    }


    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> objects = new ArrayList<>();


        Random random = new Random();
        for (int i = 0; i < 100_000; i++) {
            int i1 = random.nextInt(10000);
            integers.add(i1);
            objects.add(i1);
        }

//
//        integers.add(999);
//        objects.add(999);
//        integers.add(606);
//        objects.add(606);
//        integers.add(300);
//        objects.add(300);
//        integers.add(30);
//        objects.add(30);
//        integers.add(309);
//        objects.add(309);


        System.out.println("Start!");
        long start = System.currentTimeMillis();
        System.out.println(getCount2(objects, 14, 12));
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);

        System.out.println(getCount(integers, 14, 12));
        long end2 = System.currentTimeMillis();
        System.out.println((end2 - end) / 1000);
    }
}
