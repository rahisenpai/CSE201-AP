abstract class Complex <T> {
    T r,i;
    Complex(T r, T i){
        this.r = r;
        this.i = i;
    }
    abstract public void add(Complex<T> x);
    abstract public void multiply(Complex<T> x);
    abstract public double argument();
    abstract public double magnitude();
    abstract public String toString();
}