public class GaussianIntegers{
    public GaussianInteger[] divide(GaussianInteger a, GaussianInteger b){
        if(b.real == 0 && b.imaginary == 0) {
            return new GaussianInteger[]{a, b};
        }
        GaussianInteger inverse = new GaussianInteger(b.real, -b.imaginary);
        GaussianInteger res = multiply(a, inverse);

        float x = (float) res.real / norm(b);
        float y = (float) res.imaginary / norm(b);

        GaussianInteger quotient = new GaussianInteger(Math.round(x), Math.round(y));
        res = multiply(quotient, b);
        int real = a.real - res.real;
        int im = a.imaginary - res.imaginary;
        GaussianInteger reminder = new GaussianInteger(real, im);

        return new GaussianInteger[]{quotient, reminder};
    }

    public GaussianInteger gcd(GaussianInteger a, GaussianInteger b){
        if(b.imaginary == 0 && b.real == 0){
            return a;
        }
        if (a.imaginary == 0 && a.real == 0){
            return b;
        }
        else {
            GaussianInteger[] res = divide(a, b);
            return gcd(b, res[1]);
        }
    }

    public GaussianInteger lcm(GaussianInteger a, GaussianInteger b){
        GaussianInteger res = multiply(a, b);
        GaussianInteger divisor = gcd(a, b);

        res.real = res.real / divisor.real;
        res.imaginary = res.imaginary / divisor.imaginary;

        return res;
    }

    public GaussianInteger multiply(GaussianInteger a, GaussianInteger b){
        int real = a.real * b.real - a.imaginary * b.imaginary;
        int im = a.imaginary * b.real + a.real * b.imaginary;
        return new GaussianInteger(real, im);
    }

    public int norm(GaussianInteger a){
        return (int)(Math.pow(a.real, 2) + Math.pow(a.imaginary, 2));
    }
}
