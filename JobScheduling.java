import java.util.ArrayList;

public class JobScheduling {
    static class Job {

        char id;
        int deadline, profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static void printJobScheduling(ArrayList<Job> arr) {
        // Length of array
        int n = arr.size();
        arr.sort((a, b) -> b.profit - a.profit);
        char[] jobs = new char[arr.size()];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = arr.get(i).id;
        }

        boolean[] slots = new boolean[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            int deadline = arr.get(i).deadline;

            for (int j = deadline - 1; j >= 0; j--) {
                if (j <= n - 1) {
                    if (!slots[j]) {
                        slots[j] = true;
                        char temp = jobs[j];
                        jobs[j] = jobs[i];
                        jobs[i] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < jobs.length; i++) {
            System.out.println(jobs[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<Job>();
        arr.add(new Job('a', 2, 50));
        arr.add(new Job('b', 1, 20));
        arr.add(new Job('c', 2, 30));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));

        printJobScheduling(arr);
    }
}
