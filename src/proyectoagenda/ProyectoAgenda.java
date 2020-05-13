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
        String[][] agenda = new String[5][2]; //Agenda -20 filas -2 culumnas(nombre,teléfono), modificar para 20 contactos (String[20][2])
        int option,posicion;
        boolean estado = false;
        String nombre, telefono, nombreBuscar, nombreEliminar, nombreEditar;
        agenda[0][0]= "A";
        agenda[0][1]= "3124569870";
        agenda[1][0]= "B";
        agenda[1][1]= "3124569871";
        agenda[2][0]= "C";
        agenda[2][1]= "3124569876";
        agenda[3][0]= "D";
        agenda[3][1]= "3124569878";
        
     
        // Menú
        do{
            System.out.print("*************** AGENDA ***************"
                    + "\n\t\t1. Mostrar"
                    + "\n\t\t2. Añadir"
                    + "\n\t\t3. Buscar"
                    + "\n\t\t4. Borrar"
                    + "\n\t\t5. Actualizar"
                    + "\n\t\t0. Terminar"
                    + "\n***************************1***********"
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
                    if(metodos.itemAgenda(agenda, nombre, telefono) )
                        System.out.println("¡Contacto guardado con éxito!");
                    else
                        System.out.println("El contacto no cumplio con los parametros establecidos.");
                    
                
                    break;
                    
                case 3:
                   
                    //Buscar contactos
                    System.out.println("Buscar contactos");
                    System.out.print("Ingrese nombre o numero.\n--> ");
                    nombreBuscar = teclado.next();
                    posicion = Metodos.searchItemAgenda(agenda, nombreBuscar);
                    if (posicion != -1)
                        System.out.println("---------------------------\nNombre: "+agenda[posicion][0]+"\nTeléfono: "+agenda[posicion][1]+"\n---------------------------");
                    else
                        System.out.println("El contacto "+nombreBuscar+" no se encuentra.");
           
                    break;
                    
                case 4:
                    //Borrar contactos
                    System.out.println("Borrar contactos");
                    System.out.print("Ingrese el nombre.\n--> ");
                    nombreEliminar = teclado.next();
                    metodos.delteItemAgenda(agenda, nombreEliminar);
                    
                    break;
                    
                case 5:
                    //Actualizar contactos
                    System.out.println("Actulizar contactos");
                    System.out.print("Ingese el nombre.\n--> ");
                    nombreEditar = teclado.next();
                    metodos.updateItemAgenda(agenda, nombreEditar);
                    
                    break;
                    
                default:
                    System.out.println("Opción fuera de rango...");
                    break;
            }                
            
        }while(option != 0);
    }
}
