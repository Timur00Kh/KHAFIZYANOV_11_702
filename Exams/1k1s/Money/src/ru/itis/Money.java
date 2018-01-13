package ru.itis;

import java.io.PrintStream;

public class Money {
    long rub;
    byte kop;

    public Money(long r, byte k) {
        this.rub = r;
        this.kop = k;
        if (r < 0) this.kop = (byte)-k;
    }

    public void print() {

        String  s = Long.toString(this.rub) + ",%02d";
        System.out.format(s, this.kop);
    }

    public void plus(Money m) {
        int tempKop = this.kop + m.getKop();
        if (tempKop % 100 > 0) {
            tempKop = tempKop % 100;
            this.rub++;
        }
        this.rub += m.getRub();
        this.kop = (byte)tempKop;
    }

    public void minus(Money m) {
        int tempKop = this.kop - m.getKop();
        if (tempKop % 100 > 100 || tempKop % 100 < 100) {
            tempKop = tempKop % 100;
            this.rub--;
        }
        System.out.println(this.rub);
        System.out.println(this.kop);
        this.rub -= m.getRub();
        tempKop = 100 - tempKop;
        this.kop = (byte)tempKop;
    }

    public long getRub() {
        return rub;
    }

    public byte getKop() {
        return kop;
    }
}
