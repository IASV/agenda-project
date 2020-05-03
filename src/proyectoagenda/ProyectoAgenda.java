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
        String[][] ajenda = new String[20][20]; //Agenda
        int option = 1;
        
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
                    case 1:
                        //Mostrar contactos
                        break;
                    
                    case 2:
                        //Añadir contactos
                        break;
                    
                    case 3:
                        //Buscar contactos
                        break;
                    
                    case 4:
                        //Borrar contactos
                        break;
                        
                    default:
                        System.out.println("Opción fuera de rango...");
                        break;
            }                
            
        }while(option != 0);
    }
}
