public class Main {
    public static void main(String[] args){
        Complex<Integer> c = new ComplexInteger(1,3);
        //Complex<Fraction> d = new ComplexFraction(1,3,2,3);
        Fraction f = new Fraction(2,3);
        Fraction f1 = new Fraction(6,3);
        f.multiply(f1);
        System.out.println(f);
        System.out.println(c);
    }
}