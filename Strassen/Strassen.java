public class Strassen {
    public static void main (String[] args) {
    }

    // assumes x and y have equal dimensions, N x N, where N is a power of 2
    public static int[][] multiply(int[][] x, int[][] y) {
        int n = x.length;
        int[][] result = new int[n][n];
        if (n <= 1) {
            result[0][0] = x[0][0] * y[0][0];
            return result;
        }

        // divide the matrices x and y into four equally sized submatrices
        int m = n/2;
        int[][][][] xSubmatrices = new int[2][2][m][m];
        int[][][][] ySubmatrices = new int[2][2][m][m];
        for (int submatrixRow = 0; submatrixRow < 2; submatrixRow++) {
            for (int submatrixColumn = 0; submatrixColumn < 2; submatrixColumn++) {
                for (int row = 0; row < m; row++) {
                    for (int column = 0; column < m; column++) {
                        xSubmatrices[submatrixRow][submatrixColumn][row][column] = x[(m*submatrixRow)+row][(m*submatrixColumn)+column];
                        ySubmatrices[submatrixRow][submatrixColumn][row][column] = y[(m*submatrixRow)+row][(m*submatrixColumn)+column];
                    }
                }
            }
        }

        // recursive step: compute the 7 magical matrix products, which save us from recusively having to compute an 8th
        int[][] m1 = multiply(xSubmatrices[0][0], subtract(ySubmatrices[0][1], ySubmatrices[1][1]));
        int[][] m2 = multiply(add(xSubmatrices[0][0], xSubmatrices[0][1]), ySubmatrices[1][1]);
        int[][] m3 = multiply(add(xSubmatrices[1][0], xSubmatrices[1][1]), ySubmatrices[0][0]);
        int[][] m4 = multiply(xSubmatrices[1][1], subtract(ySubmatrices[1][0], ySubmatrices[0][0]));
        int[][] m5 = multiply(add(xSubmatrices[0][0], xSubmatrices[1][1]), add(ySubmatrices[0][0], ySubmatrices[1][1]));
        int[][] m6 = multiply(subtract(xSubmatrices[0][1], xSubmatrices[1][1]), add(ySubmatrices[1][0], ySubmatrices[1][1]));
        int[][] m7 = multiply(subtract(xSubmatrices[0][0], xSubmatrices[1][0]), add(ySubmatrices[0][0], ySubmatrices[0][1]));

        // use the magical matrices to form the result's sub matrices
        int[][][][] resultSubmatrices = new int[2][2][m][m];
        resultSubmatrices[0][0] = add(m5, add(subtract(m4, m2), m6));
        resultSubmatrices[0][1] = add(m1, m2);
        resultSubmatrices[1][0] = add(m3, m4);
        resultSubmatrices[1][1] = add(m1, subtract(subtract(m5, m3), m7));

        // combine the result submatrices into the final result
        for (int submatrixRow = 0; submatrixRow < 2; submatrixRow++) {
            for (int submatrixColumn = 0; submatrixColumn < 2; submatrixColumn++) {
                for (int row = 0; row < m; row++) {
                    for (int column = 0; column < m; column++) {
                        result[(m*submatrixRow)+row][(m*submatrixColumn)+column] = resultSubmatrices[submatrixRow][submatrixColumn][row][column];
                    }
                }
            }
        }

        return result;
    }

    private static int[][] add(int[][] x, int[][] y) {
        int n = x.length;
        int[][] result = new int[n][n];

        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++) {
                result[row][column] = x[row][column] + y[row][column];
            }
        }

        return result;
    }


    private static int[][] subtract(int[][] x, int[][] y) {
        int n = x.length;
        int[][] result = new int[n][n];

        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++) {
                result[row][column] = x[row][column] - y[row][column];
            }
        }

        return result;
    }
}
