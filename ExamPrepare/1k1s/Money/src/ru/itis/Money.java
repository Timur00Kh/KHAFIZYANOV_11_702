package ru.itis;

import java.io.PrintStream;

public class Money {
    long rub;
    byte kop;

    public Money(long r, byte k) {
        this.rub = r;
        this.kop = k; //в этой проге знак копейки зависит от знака рубля. Сама же копейка всегда положительная
//        if (r < 0 && k > 0) this.kop = (byte)-k; //проверка на дурака
    }

    public double toDouble() {
        String s;
        if (this.getKop() < 10) {
            s = Long.toString(this.rub) + ".0" + Byte.toString(this.kop);
        } else {
            s = Long.toString(this.rub) + "." + Byte.toString(this.kop);
        }
        double d = Double.parseDouble(s);
        System.out.println(d);
        return d;
    }

    public void plus(Money m) {
        double tempSum = this.toDouble() + m.toDouble();
        this.rub = (long)tempSum;
        this.kop = (byte)Math.abs(Math.round((tempSum * 100) % 100));
    }

    public void print() {
        String  s = Long.toString(this.rub) + ",%02d";
        System.out.format(s, this.kop);
    }


    public byte getKop() {
        return kop;
    }

    public long getRub() {
        return rub;
    }
}

//    public void plus(Money m) {
//        int tempKop = this.kop + m.getKop();
//        if (tempKop % 100 > 100) {
//            tempKop = tempKop % 100;
//            this.rub++;
//        }
//        if (tempKop % 100 < 100) {
//            tempKop = tempKop % 100;
//            this.rub--;
//        }
//        this.rub += m.getRub();
//        this.kop = (byte)tempKop;
//    }
//
//    public void minus(Money m) {
//        int tempKop = this.kop - m.getKop();
//        if (tempKop % 100 > 100 || tempKop % 100 < 100) {
//            tempKop = tempKop % 100;
//            this.rub--;
//        }
//        System.out.println(this.rub);
//        System.out.println(this.kop);
//        this.rub -= m.getRub();
//        tempKop = 100 - tempKop;
//        this.kop = (byte)tempKop;
//    }
