package meeting_rooms;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static int mostBooked(int[][] meetings, int rooms) {
        int[] count = new int[rooms];

        PriorityQueue<Integer> available = new PriorityQueue<Integer>();  
        PriorityQueue<long[]> usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        for (int i = 0; i < rooms; i++) {
            available.offer(i);
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < meetings.length; i++) {
            long startTime = meetings[i][0];
            long endTime = meetings[i][1];

            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= startTime) {
                int room = (int) usedRooms.poll()[1];
                available.offer(room);
            }

            if (available.isEmpty()) {
                long end = usedRooms.peek()[0];
                int room = (int) usedRooms.poll()[1];
                endTime = end + (endTime - startTime);
                available.offer(room);
            }

            int room = available.poll();
            usedRooms.offer(new long[]{endTime, room});
            count[room]++;
        }

        int maxMeetingsRoom = 0;
        for (int i = 1; i < rooms; i++) {
            if (count[i] > count[maxMeetingsRoom]) {
                maxMeetingsRoom = i;
            }
        }

        return maxMeetingsRoom;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][][] meetings = {
            {{0, 10}, {1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}},
            {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}},
            {{1, 2}, {0, 10}, {2, 3}, {3, 4}},
            {{0, 2}, {1, 2}, {3, 4}, {2, 4}},
            {{1, 9}, {2, 8}, {3, 7}, {4, 6}, {5, 11}}
        };

        int[] rooms = {3, 3, 2, 4, 3};

        for (int i = 0; i < meetings.length; i++) {
            System.out.println((i + 1) + ".\tMeetings: " + Arrays.deepToString(meetings[i]));
            System.out.println("\tRooms: " + rooms[i]);
            int bookedRoom = solution.mostBooked(meetings[i], rooms[i]);
            System.out.println("\tRoom that held the most meetings: " + bookedRoom);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}