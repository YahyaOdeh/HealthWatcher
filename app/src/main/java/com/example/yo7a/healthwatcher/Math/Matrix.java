package com.example.yo7a.healthwatcher.Math;

/**
 * The <code>Matrix</code> class provides some useful static functions to
 * compute matrices.
 * Here two-dimensional arrays represent matrices and are taken as
 * columns of rows.
 *
 * @author Michael Lambertz
 */
public class Matrix {

    public static double[][] normalize(double[][] m) {
        double[][] newM = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            newM[i] = Vector.normalize(m[i]);
        }
        return newM;
    }

    /**
     * Square roots every element of the vector.
     *
     * @param inVector the vector
     * @return the resulting vector
     */
    public static double[] sqrtVector(
            double[] inVector) {
        int m = inVector.length;
        double[] outVector = new double[m];
        for (int i = 0; i < m; ++i) {
            outVector[i] = Math.sqrt(Math.abs(inVector[i]));
        }
        return (outVector);
    }

    /**
     * Fills a string with blanks until it reaches a desired length.
     *
     * @param in  string to fill
     * @param len desired length
     * @return the input string eventually suffixed with blanks
     */
    private static String fillString(String in, int len) {
        String out = in;
        while (out.length() < len) {
            out = " " + out;
        }
        return (out);
    }

    /**
     * Converts a matrix object into a <code>String</code> object
     * representing its content.
     *
     * @param matrix the matrix to be converted to a string
     * @return the string representing the content of the matrix
     */
    public static String toString(double[][] matrix) {
        String retVal = "";
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                retVal += fillString(Double.toString(matrix[i][j]), 24);
            }
            retVal += "\n";
        }
        return (retVal);
    }

    /**
     * Adds two matrices and returns the result in a new matrix object.
     *
     * @param mat1 the first matrix
     * @param mat2 the second matrix
     * @return the resulting matrix
     */
    public static double[][] add(double[][] mat1, double[][] mat2) {
        int m = mat1.length;
        int n = mat1[0].length;
        double[][] matres = new double[m][];
        for (int i = 0; i < m; ++i) {
            matres[i] = new double[n];
            for (int j = 0; j < n; ++j) {
                matres[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return (matres);
    }

    /**
     * Subtracts two matrices and returns the result in a new matrix object.
     *
     * @param mat1 the first matrix
     * @param mat2 the second matrix
     * @return the resulting matrix
     */
    public static double[][] sub(double[][] mat1, double[][] mat2) {
        int m = mat1.length;
        int n = mat1[0].length;
        double[][] matres = new double[m][];
        for (int i = 0; i < m; ++i) {
            matres[i] = new double[n];
            for (int j = 0; j < n; ++j) {
                matres[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
        return (matres);
    }

    /**
     * Multiplicates two matrices and returns the result in a new matrix object.
     *
     * @param mat1 the first matrix
     * @param mat2 the second matrix
     * @return the resulting matrix
     */
    public static double[][] mult(double[][] mat1, double[][] mat2) {
        int m = mat1.length;
        int n = mat1[0].length;
        int o = mat2[0].length;
        double[][] matres = new double[m][];
        for (int i = 0; i < m; ++i) {
            matres[i] = new double[o];
            for (int j = 0; j < o; ++j) {
                matres[i][j] = 0.0f;
                for (int k = 0; k < n; ++k) {
                    matres[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return (matres);
    }

    /**
     * Performs a matrix vector multiplication and returns the result
     * in a new vector object.
     *
     * @param mat the matrix
     * @param vec the vector
     * @return the resulting vector
     */
    public static double[] mult(double[][] mat, double[] vec) {
        int m = mat.length;
        int n = mat[0].length;
        double[] vecres = new double[m];
        for (int i = 0; i < m; ++i) {
            vecres[i] = 0.0f;
            for (int j = 0; j < n; ++j) {
                vecres[i] += mat[i][j] * vec[j];
            }
        }
        return (vecres);
    }

    /**
     * Scales all elements of the matrix and returns the result
     * in a new matrix object.
     *
     * @param mat the matrix to scale
     * @param fac the factor to scale with
     * @return the scaled matrix
     */
    public static double[][] scale(double[][] mat, double fac) {
        int m = mat.length;
        int n = mat[0].length;
        double[][] res = new double[m][];
        for (int i = 0; i < m; ++i) {
            res[i] = new double[n];
            for (int j = 0; j < n; ++j) {
                res[i][j] = mat[i][j] * fac;
            }
        }
        return (res);
    }

    /**
     * Generates a random m*n matrix object.
     *
     * @param m number of desired rows
     * @param n number of desired columns
     * @return the random matrix
     */
    public static double[][] random(int m, int n) {
        double[][] matres = new double[m][];
        for (int i = 0; i < m; ++i) {
            matres[i] = new double[n];
            for (int j = 0; j < n; ++j) {
                matres[i][j] = Math.random();
            }
        }
        return (matres);
    }

    /**
     * Builds a new m*n matrix object. Its content is undefined.
     *
     * @param m number of desired rows
     * @param n number of desired columns
     * @return the new matrix
     */
    public static double[][] newMatrix(int m, int n) {
        double[][] res = new double[m][];
        for (int i = 0; i < m; ++i) {
            res[i] = new double[n];
        }
        return (res);
    }

    /**
     * Builds a new m*n matrix object, whose elements have a
     * predefined value.
     *
     * @param m   number of desired rows
     * @param n   number of desired columns
     * @param val the element's value
     * @return the new matrix
     */
    public static double[][] newMatrix(int m, int n, double val) {
        double[][] res = new double[m][];
        for (int i = 0; i < m; ++i) {
            res[i] = new double[n];
            for (int j = 0; j < n; ++j) {
                res[i][j] = val;
            }
        }
        return (res);
    }

    /**
     * Transposes a matrix and returns the result in a new
     * matrix object.
     *
     * @param mat the matrix to transpose
     * @return the transposed matrix
     */
    public static double[][] transpose(double[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        double[][] res = new double[n][];
        for (int i = 0; i < n; ++i) {
            res[i] = new double[m];
            for (int j = 0; j < m; ++j) {
                res[i][j] = mat[j][i];
            }
        }
        return (res);
    }

    /**
     * Generates a copy of a given matrix.
     *
     * @param mat the matrix to copy
     * @return the copied matrix
     */
    public static double[][] clone(double[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        double[][] res = new double[m][];
        for (int i = 0; i < m; ++i) {
            res[i] = new double[n];
            for (int j = 0; j < n; ++j) {
                res[i][j] = mat[i][j];
            }
        }
        return (res);
    }

    /**
     * Generates an identity n*n matrix.
     *
     * @param n the number of rows and columns
     * @return the identity matrix
     */
    public static double[][] identity(int n) {
        double[][] res = newMatrix(n, n, 0.0);
        for (int i = 0; i < n; ++i) {
            res[i][i] = 1.0;
        }
        return (res);
    }

    /**
     * Generates a matrix, whose diagonal contains the content
     * of a given vector. The remaining elements of the matrix
     * contain zero.
     *
     * @param diag the diagonal vector
     * @return the resulting matrix
     */
    public static double[][] diag(double[] diag) {

        int n = diag.length;
        double[][] res = newMatrix(n, n, 0.0);
        for (int i = 0; i < n; ++i) {
            res[i][i] = diag[i];
        }

        return (res);
    }

    /**
     * Returns the <code>j</code>'th column of a matrix as a
     * new object.
     *
     * @param mat the matrix
     * @param j   the number of the column
     * @return a vector containing the column
     */
    public static double[] getVecOfCol(double[][] mat, int j) {
        int m = mat.length;
        double[] res = new double[m];
        for (int i = 0; i < m; ++i) {
            res[i] = mat[i][j];
        }
        return (res);
    }

    /**
     * Returns the <code>i</code>'th row of a matrix as a
     * new object.
     *
     * @param mat the matrix
     * @param i   the number of the row
     * @return a vector containing the row
     */
    public static double[] getVecOfRow(double[][] mat, int i) {
        int n = mat[0].length;
        double[] res = new double[n];
        for (int j = 0; j < n; ++j) {
            res[j] = mat[i][j];
        }
        return (res);
    }

    /**
     * Returns the number of columns of a matrix.
     *
     * @param mat the matrix
     * @return the number of its columns
     */
    public static int getNumOfColumns(double[][] mat) {
        return (mat[0].length);
    }

    /**
     * Returns the number of rows of a matrix.
     *
     * @param mat the matrix
     * @return the number of its rows
     */
    public static int getNumOfRows(double[][] mat) {
        return (mat.length);
    }

    /**
     * Calculates the square matrix A * A'.
     *
     * @param mat the input matrix
     * @return the squared matrix
     */
    public static double[][] square(
            double[][] mat) {
        int m = Matrix.getNumOfRows(mat);
        int n = Matrix.getNumOfColumns(mat);
        double[][] res = Matrix.newMatrix(m, m);
        for (int i = 0; i < m; ++i) {
            res[i][i] = 0.0;
            for (int k = 0; k < n; ++k) {
                res[i][i] += mat[i][k] * mat[i][k];
            }
            for (int j = 0; j < i; ++j) {
                res[i][j] = 0.0;
                for (int k = 0; k < n; ++k) {
                    res[i][j] += mat[i][k] * mat[j][k];
                }
                res[j][i] = res[i][j];
            }
        }
        return (res);
    }

    // only work for 3 x 3 matrix
    public static double[] invMatrix(double[] mat) {
        int n = mat.length;
        double[] res = new double[n];
        double det = 0.0;
        double predet = 0.0;

        predet = mat[0];
        for (int x = 1; x < 3; x++) {
            predet = predet * mat[x];
        }


        res[0] = mat[1] * mat[2];
        res[1] = mat[0] * mat[2];
        res[2] = mat[1] * mat[0];

        if (predet != 0) {
            det = 1 / predet;
            for (int x = 0; x < 3; x++) {
                res[x] = det * res[x];
            }
        } else {
            for (int x = 0; x < 3; x++) {
                res[x] = 0 * res[x];
            }
        }


        return (res);

    }
}

