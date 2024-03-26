import java.util.ArrayList;

public class Polynomial {
    ArrayList<Float> coefficients;
    public Polynomial(int size){
        coefficients = new ArrayList<>();
        for(int i = 0; i < size; i++){
            coefficients.add(i, 0.0f);
        }
    }
    public Polynomial(ArrayList<Float> coefficients){
        this.coefficients = coefficients;
    }
}
