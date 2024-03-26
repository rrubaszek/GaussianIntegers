import java.util.ArrayList;

public class Polynomials {
    public Polynomial[] divide(Polynomial f, Polynomial g){
        Polynomial q = new Polynomial(f.coefficients.size());

        int itr = 0;
        while(g.coefficients.get(itr) == 0){
            itr++;
        }
        float leading = g.coefficients.get(itr);
        int size = g.coefficients.size();

        int i = 0;
        int qItr = size - 1;
        int rItr = 0;
        Polynomial gCopy;
        while(f.coefficients.get(0) != 0 && f.coefficients.get(0) % leading == 0.0f){
            if(g.coefficients.get(0) == 0.0f){
                q.coefficients.set(qItr, 0.0f);
                for(int j = 0; j < size - 1; j++){
                    g.coefficients.set(j, g.coefficients.get(j+1));
                }
                g.coefficients.set(size - 1, 0.0f);
                qItr--;
            }
            else {
                q.coefficients.set(qItr, f.coefficients.get(0) / leading);
                gCopy = multiply(g, q.coefficients.get(qItr));
                qItr++;

                for(int k = 0; k < size; k++) {
                    f.coefficients.set(k, f.coefficients.get(k) - gCopy.coefficients.get(k));
                }

                if(rItr == size - itr - 1) break;

                i++;
                if(f.coefficients.get(i) != 0 && f.coefficients.get(i) % leading == 0.0f ) {
                    for (int j = 0; j < size - 1; j++) {
                        f.coefficients.set(j, f.coefficients.get(j + 1));
                    }
                    f.coefficients.set(size - 1, 0.0f);
                    i--;
                    rItr++;
                }
            }
        }
        while(rItr != 0){
            for (int j = size - 1; j > 0; j--) {
                f.coefficients.set(j, f.coefficients.get(j - 1));
            }
            f.coefficients.set(0, 0.0f);
            rItr--;
        }

        return new Polynomial[]{q, f};
    }

    public Polynomial gcd(Polynomial f, Polynomial g) {
        return f;
    }
    public Polynomial lcm(Polynomial f, Polynomial g){
        return g;
    }

    private Polynomial multiply(Polynomial h, float x){
        Polynomial temp = new Polynomial(h.coefficients.size());
        for(int i = 0; i < h.coefficients.size(); i++){
            temp.coefficients.set(i, h.coefficients.get(i));
        }
        temp.coefficients.replaceAll(aFloat -> aFloat * x);
        return temp;
    }

}
