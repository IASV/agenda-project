/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoagenda;

/**
 *
 * @author Iván Suarez, Kevin García
 */
public class Metodos {
    
    //Método listarItemAgenda()
    public void listarItemAgenda(String[][] agenda){
        System.out.println("\tNombre\tTeléfono");
        for (int i = 0; i <= agenda.length-1; i++) {
            if(agenda[i][0] != null) System.out.println("\t" + agenda[i][0] + "\t" + agenda[i][1]);
        }
    }
   
    //Método itemAgenda()
   public boolean itemAgenda(String[][] agenda, String nombre, String telefono, int posicion){
        //Se evalua las condiciones para nombre y teléfono
        if(telefono.length() == 10 & nombre.length() <= 40 ){
            //Se compara el teléfono con los que estan en la agenda para evitar duplicados
            for (int i = 0; i <= agenda.length-1; i++) {
                if(telefono.equals(agenda[i][1])) {
                    System.out.println("El número existe");
                    return true;
                }
            }
            
        }
        return false;
   }
    //Método buscarItemAgenda()
    
    //Método borrarItemAgenda()
    
}
