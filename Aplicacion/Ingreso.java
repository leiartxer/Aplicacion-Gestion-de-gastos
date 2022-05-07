
class Ingreso extends Dinero { // Hereda de la clase dinero
    
    public Ingreso(double ingreso, String description) { //Constructor 
        this.dinero=ingreso;
        this.description=description;
    }
    
 // Metodo toString sobreeescrito para devolver los datos de la clase
    @Override
    public String toString() {
        return "Ingreso: " + this.description + ", cantidad:" + this.dinero + "€";
    }
}