import java.io.*;
import java.util.*;

class RandomizedQuickSort {
    private static final Random random = new Random();

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int[] partition(int[] a, int l, int r) {
        int pivot = a[l];
        int m1 = l;
        int m2 = l + 1;
        for (int i = l + 1; i < r; i++) {
            if (a[i] < pivot) {
                swap(a, m1, i);
                swap(a, i, m2);
                m1++;
                m2++;
            } else if (a[i] == pivot) {
                swap(a, m2, i);
                m2++;
            }
        }
        return new int[]{m1, m2};
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l + 1 >= r) {
            return;
        }
        int k = random.nextInt(r - l) + l;

        swap(a, l, k);

        int[] m = partition(a, l, r);
        randomizedQuickSort(a, l, m[0]);
        randomizedQuickSort(a, m[1], r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}