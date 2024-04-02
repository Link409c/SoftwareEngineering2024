package Exam1.Program;

import Exam1.Structures.Matrix;

/**
 * An object designed to perform simple calculations on matrices. Implements a user-defined
 * Matrix Data Structure which holds a 2-Dimensional Array and row and column sizes.
 */
public class MatrixCalculator {
    /**
     * Computes the sum of two matrices of equal size.
     * @param matrixA the first matrix
     * @param matrixB the second matrix
     * @return the sum of both matrices
     */
    public Matrix addMatrices(Matrix matrixA, Matrix matrixB) {
        //if the matrices are the same size,
        if (matrixA.getMatrix().length == matrixB.getMatrix().length) {
            int rows = matrixA.getNumRows();
            int columns = matrixA.getNumColumns();
            //make matrix to return using parameters
            Matrix sum = new Matrix(rows, columns);
            //loop through each element
            for (int i = 0; i < matrixA.getMatrix().length; i++) {
                double[] rowA = matrixA.getMatrix()[i];
                double[] rowB = matrixB.getMatrix()[i];
                for (int j = 0; j < matrixA.getMatrix()[i].length; j++) {
                    //add both elements and set value at appropriate new matrix index
                    sum.getMatrix()[i][j] = rowA[j] + rowB[j];
                }
            }
            return sum;
        } else {
            throw new IllegalArgumentException("Matrices are not equal size. Cannot compute sum.");
        }
    }

    /**
     * Computes the product of two matrices of equal size.
     * @param matrixA the first matrix
     * @param matrixB the second matrix
     * @return the product of both matrices
     */
    public Matrix multiplyMatrices(Matrix matrixA, Matrix matrixB) {
        //if the matrices are the same size,
        if (matrixA.getMatrix().length == matrixB.getMatrix().length) {
            int rows = matrixA.getNumRows();
            int columns = matrixA.getNumColumns();
            //make matrix to return using parameters
            Matrix product = new Matrix(rows, columns);
            //loop through each element
            for (int i = 0; i < matrixA.getMatrix().length; i++) {
                double[] rowA = matrixA.getMatrix()[i];
                double[] rowB = matrixB.getMatrix()[i];
                for (int j = 0; j < matrixA.getMatrix()[i].length; j++) {
                    //multiply both elements and set value at appropriate new matrix index
                    product.getMatrix()[i][j] = rowA[j] * rowB[j];
                }
            }
            return product;
        } else {
            throw new IllegalArgumentException("Matrices are not equal size. Cannot compute product.");
        }
    }

    /**
     * Transposes a Matrix, flipping the values about its main diagonal.
     * @param aMatrix the matrix of doubles to transpose.
     * @return the transposed matrix.
     */
    public Matrix transposeMatrix(Matrix aMatrix) {
        int rows = aMatrix.getNumRows();
        int columns = aMatrix.getNumColumns();
        Matrix transpose = new Matrix(rows, columns);
        double[][] tMatrix = transpose.getMatrix();
        double[][] originalMatrix = aMatrix.getMatrix();
        //counting down each row of the original,
        for (int i = rows; i >= 0; i--) {
            //counting down each column of the original,
            for (int j = columns; j >= 0; j--) {
                //subtract the current row and column index from the max
                int tRow = rows - i;
                int tCol = columns - j;
                //set the resulting index value of the transpose to the current index value
                tMatrix[tRow][tCol] = originalMatrix[i][j];
            }
        }
        return transpose;
    }

    /**
     * determines if a matrix is symmetric; that is, if it is equal to its transpose.
     * @param aMatrix the matrix to examine
     * @return true if the matrix is symmetric.
     */
    public boolean isSymmetric(Matrix aMatrix) {
        Matrix theTranspose = transposeMatrix(aMatrix);
        return aMatrix == theTranspose;
    }

    /**
     * Computes the trace of a square Matrix.
     * @param aMatrix the passed matrix of doubles
     * @return the sum of the diagonal elements if the matrix is square.
     */
    public double trace(Matrix aMatrix) {
        //get rows and columns of the passed matrix
        int rows = aMatrix.getNumRows();
        int columns = aMatrix.getNumColumns();
        //if rows = columns,
        if (rows == columns) {
            //create variable to return
            double theTrace = 0;
            //for each row,
            for (int i = 0; i < rows; i++) {
                //for each column,
                for (int j = 0; j < columns; j++) {
                    //if row index = column index,
                    if (i == j) {
                        //add index value to the sum.
                        aMatrix.getMatrix()[i][j] += theTrace;
                    }
                }
            }
            return theTrace;
        } else {
            throw new IllegalArgumentException("Matrix is not square. Cannot compute trace.");
        }
    }

    public MatrixCalculator(){}
}
