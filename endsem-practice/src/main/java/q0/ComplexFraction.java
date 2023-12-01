public class ComplexFraction extends Complex<Fraction> {
    ComplexFraction(int a1, int b1, int a2, int b2){
        super(new Fraction(a1, b1), new Fraction(a2, b2));
    }

    public void add(Complex<Fraction> x){
        this.r.add(x.r);
        this.i.add(x.i);
    }

    public void multiply(Complex<Fraction> x){
        // this.r = this.r.multiply(x.r) - this.i.multiply(x.i);
        // this.i = this.i.multiply(x.r).add(this.r.multiply(x.i));
    }

    public double argument(){
        return Math.atan(this.i.getNum()*this.r.getDen()/this.r.getNum()*this.i.getDen());
    }

    public double magnitude(){
        // return Math.pow((this.r.multiply(this.r)).add(this.i.multiply(this.i)), 0.5);
        return 0.1;
    }

    public String toString(){
        return this.r + "+" + this.i + "i";
    }
}