public class ComplexInteger extends Complex <Integer> {

    ComplexInteger(Integer r, Integer i){
        super(r, i);
    }

    public void add(Complex<Integer> x){
        this.r += x.r;
        this.i += x.i;
    }

    public void multiply(Complex<Integer> x){
        this.r = this.r*x.r - this.i*x.i;
        this.i = this.i*x.r + this.r*x.i;
    }

    public double argument(){
        return Math.atan(this.i/this.r);
    }

    public double magnitude(){
        return Math.pow((this.r*this.r + this.i*this.i), 0.5);
    }

    public String toString(){
        return this.r + "+" + this.i + "i";
    }
}