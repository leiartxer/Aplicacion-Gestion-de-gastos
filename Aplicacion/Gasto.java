
public class Gasto extends Dinero { // Hereda de la clase dinero
    
    public Gasto(double gasto, String description) { // Constructor
        this.dinero=gasto;
        this.description = description;
    }

    // Metodo toString sobreeescrito para devolver los datos de la clase
    @Override
    public String toString() {
        return "Gasto: " + this.description + ", cantidad:" + this.dinero + "€";
    }

}