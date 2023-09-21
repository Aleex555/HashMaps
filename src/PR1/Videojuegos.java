package PR1;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Videojuegos {
    TreeMap llista = new TreeMap();
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String opcion="";
    String juego="";
    Float precio;
    Videojuegos v1 = new Videojuegos();
    v1.llista.put("Starfield", 69.99);
    v1.llista.put("Rust", 39.99);
    v1.llista.put("Fifa24", 79.99);
    v1.llista.put("Dying Light 2", 15.99);
    v1.llista.put("Project Zomboid", 10.0);
        
    while ( !opcion.equals("0")) {
        System.out.println("Menu Principal\n1 - Añadir Juego\n2 - Modificar Precio\n3 - Eliminar Juego\n4 - Mostrar Juegos\n0 - Salir");
        System.out.print("Ingrese una opcion: ");
        opcion= sc.nextLine();
        
        switch (opcion) {
            case "1":
                System.out.print("Escribe el nombre del juego: ");
                juego=sc.nextLine();
                System.out.print("Escribe el precio del juego: ");
                precio=sc.nextFloat();
                v1.insertarJuegos(juego,precio);
                sc.nextLine();
                break;
            case"2":
                System.out.print("Escribe el nombre del juego: ");
                juego=sc.nextLine();
                v1.modificarPrecio(juego);
                break;
            case "3":
                System.out.print("Escribe el nombre del juego: ");
                juego=sc.nextLine();
                v1.eliminarJuego(juego);
                break;
            case "4":
                System.out.println();
                v1.mostrarAgenda();
                break;
            case "0":
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opcion no valida. Intente de nuevo.\n");
                break;
        }
    }
        
    }

    public void insertarJuegos(String juego, float precio){
        if(llista.containsKey(juego)){
            System.out.println("\nEl juego ya existe\n");
        }else{
            llista.put(juego, precio);
            System.out.println("El juego se ha introducido correctamente.\n");
            
        }
        

        
    }

    public void mostrarAgenda(){
       Set set=llista.entrySet(); 
       Iterator iterator=set.iterator(); 
       while(iterator.hasNext()){
          Map.Entry mapEntry=(Map.Entry)iterator.next(); 
          System.out.println("Nombre: " + mapEntry.getKey() + ", " + "Precio: " + mapEntry.getValue());
          System.out.println();
   }
    }

    public void modificarPrecio(String juego){
        Scanner sc = new Scanner(System.in);
        if(!llista.containsKey(juego)){
            System.out.println("\nEl juego no existe\n");
        }else{
            Float precio;
            System.out.print("\nEscribe el precio nuevo: ");
            precio=sc.nextFloat();
            System.out.println();
            llista.replace(juego,llista.get(juego), precio);
        }

    }

    public void eliminarJuego(String juego){
        if(llista.containsKey(juego)){
            System.out.print("\nEstas seguro que quieres eliminarlo?: ");
            Scanner sc = new Scanner(System.in);
             String opc = sc.nextLine().toLowerCase();
            if(opc.equals("si")){
                llista.remove(juego);
                System.out.println("El juego ha sido eliminado.\n");
            }else{
                System.out.println("El juego no ha sido eliminado.\n");
            }
    
    }
}

}   

