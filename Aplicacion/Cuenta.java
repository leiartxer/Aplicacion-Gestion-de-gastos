
import java.util.*;

public class Cuenta {
	
	private double saldo; // Saldo de la cuenta.
	private Usuario usuario; // Usuario de la cuenta.
	private List<Gasto> gastos; // Una lista de gastos de la cuenta
	private List<Ingreso> ingresos; // Una lista de ingresos de la cuenta
	
	// CONSTRUCTOR CUENTA
	public Cuenta(Usuario usuario) {
		this.usuario= usuario;
		this.saldo=0;
		this.gastos = new ArrayList<Gasto>();
		this.ingresos = new ArrayList<Ingreso>();
	}

	
	// Setters
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
	
	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
	
	// Getters
	public double getSaldo() {
		return saldo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<Gasto> getGastos() {
		return gastos;
	}
	
	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	
	// Anade un gasto con descripcion a la lista
	public double addGastos(String description, double cantidad){
       
	    try {
	        if(this.getSaldo()<cantidad){ // Si el saldo es menor que el gasto lanzamos una excepcion
	            throw new GastoException();
	        }else { // Sino realizamos el gasto 
	            this.setSaldo(this.getSaldo()-cantidad);
            }
	    }catch (GastoException e) { // En caso de haber lanzado la excepcion devolvera este mensaje
	        System.out.println("No puede gastar dinero que no tienes");
        }
	    
	 // Agregamos la descripcion y la cantidad del gasto a la lista 
        Gasto nuevoGasto=new Gasto(cantidad,description); 
        gastos.add(nuevoGasto); 
        
        return saldo;
    }
	
	public double addIngresos(String description, double cantidad){
        
	    this.setSaldo(this.getSaldo()+cantidad);// Realizamos el Ingreso 
	    
	 // Agregamos la descripcion y la cantidad del Ingreso a la lista 
        Ingreso ultimoIngreso = new Ingreso(cantidad,description); 
        ingresos.add(ultimoIngreso);
        
        return saldo;
    }
	
	
}
