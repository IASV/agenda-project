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
   public int itemAgenda(String[][] agenda, String nombre, String telefono, int posicion){
       agenda[posicion][0] = nombre;
       agenda[posicion][1] = telefono;
       posicion++;
       System.out.println("¡Contacto agregado con éxito!");
       return posicion;
   }
    //Método buscarItemAgenda()
    
    //Método borrarItemAgenda()
    
}
