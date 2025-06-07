package task_scheduler;

import java.util.*;

//
//To calculate the minimum time the CPU will take to perform the given tasks, we will follow these steps:
//
//Store the frequency of each task and then sort them based on these frequencies. Begin by calculating the maximum possible idle time, which is given by
//        (Max frequency−1)×cooling period.
//Here,
//Max frequency refers to the highest frequency of any task in the sequence, andcooling period is the specified interval between identical tasks. This formula represents the maximum time the CPU could remain idle between executions of tasks of the same type.
//
//Next, iterate over the sorted task frequencies and update the idle time accordingly by subtracting the idle time from the frequency of each task until the idle time becomes negative or all tasks have been processed. The adjustment to the idle time during each iteration is calculated as
//Idle Time−=min(Max Frequency−1, Current Task Frequency)
//,
//where
//Current Task Frequency represents the frequency of the task currently being processed.
//
//Finally, return the total time required, which is the sum of the length of the task sequence and the computed idle time, expressed as length of tasks+Idle Time
//.


public class Solution {
    public static int leastTime(char[] tasks, int n) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char t : tasks) {
            frequencies.put(t, frequencies.getOrDefault(t, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedFrequencies = new ArrayList<>(frequencies.entrySet());
        sortedFrequencies.sort(Map.Entry.comparingByValue());


        int maxFreq = sortedFrequencies.get(sortedFrequencies.size() - 1).getValue();
        sortedFrequencies.remove(sortedFrequencies.size() - 1);

        int idleTime = (maxFreq - 1) * n;

        while (!sortedFrequencies.isEmpty() && idleTime > 0) {
            idleTime -= Math.min(maxFreq - 1, sortedFrequencies.get(sortedFrequencies.size() - 1).getValue());
            sortedFrequencies.remove(sortedFrequencies.size() - 1);
        }
        idleTime = Math.max(0, idleTime);

        return tasks.length + idleTime;
    }

    // Driver code
    public static void main(String[] args) {
        char[][] allTasks = {
                {'A', 'A', 'B', 'B'},
                {'A', 'A', 'A', 'B', 'B', 'C', 'C'},
                {'S', 'I', 'V', 'U', 'W', 'D', 'U', 'X'},
                {'M', 'A', 'B', 'M', 'A', 'A', 'Y', 'B', 'M'},
                {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'}};

        int[] allNs = {2, 1, 0, 3, 3};

        for (int i = 0; i < allTasks.length; i++) {
            System.out.print((i + 1) + ".\tTasks: ");
            char[] tasks = allTasks[i];
            for (int j = 0; j < tasks.length; j++) {
                System.out.print(tasks[j]);
                if (j != tasks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n\tn: " + allNs[i]);

            int minTime = leastTime(allTasks[i], allNs[i]);
            System.out.println("\tMinimum time required to execute the tasks: " + minTime);
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
