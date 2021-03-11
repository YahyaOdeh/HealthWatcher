package com.example.yo7a.healthwatcher.Math;

/**
 * The <code>Vector</code> class provides some useful static functions to
 * compute vectors.
 *
 * @author Michael Lambertz
 */
public class Vector {

    public static double[] normalize(double[] input) {
        double sumSquares = 0.0;
        // First calculate the length
        for (int i = 0; i < input.length; i++) {
            sumSquares += Math.pow(input[i], 2);
        }
        // The actual length of the vector
        double len = Math.sqrt(sumSquares);
        return Vector.scale(1 / len, input);
    }

    /**
     * Inverts every element of the vector.
     *
     * @param inVector the vector
     * @return the resulting vctor
     */
    public static double[] invVector(
            double[] inVector) {

        int m = inVector.length;
        double[] outVector = new double[m];
        for (int i = 0; i < m; ++i) {
            if (inVector[i] != 0) {
                outVector[i] = 1 / inVector[i];
            } else {
                outVector[i] = 0;
            }
        }
        return (outVector);
    }

    /**
     * Compares the content of two string objects.
     *
     * @param vec1 the first vector
     * @param vec2 the second vector
     * @return true, if the vectors are equal
     */
    public static boolean equals(double[] vec1, double[] vec2) {
        if (vec1.length != vec2.length) {
            return (false);
        }
        for (int i = 0; i < vec1.length; ++i) {
            if (vec1[i] != vec2[i]) {
                return (false);
            }
        }
        return (true);
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
     * Converts a vector object into a <code>String</code> object
     * representing its content.
     *
     * @param vector the vector to be converted to a string
     * @return the string representing the content of the vector
     */
    public static String toString(double[] vector) {
        String result = "";
        for (int i = 0; i < vector.length; ++i) {
            result += fillString(Double.toString(vector[i]), 24) + "\n";
        }
        return (result);
    }

    /**
     * Builds a new m-dimensional vector object. Its content is undefined.
     *
     * @param m number of elements
     * @return the new vector
     */
    public static double[] newVector(int m) {
        return (new double[m]);
    }

    /**
     * Builds a new m-dimensional vector object, whose elements
     * have a predefined value.
     *
     * @param m   number of elements
     * @param val the element's value
     * @return the new vector
     */
    public static double[] newVector(int m, double val) {
        double[] res = new double[m];
        for (int i = 0; i < m; ++i) {
            res[i] = val;
        }
        return (res);
    }

    /**
     * Scales a vector and returns the result in a new
     * vector object.
     *
     * @param vector the vector to scale
     * @param fac    the factor to scale with
     * @return the scaled vector
     */
    public static double[] scale(double fac, double[] vector) {
        int n = vector.length;
        double[] res = new double[n];
        for (int i = 0; i < n; ++i) {
            res[i] = fac * vector[i];
        }
        return (res);
    }

    /**
     * Calculates the scalar product of two vectors.
     *
     * @param vec1 the first vector
     * @param vec2 the second vector
     * @return the scalar product of the vectors
     */
    public static double dot(double[] vec1, double[] vec2) {
        int n = vec1.length;
        double res = 0.0;
        for (int i = 0; i < n; ++i) {
            res += vec1[i] * vec2[i];
        }
        return (res);
    }

    /**
     * Adds two vectors and returns the result in a new vector object.
     *
     * @param vec1 the first vector
     * @param vec2 the second vector
     * @return the resulting vector
     */
    public static double[] add(double[] vec1, double[] vec2) {
        int m = vec1.length;
        double[] res = new double[m];
        for (int i = 0; i < m; ++i) {
            res[i] = vec1[i] + vec2[i];
        }
        return (res);
    }

    /**
     * Subtracts two vectors and returns the result in a new vector object.
     *
     * @param vec1 the first vector
     * @param vec2 the second vector
     * @return the resulting vector
     */
    public static double[] sub(double[] vec1, double[] vec2) {
        int m = vec1.length;
        double[] res = new double[m];
        for (int i = 0; i < m; ++i) {
            res[i] = vec1[i] - vec2[i];
        }
        return (res);
    }

    /**
     * Generates a copy of a given vector.
     *
     * @param vector the vector to copy
     * @return the copied vector
     */
    public static double[] clone(double[] vector) {
        int m = vector.length;
        double[] res = new double[m];
        for (int i = 0; i < m; ++i) {
            res[i] = vector[i];
        }
        return (res);
    }

    /**
     * Generates a random m-dimensional vector object.
     *
     * @param m the number of elements
     * @return the random vector
     */
    public static double[] random(int m) {
        double[] res = new double[m];
        for (int i = 0; i < m; ++i) {
            res[i] = Math.random();
        }
        return (res);
    }

    /**
     * Adds a vector to every vector in a set.
     *
     * @param vecSet the set of vectors
     * @param addVec the vector to subtract
     * @return the resulting set
     */
    public static double[][] addVecToSet(
            double[][] vecSet,
            double[] addVec) {
        int m = Matrix.getNumOfRows(vecSet);
        int n = Matrix.getNumOfColumns(vecSet);
        double[][] res = Matrix.newMatrix(m, n);
        for (int i = 0; i < m; ++i) {
            double add = addVec[i];
            for (int j = 0; j < n; ++j) {
                res[i][j] = vecSet[i][j] + add;
            }
        }
        return (res);
    }

    public static double[] center(double[] vec) {
        int n = vec.length;
        double mValue = 0.0;
        for (int i = 0; i < n; i++) {
            mValue += vec[i];
        }
        mValue /= n;

        double[] cVec = new double[n];
        for (int i = 0; i < n; i++) {
            cVec[i] = vec[i] - mValue;
        }
        return cVec;
    }
}
