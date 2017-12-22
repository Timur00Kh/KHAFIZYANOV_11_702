package ru.itis;

import java.util.ArrayList;

public class MatrixImpl  implements Matrix {
    public ArrayList<MatrixCell> m = new ArrayList();

    @Override
    public void set(int i, int j, int value) {
        MatrixCell cell = new MatrixCell(i, j, value);
        boolean contains = false;
        for (int a = 0; a < m.size(); a++){
            if (m.get(a).equals(cell)) {
                contains = true;
                break;
            }
        }
        if (!contains) m.add(cell);
    }

    @Override
    public int get(int i, int j) {
        for (int a = 0; a < m.size(); a++){
            if (m.get(a).getI() == i && m.get(a).getJ() == j) {
                return m.get(a).getValue();
            }
        }
        return 0;
    }
}

/*
4
1 200 10
80 3 6
1 1 15
1 1 16
*/
