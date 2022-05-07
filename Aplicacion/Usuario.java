
public class Usuario {
    String nombre;
    int edad;
    String DNI;
    
 
    // CONSTRUCTOR USUARIO
    public Usuario() { 
        this.nombre="";
        this.edad=0;
        this.DNI="";
    }
 
    // SETTERS 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public void setEdad(int edad) {
        this.edad = edad;
    }
     
    public void setDni(String DNI) {
        this.DNI = DNI;
    }
 
    // GETTERS
    public String getNombre() {
        return nombre;
    }
 
    public String getDni() {
        return DNI;
    }
 
    public int getEdad() {
        return edad;
    }
 
 // Comprueba DNI y lo añade 
    public boolean setDNI(String DNI){
         
        if(DNI.matches("^[0-9]{8}[A-Z]$") || DNI.matches("^[0-9]{8}[-][A-Z]$")){ // Pasamos un if para condicionar el set del dni con unos requisitos 
            this.DNI=DNI;
            return true; // Si para la condicion devolvemos el valor true(boolean) y hacemos un set de la variable dni directamente
        }else{
            return false;
        }      
    }

 // Metodo toString sobreeescrito para devolver los datos de la clase
    @Override
    public String toString() {
        return "Usuario [Nombre: " + nombre + " ], [Edad: " + edad + " ], [DNI:" + DNI + " ]";
    }
}