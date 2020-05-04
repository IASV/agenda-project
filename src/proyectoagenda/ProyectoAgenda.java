/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoagenda;
import java.util.Scanner;
/**
 *
 * @author Iván Suarez, Kevin García
 */
public class ProyectoAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        Metodos metodos = new Metodos();
        String[][] agenda = new String[20][2]; //Agenda -20 filas -2 culumnas(nombre,teléfono)
        int option,posicion = 0;
        boolean estado = false;
        String nombre, telefono;
        
        // Menú
        do{
            System.out.print("*************** AGENDA ***************"
                    + "\n\t\t1. Mostrar"
                    + "\n\t\t2. Añadir"
                    + "\n\t\t3. Buscar"
                    + "\n\t\t4. Borrar"
                    + "\n\t\t0. Terminar"
                    + "\n**************************************"
                    + "\nElige una opción: ");
            option = teclado.nextInt();
            
            switch(option){
                case 0:
                    //Salir
                    System.out.println("Salir");
                    break;
                    
                case 1:
                    //Mostrar contactos
                    System.out.println("Mostrar contactos");
                    if (agenda[0][0] != null)
                        metodos.listarItemAgenda(agenda);
                    else
                        System.out.println("No hay contactos agregados.");
                    
                    break;
                    
                case 2:
                    //Añadir contactos
                    System.out.println("Añadir contactos");
                    //Se piden el nombre y el teléfono a agregar
                    System.out.print("Ingrese nombre.\n--> ");
                    nombre = teclado.next();
                    System.out.print("Ingrese teléfono.\n--> ");
                    telefono = teclado.next();
                    //Se llama al método y se le pasa la agenda y también el nombre y el teléfono a agregar
                    if(!metodos.itemAgenda(agenda, nombre, telefono, posicion))
                        System.out.println("¡Contacto guardado con éxito!");
                    
                    break;
                    
                case 3:
                    //Buscar contactos
                    System.out.println("Buscar contactos");
                    break;
                    
                case 4:
                    //Borrar contactos
                    System.out.println("Borrar contactos");
                    break;
                        
                default:
                    System.out.println("Opción fuera de rango...");
                    break;
            }                
            
        }while(option != 0);
    }
}
