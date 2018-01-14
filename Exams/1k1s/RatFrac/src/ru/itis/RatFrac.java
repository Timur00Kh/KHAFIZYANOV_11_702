package ru.itis;

public class RatFrac {
    int anInt = 0;
    int nom;
    int denom;

    public RatFrac(int i, int n, int d) {
        this.anInt = i;
        this.nom = n;
        this.denom = d;
        if (d == 0) this.denom = 1;
    }

    public void print() {
        System.out.println(this.anInt + " + " + this.nom + "/" + this.denom);
    }

    public void toProper() {
        if (this.denom != 0 && Math.abs(this.nom / this.denom) > 1) {
            this.anInt += this.nom / this.denom;
            this.nom = this.nom % this.denom;
        }
    }

    public void divide(RatFrac r) {
        this.nom = (this.anInt * this.denom + this.nom) * r.denom;
        this.denom = this.denom * (r.anInt * r.denom + r.nom);
        this.anInt = 0;
        this.toProper();
    }

    public void subtract(RatFrac r) {
        this.nom = (this.anInt * this.denom + this.nom) * r.denom - (r.anInt * r.denom + r.nom) * this.denom;
        this.denom *= r.denom;
        this.anInt = 0;
        this.toProper();
    }
}
