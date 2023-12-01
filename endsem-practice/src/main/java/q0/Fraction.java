public class Fraction {
    int a,b;
    Fraction(int a,int b){
        if (b==0){
            System.out.println("denominator cant be zero.");
            System.exit(1);
            return;
        }
        int hcf = gcd(a,b);
        this.a = a/hcf;
        this.b = b/hcf;
    }

    public int getNum(){
        return this.a;
    }
    public int getDen(){
        return this.b;
    }

    public void add(Fraction x){
        this.a = this.a*x.b + this.b*x.a;
        this.b = this.b*x.b;
        int hcf = gcd(this.a,this.b);
        this.a/=hcf;
        this.b/=hcf;
    }

    public void multiply(Fraction x){
        this.a = this.a*x.a;
        this.b = this.b*x.b;
        int hcf = gcd(this.a,this.b);
        this.a/=hcf;
        this.b/=hcf;
    }

    public String toString(){
        return this.a + "/" + this.b;
    }

    private int gcd(int a,int b){
        int res=1;
        int min = (a<b) ? a : b;
        int max = (a>b) ? b : a;
        for (int i=2; i<min; i++){
            if (min%i == 0){
                if (max%i == 0){
                    res = i;
                }
            }
        }
        return res;
    }
}