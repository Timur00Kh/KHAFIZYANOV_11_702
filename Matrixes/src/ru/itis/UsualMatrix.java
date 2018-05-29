package ru.itis;

public class UsualMatrix<T> implements Matrix{

    int width;
    int height;
    T matrix[][];

    UsualMatrix(T[][] m){
        matrix = m;
        width = matrix[0].length;
        height = matrix.length;
    }

    @Override
    public void transpose() {
        for (int i = 0; i < width; i++) {
            for (int j = i+1; j < height; j++) {
                T temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    @Override
    public Matrix multiply(Matrix m) {

        return null;
    }

    @Override
    public Matrix sum(Matrix m) {
        return null;
    }

    public void print(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
