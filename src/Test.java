import java.util.ArrayList;

public class Test implements TestFactory{
    @Override
    public void createPolynomial() {
        System.out.println("Testing polynomials");
        ArrayList<Float> l1 = new ArrayList<>();
        l1.add(0, 2.0f);
        l1.add(1, -3.0f);
        l1.add(2, 4.0f);
        l1.add(3, -5.0f);
        l1.add(4, 6.0f);

        ArrayList<Float> l2 = new ArrayList<>();
        l2.add(0, 0.0f);
        l2.add(1, 0.0f);
        l2.add(2, 1.0f);
        l2.add(3, -3.0f);
        l2.add(4, 1.0f);

        for(int i = 0; i < l1.size(); i++){
            if(l1.get(i) != 0.0f)
                System.out.print(" + " + l1.get(i) + "x^" + (l1.size() - i - 1));
        }
        System.out.print(" divided by");

        for(int i = 0; i < l2.size(); i++){
            if(l2.get(i) != 0.0f)
                System.out.print(" + " + l2.get(i) + "x^" + (l2.size() - i - 1));
        }

        System.out.println(" gives:");

        Polynomial f = new Polynomial(l1);
        Polynomial g = new Polynomial(l2);

        Polynomials func = new Polynomials();

        Polynomial[] h = func.divide(f, g);
        int qSize = h[0].coefficients.size();
        int rSize = h[1].coefficients.size();

        System.out.print("quotient =");
        for(int i = 0; i < qSize; i++){
            if(h[0].coefficients.get(i) != 0.0f)
                System.out.print(" + " + h[0].coefficients.get(i) + "x^" + (qSize - i - 1));
        }
        System.out.print("\nreminder =");
        for(int i = 0; i < rSize; i++){
            if(h[1].coefficients.get(i) != 0.0f)
                System.out.print(" + " + h[1].coefficients.get(i) + "x^" + (rSize - i - 1));
        }
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
