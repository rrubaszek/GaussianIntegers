import java.util.ArrayList;

public class Test implements TestFactory{
    @Override
    public void createPolynomial() {
        System.out.println("Testing polynomials");
        ArrayList<Double> l1 = new ArrayList<>();
        l1.add(1.0);
        l1.add(2.0);
        l1.add(1.0);
        //l1.add( -6.0);
        //l1.add(4, 6.0f);

        ArrayList<Double> l2 = new ArrayList<>();
        l2.add(1.0);
        l2.add(-2.0);
        l2.add(-2.0);
        //l2.add(-24.0);
        //l2.add(4, 1.0f);


        Polynomial f = new Polynomial(l1);
        Polynomial g = new Polynomial(l2);

        System.out.println("Polynomial F: ");
        f.printPolynomial();
        System.out.println("Divided by G: ");
        g.printPolynomial();

        Polynomials func = new Polynomials();

        Polynomial[] h = func.divide(f, g);

        System.out.println("Quotient: ");
        h[0].printPolynomial();
        System.out.println("Reminder: ");
        h[1].printPolynomial();

        Polynomial gcd = func.gcd(f, g);
        gcd.printPolynomial();

        Polynomial lcm = func.lcm(f, g);
        lcm.printPolynomial();
    }

    @Override
    public void createGaussianIntegral() {
        System.out.println("Testing Gaussian Integers");
        GaussianIntegers num = new GaussianIntegers();

        GaussianInteger a = new GaussianInteger(3, 4);
        GaussianInteger b = new GaussianInteger(1, 3);

        GaussianInteger[] res = num.divide(a, b);
        GaussianInteger gcd = num.gcd(a, b);
        GaussianInteger lcm = num.lcm(a, b);

        System.out.println("Quotient: " + res[0].real + "+(" + res[0].imaginary + "i)");
        System.out.println("Reminder: " + res[1].real + "+(" + res[1].imaginary + "i)");
        System.out.println("GCD: " + gcd.real + "+(" + gcd.imaginary + "i)");
        System.out.println("LCM: " + lcm.real + "+(" + lcm.imaginary + "i)");
    }
}
