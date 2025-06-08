package day_of_the_week;

public class Solution {


    public String dayOfTheWeek(int day, int month, int year) {
        if (year < 1 || month < 1 || day > 31 || month > 12) {
            return "Invalid Date";
        }

        long totalDays = 0;

        for (int y = 1; y < year; y++) {
            if (isLeapYear(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m];
        }

        totalDays += day;

        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int dayIndex = (int) (totalDays % 7);

        return daysOfWeek[dayIndex];
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.dayOfTheWeek(31, 8, 2019));
    }
}
