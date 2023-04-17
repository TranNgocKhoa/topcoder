import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double minimalDistance(int[] x, int y[]) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            points.add(new Point(x[i], y[i]));
        }

        return Math.sqrt(getMinDistance(points));
    }

    static long getMinDistance(List<Point> points) {
        if (points.size() <= 4) {
            long min = Long.MAX_VALUE;
            for (int i = 0; i < points.size(); i++) {
                for (int j = 0; j < points.size(); j++) {
                    if (i != j) {
                        long distance = distance(points.get(i), points.get(j));
                        if (distance < min) {
                            min = distance;
                        }
                    }
                }
            }

            return min;
        } else {
            Collections.sort(points , (o1, o2) -> (int) (o1.x - o2.x));
            int midIndex = points.size() / 2;
            long midX = points.get(midIndex).x;

            long leftDistance = getMinDistance(points.subList(0, midIndex));
            long rightDistance = getMinDistance(points.subList(midIndex, points.size()));

            long minDistance = Math.min(leftDistance, rightDistance);

            List<Point> stripPoints = new ArrayList<>();

            for (Point point : points) {
                if ((point.x - midX) * (point.x - midX) < minDistance) {
                    stripPoints.add(point);
                }
            }
            Collections.sort(stripPoints, (o1, o2) -> (int) (o1.y - o2.y));

            for (int i = 0; i < stripPoints.size(); i++) {
                for (int j = 1; j < Math.min(i + 8, stripPoints.size()); j++) {
                    if (i == j) {
                        continue;
                    }
                    minDistance = Math.min(minDistance, distance(stripPoints.get(i), stripPoints.get(j)));
                }
            }

            return minDistance;
        }
    }

    static long distance(Point first, Point second) {
        return (first.x - second.x) * (first.x - second.x) + (first.y - second.y) * (first.y - second.y);
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(String.format("%.4f", minimalDistance(x, y)));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}