package ru.itis;

public class MyArray {
    int count = 0;
    MyDot dots[];
    int removedCount = 0;
    int callCount = 0;

    public MyArray(int n) {
        this.dots = new MyDot[n];
    }

    public void add(MyDot dot) {
        dots[count] = dot;
        count++;
    }

    void sort() throws Exception {
        int N = dots.length;
        for (int k = N / 2; k > 0; k--) {
            downheap(dots, k, N);
            callCount++;
        };
        do {
            MyDot T = dots[0];
            dots[0] = dots[N - 1];
            dots[N - 1] = T;
            N = N - 1;
            downheap(dots, 1, N);
            callCount++;
        } while (N > 1);
    }

    void downheap(MyDot a[], int k, int N) throws Exception {
        MyDot T = a[k - 1];
        //Смотрим потомков в пределах ветки
        while (k <= N / 2) {
            int j = k + k;//Левый потомок
            //Если есть правый потомок,
            //то сравниваем его с левым
            //и из них выбираем наибольший
            if ((j < N) && (a[j].isGreater(a[j - 1]))) j++;
            //Если родитель больше (или равен) наибольшего потомка...
            if (T.isGreaterOrEqual(a[j - 1])) {
                //... то значит всё в порядке в этой ветке
                break;
            } else { //Если родитель меньше наибольшего потомка...
                a[k - 1] = a[j - 1];
                k = j;
            }
            callCount++;
        }
        a[k - 1] = T;
    }


    public void print() {
        for (int i=0; i < dots.length; i++) {
            dots[i].print();
        }
        System.out.println("Размер массива: " + this.size());
        System.out.println("Метод сортировки был вызван " + callCount + " раз(а).");
    }

    public int size() {
        return count;
    }

    public int getX(int a) {
        return dots[a].x;
    }
    public int getY(int a) {
        return dots[a].y;
    }

    public void remove(int a) {
        dots[a].remove();
        removedCount++;
    }

    public boolean isNotRemoved(int a) {
        return dots[a].isNotRemoved;
    }

    public int getRemovedCount() {
        return removedCount;
    }

    public MyDot getDot(int i) {
        return dots[i];
    }
}

//15 1 9 7 5 2 7 2 4 1 3 8 5 1 5 12 5 6 11 4 7 2 3 3 4 4 9 4 1 6 8