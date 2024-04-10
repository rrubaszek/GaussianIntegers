import java.util.ArrayList;

public class Polynomials {
    public Polynomial[] divide(Polynomial f, Polynomial g) {

        ArrayList<Double> temp = new ArrayList<>(f.coefficients);
        Polynomial q = new Polynomial();
        Polynomial r = new Polynomial(temp);

        int divisorDeg = g.coefficients.size() - 1;

        while (r.coefficients.size() >= g.coefficients.size()) {
            double leading = r.coefficients.get(0) / g.coefficients.get(0);

            q.coefficients.add(leading);

            for(int i = 0; i <= divisorDeg; i++) {
                double val = r.coefficients.get(i);
                double sub = leading * g.coefficients.get(i);

                r.coefficients.set(i, val - sub);
            }

            while(!r.coefficients.isEmpty() && r.coefficients.get(0) == 0.0) {
                r.coefficients.remove(0);
            }
        }

        Polynomial[] res = new Polynomial[2];

        res[0] = q;
        res[1] = r;

        return res;
    }

    public Polynomial gcd(Polynomial f, Polynomial g) {
        Polynomial[] divisionResult = divide(f, g);
        if (divisionResult[1].coefficients.isEmpty()) {
            return g;
        } else {
            return gcd(g, divisionResult[1]);
        }
    }
    public Polynomial lcm(Polynomial f, Polynomial g){
        Polynomial gcd = gcd(f, g);
        Polynomial m = multiply(f, g);

        Polynomial[] divisionResult = divide(m, gcd);

        return divisionResult[0];
    }

    private Polynomial multiply(Polynomial f, Polynomial g){
        Polynomial temp = new Polynomial();
        for(int i = 0; i < f.coefficients.size()+g.coefficients.size(); i++) {
            temp.coefficients.add(0.0);
        }
        double a, b;
        for(int i = 0; i < f.coefficients.size(); i++){
            for(int j = 0; j < g.coefficients.size(); j++){
                a = f.coefficients.get(i);
                b = g.coefficients.get(j);
                temp.coefficients.set(i + j, temp.coefficients.get(i + j) + (a * b));
            }
        }
        return temp;
    }
}
