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
        Metodos.movaUpPosition(agenda);
        System.out.println("\tNombre\tTeléfono");
        for (int i = 0; i <= agenda.length-1; i++) {
            if(agenda[i][0] != null) System.out.println("\t" + agenda[i][0] + "\t" + agenda[i][1]);
        }
    }
   
    //Método itemAgenda()
   public boolean itemAgenda(String[][] agenda, String nombre, String telefono, int posicion){
        //Se evalua las condiciones para nombre y teléfono
        if(telefono.length() == 10 && nombre.length() <= 40 ){
            //Se compara el teléfono con los que estan en la agenda para evitar duplicados
            for (int i = 0; i <= agenda.length-1; i++) {
                if(telefono.equals(agenda[i][1])) {
                    System.out.println("El número existe");
        
                    return false;
                }
            }
            agenda[Metodos.positionItemAgenda(agenda)][0] = nombre;
            agenda[Metodos.positionItemAgenda(agenda)-1][1] = telefono;
        }
        
        return true;
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
        String temp, nombre;
        for (int i = 1; i < agenda.length-1; i++) {
            for (int j = 1; j < agenda.length-1; j++) {
                if(agenda[j][0] != null){
                    if (Integer.parseInt(agenda[j][1]) < Integer.parseInt(agenda[j+1][1])) { //Comparación del valor en (n)posición del vector u arreglo con (n+1)posición del vector, n > n+1.
                        temp = agenda[j][1]; // Se guarda el valor en la posición (n) en la variable temp.
                        nombre = agenda[j][0]; // Se guarda el nombre.
                        agenda[j][1] = agenda[j+1][1]; // Se reemplaza el valor en posición (n) por valor en la posición (n+1).
                        agenda[j][0] = agenda[j+1][0]; // Se reemplaza el antiguo nombre por el nuevo.
                        agenda[j+1][1] = temp; // Se reemplaza valor en posición (n+1) por el valor alojado en temp.
                        agenda[j+1][0] = nombre; //Se reemplaza el nombre en la nueva posición.
                    }
                }
            }
        }
    }
   

    //Método buscarItemAgenda()
    
    //Método borrarItemAgenda()
    
   
   
   
}
