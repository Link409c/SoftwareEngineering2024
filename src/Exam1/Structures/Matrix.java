package Exam1.Structures;

/**
 * An object modeling a matrix of values, to be used in the Linear Algebra program.
 */
public class Matrix {
    /**
     * Override of the toString method provides a String, formatted as a table,
     * of the matrix for easy viewing.
     * @return the matrix as a string with each value rounded to 2 significant figures.
     */
    @Override
    public String toString(){
        double[][] theMatrix = getMatrix();
        StringBuilder matrixTable = new StringBuilder();
        for(double[] row : theMatrix){
            matrixTable.append("|");
            for(double value : row){
                //add each value of the row with 2 significant digits in table format
                matrixTable.append("[").append(String.format("%.2f", value))
                        .append("]\t");
            }
            //move to new line after each row
            matrixTable.append("|\n");
        }
        return matrixTable.toString();
    }
    /**
     * creates an empty matrix of the given size
     * @param rows number of rows
     * @param columns number of columns
     */
    public Matrix(int rows, int columns){
        double[][] newMatrix = new double[rows][columns];
        setMatrix(newMatrix);
    }
    public void setMatrix(double[][] aMatrix){
        this.matrix = aMatrix;
    }
    public double[][] getMatrix(){
        return matrix;
    }
    /**
     * a 2-D array of values.
     */
    private double[][] matrix;
}
