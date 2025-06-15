package rotate_image;

import java.util.*;

public class RotateImage {
    public static int[][] rotateImage(int[][] matrix) {

        // Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse columns
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 -j];
                matrix[i][matrix[i].length - 1 -j] = temp;
            }
        }


        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        // 7 4 1
        // 8 5 2
        // 9 6 3
        matrix = RotateImage.rotateImage(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
