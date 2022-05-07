
abstract class Dinero { // clase que tendra 2 subclases en herencia
    protected double dinero;
    protected String description;
    
    public double getDinero() {
        return dinero;
    }
    
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

}