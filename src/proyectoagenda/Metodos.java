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
public class Metodos {
    
    private Scanner teclado = new Scanner(System.in);
   //Método listarItemAgenda()
    public void listarItemAgenda(String[][] agenda){
        Metodos.movaUpPosition(agenda);
        System.out.println("\tNombre\tTeléfono");
        for (int i = 0; i <= agenda.length-1; i++) {
            if(agenda[i][0] != null) System.out.println("\t" + agenda[i][0] + "\t" + agenda[i][1]);
        }
    }
   
    //Método itemAgenda()
   public boolean itemAgenda(String[][] agenda, String nombre, String telefono){
       int cont = 0;
        //Se evalua las condiciones para nombre y teléfono
        if(nombre.length()<=40 ){
            if (telefono.length()==10) {
                //Se compara el teléfono con los que estan en la agenda para evitar duplicados
                
                for (int i = 0; i <= agenda.length-1; i++) {
                    
                    if(telefono.equals(agenda[i][1])) {
                        System.out.println("El número existe");
                        
                        return false;
                    }
                    
                }
                
                if(cont == 1) 
                    System.out.println("Lista de contactos llena.");
               
                else if(Metodos.positionItemAgenda(agenda) >= 5){ // modificar para 20 contactos (Metods.positionItemAgenda(agenda) >= 20)
                    agenda[Metodos.positionItemAgenda(agenda)-1][0] = nombre;                
                    agenda[Metodos.positionItemAgenda(agenda)-1][1] = telefono;
                    cont = 1;
                }

                else{
                    agenda[Metodos.positionItemAgenda(agenda)][0] = nombre;                
                    agenda[Metodos.positionItemAgenda(agenda)-1][1] = telefono;
                }
                return true;
                
            }
        }
        
        return false;
   }
   
   //Método para encontrar la posición que debe ocupar el itemAgenda()
   public static int positionItemAgenda(String[][] agenda){
       int acumContacTotal = 0;
       for (int i = 0; i <= agenda.length-1; i++)
           if(agenda[i][0] != null)
               acumContacTotal++;
        
       return acumContacTotal;
   }
   
   //Método para ordenar los contactos
   public static void movaUpPosition(String[][] agenda){
        String[] temp = new String[2];        
        for (int i = 0; i < agenda.length-1; i++) {
            for (int j = 1; j <=agenda.length-1; j++) {
                
                if(agenda[j][0] != null){// Verifica que el número actual a comparar, y el que le precede existan.                                                             
                    if (Long.parseLong(agenda[j-1][1]) < Long.parseLong(agenda[j][1])) {
                    temp = agenda[j-1];
                    agenda[j-1] = agenda[j];
                    agenda[j] = temp;
                    }
                }
                
            }
            
        }
        for (int i = 0; i <= agenda.length-1; i++){
            if(agenda[i][0] == "0"){
                agenda[i][0] = null;
                agenda[i][1] = null;
            }
        }
    }
   

    //Método buscarItemAgenda()
    public static int searchItemAgenda(String[][] agenda, String nombre){
        Metodos.movaUpPosition(agenda);
        for (int i = 0; i <= agenda.length-1; i++) {
            
            if (agenda[i][0] == null ? nombre == null : agenda[i][0].toLowerCase().equalsIgnoreCase(nombre.toLowerCase())) {   
                return i;
            }
            
        }
         for (int i = 0; i <= agenda.length-1; i++) {
            
            if (agenda[i][1] == null ? nombre == null : agenda[i][1].toLowerCase().equalsIgnoreCase(nombre.toLowerCase())) {   
                return i;
            }
            
        }
        
        return -1;
    }
    
    //Método borrarItemAgenda()
    public void delteItemAgenda(String[][] agenda, String nombre){
        int posicion = searchItemAgenda(agenda, nombre), status;
        if (posicion != -1){
            System.out.println("---------------------------\nNombre: "+agenda[posicion][0]+"\nTeléfono: "+agenda[posicion][1]+"\n---------------------------");
            System.out.print("Desea borrar el contacto.\n1. Si.\n2. No.\n--> ");
            status = teclado.nextInt();
            if(status == 1){
                agenda[posicion][0] = "0";
                agenda[posicion][1] = "0";
                System.out.println("¡Proceso realizado con éxito!");
                Metodos.movaUpPosition(agenda);
            }
        }
        else
            System.out.println("El contacto "+nombre+" no se encuentra.");
    }
    
    //Método actualizarItemAgenda()
    public void updateItemAgenda(String[][] agenda, String nombre){
        int posicion = Metodos.searchItemAgenda(agenda, nombre);
        if(posicion != -1){
           System.out.print("Ingrese el nuevo número.\n--> ");           
           agenda[posicion][1] = teclado.nextLine();
           System.out.println("¡Proceso realizado con éxito!");
           Metodos.movaUpPosition(agenda);
       }
        
    
   }
    
    
   
}
