
import java.util.Scanner;

public class Main {

// Creamos un atributo para la lectura llamado sc//////////////////////////////////////////////////////////////////////////////
private static Scanner sc = new Scanner(System.in);

// MENU ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private static int opcionMenu=0;
 
private static void mostrarMenu(){ // Funcion que nos muestre un menu 
	        
	do{ //DO WHILE hasta que se introduza un num del 0 al 5
		System.out.println("Realiza una nueva accion");
	    System.out.println("1. Introduce un nuevo gasto");
	    System.out.println("2. Introduce un nuevo ingreso");
	    System.out.println("3. Mostrar gastos");
	    System.out.println("4. Mostrar ingresos");
	    System.out.println("5. Mostrar saldo");
	    System.out.println("0. Salir");
 
	    opcionMenu = Integer.parseInt(sc.nextLine()); // Conversion de String a Integer 
	        
	 }while(opcionMenu<0 && opcionMenu>5);  
 }
 

// Gastos e Ingresos////////////////////////////////////////////////////////////////////////////////////////////////////////////
private static Cuenta cuenta = null;
private static double dinero=0.0;
private static String description="";

private static void introducirGastos(){ // Funcion para pedir datos del gasto y meterlos en la lista
     
    dinero=0.0; // reseteamos variables 
    description="";
     
    do{ // DO WHILE hasta que se introduzca una descripcion
        System.out.println("Introduce la descripcion");
        description = sc.nextLine();
        
    }while(description=="");
         
    do { // DO WHILE hasta que se introduzca una cantidad 
        System.out.println("Introduce la cantidad");
        dinero = Double.parseDouble(sc.nextLine()); // Convertimos dinero en un Double
        
        if(cuenta.getSaldo()<dinero){ // Si hay menos salgo que el gasto introducido entoces nos devolvera un mensaje
            System.out.println("No tienes sufuciente dinero");
        }
        else{
            cuenta.addGastos(description, dinero); // Si no Agregamos a la lista el gasto
            System.out.println("Saldo restante: " + cuenta.getSaldo() + "€");
        }
    }while(dinero==0.0);
    
}
private static void introducirIngresos() { // Funcion para pedir datos del i y meterlos en la lista
    
    dinero=0.0;// reseteamos variables 
    description="";
    
    do{ // DO WHILE hasta que se introduzca una descripcion
        System.out.println("Introduce la descripcion");
        description = sc.nextLine();
         
    }while(description=="");
     
    do { // DO WHILE hasta que se introduzca una cantidad 
        System.out.println("Introduce la cantidad");
        dinero = Double.parseDouble(sc.nextLine());
        
    }while(dinero==0.0);
         
        cuenta.addIngresos(description, dinero); // Agregamos a la lista el Ingreso
        System.out.println("Saldo restante: " + cuenta.getSaldo() + "€");  
}


private static void lista_gastos() { //Funcion que recorre la lista Gastos

	// Pasamos un for que recorra la lista gastos gasto por gasto
	for(int i=0;i<cuenta.getGastos().size();i++) {
		System.out.println(cuenta.getGastos().get(i).toString());// Le pedimos que saque cada gasto por el metodo sobreescrito toString
	}
}
private static void lista_ingresos() { // Funcion que recorre la lista ingresos
	
 // Pasamos un for que recorra la lista Ingresos ingreso por ingreso
	for(int i=0;i<cuenta.getIngresos().size();i++) {
		System.out.println(cuenta.getIngresos().get(i).toString());// Le pedimos que saque cada gasto por el metodo sobreescrito toString
	}
}

//CREACION DATOS DE USUARIO ////////////////////////////////////////////////////////////////////////////////////////////////////
private static Usuario nuevoUsuario = new Usuario();    
private static String username="";   
private static int edad=0;
private static String dniUsuario="";
private static boolean usuarioConfirmado=false;

private static void datos_cuenta(){ // Funcion que almacena los datos que vayamos a introducir sobre la cuenta 
    
    usuarioConfirmado=false;
    
    do{ // DO WHILE hasta que se haya introducido el nombre y edad de la cuenta 
        System.out.println("Introduce el nombre del usuario");
        username=sc.nextLine();
   
        nuevoUsuario.setNombre(username); // almacenamos el nombre en la variable 'nuevoUsuario'
   
        System.out.println("Introduce la edad del usuario");
        edad = Integer.parseInt(sc.nextLine());
        
        nuevoUsuario.setEdad(edad); // almacenamos el valor de edad en la variable 'nuevousuario'
                
    }while(edad<=0 || (username==""));
    
    
    System.out.println("Introduce el DNI del usuario");
   
    do{ // DO WHILE hasta que el DNI tenga contenido o el .setDNI devuelva el valor TRUE
        
        dniUsuario=sc.nextLine();
        
        if(nuevoUsuario.setDNI(dniUsuario)){
            nuevoUsuario.setDNI(dniUsuario);
            usuarioConfirmado=true; // SI LLEGAMOS HASTA ESTE APARTADO PASANDO TODAS LAS CONDICIONES ENTOCES EL USUARIO YA TIENE PREPARADO LOS DATOS PARA SER CREADO y CONFIRMADO
        }
        else{
            System.out.println("DNI introducido incorrecto\nIntroduce el DNI del usuario valido");
        }
    }while(dniUsuario=="" || nuevoUsuario.setDNI(dniUsuario)==false);
    
    if(usuarioConfirmado==true) { // SI HA PASADO TODOS LOS CRITERIOS ENTOCES DEVOLVEMOS UNA CADENA DE TEXTO
        System.out.println("Usuario creado correctamente");
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////// MAIN///////////////////////////////////////////////////////////////////////////////////////////////////////////////

public static void main(String[] args){
    
    
	datos_cuenta();	// Pedimos los datos de la cuenta con una funcion ya creada 
    
    cuenta=new Cuenta(nuevoUsuario); // Creamos la cuenta con los datos ya almacenados en ese usuario
     
    do{ // DO WHILE HASTA QUE QUERRAMOS SALIR DEL PROGRAMA Y ELIGAMOS EL CASE 0
        mostrarMenu(); // Mostramos el menu
         
        switch(opcionMenu){ // Creamos un switch case para representar las opciones del menu
 
            case 0: 
                System.out.println("Fin del programa.\nGracias por utilizar la aplicacion"); // Nos sacara del programa gracias a la condicion de que se acabe el DO WHILE hasta que se eliga el 0.
                break;
 
            case 1:
            	introducirGastos(); // Pide e introduce los Gastos 
            	break;

            case 2:
                introducirIngresos(); // Pide e introduce los Ingresos 
                break;
 
            case 3:
                lista_gastos(); // Recorre la lista de Gastos y la muestra
                break;
 
            case 4:
                lista_ingresos(); // Recorre la lista de Ingresos y la muestra
                break;
 
            case 5:
                System.out.println("El saldo actual de la cuenta es:" + cuenta.getSaldo() + "€"); // Muestra el saldo actual de la cuenta
                break;
 
            default: // Default por si escriobe un valor no valido que salgo esto por pantalla
                System.out.println("Introduce un valor valido");
                break;
        }
    }while(opcionMenu!=0);
 
    sc.close(); // Cerramos la variable scanner
	}
}

