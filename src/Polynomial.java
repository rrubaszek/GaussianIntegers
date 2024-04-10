import java.util.ArrayList;

public class Polynomial {
    ArrayList<Double> coefficients;
    public Polynomial() { coefficients = new ArrayList<>(); };
    public Polynomial(ArrayList<Double> coefficients){
        this.coefficients = coefficients;
    }
    public void printPolynomial() {
        int degree = this.coefficients.size() - 1;
        for (int i = 0; i <= degree; i++) {
            if (this.coefficients.get(i) != 0.0) {
                System.out.print(this.coefficients.get(i) + "x^" + (degree - i));
                if (i != degree) {
                    System.out.print(" + ");
                }
            }
        }
        System.out.println();
    }
}
