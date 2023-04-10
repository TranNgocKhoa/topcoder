import java.util.Scanner;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        int[] points = new int[segments.length];
        int count = 0;
        int length = segments.length;
        while (length > 0) {
            int minEnd = segments[0].end;
            int minIndex = 0;
            for (int j = 0; j < length; j++) {
                if (segments[j].end < minEnd) {
                    minEnd = segments[j].end;
                    minIndex = j;
                }
            }

            points[count++] = minEnd;

            int newLength = 0;
            Segment[] newSegments = new Segment[segments.length - 1];
            for (int i = 0; i < length; i++) {
                if (minIndex != i && (segments[i].start > minEnd)) {
                    newSegments[newLength++] = segments[i];
                }
            }

            segments = newSegments;
            length = newLength;
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = points[i];
        }

        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}