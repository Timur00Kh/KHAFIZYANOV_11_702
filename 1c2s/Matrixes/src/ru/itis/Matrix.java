package ru.itis;

import java.io.Serializable;

public interface Matrix<T> extends Serializable {
    void transpose();
    Matrix multiply(Matrix m);
    Matrix sum(Matrix m);
}
