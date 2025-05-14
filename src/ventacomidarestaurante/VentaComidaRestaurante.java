
package ventacomidarestaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VentaComidaRestaurante {


    public static void main(String[] args) {
     
        List<String>menu=new ArrayList<>();
        List<Double>precios=new ArrayList<>();
        
        //Add platos al menú
        menu.add("Hamburguesa");
        precios.add(10.0);
        menu.add("Pizza");
        precios.add(8.25);
        menu.add("Ensalada");
        precios.add(4.15);
        
        //Se inicializan las listas para guardar el pedido del cliente
        List<String>pedido=new ArrayList<>();
        List<Double>totalPedido=new ArrayList<>();
        
        //Creamos un scanner para leer lo que desea el usuario
        Scanner entrada= new Scanner (System.in);
        boolean salir = false;
        
        while (!salir){
            //menú de opciones
            System.out.println("\n--MENU--");
            System.out.println("1. VER MENU");
            System.out.println("2. HACER PEDIDO");
            System.out.println("3. VER PEDIDO");
            System.out.println("4. SALIR");
            System.out.println("Elige una opción");
           int opcion=entrada.nextInt();
           
            switch (opcion) {
                case 1:
                    System.out.println("\n MENU DE COMIDA");
                    for(int i=0; i<menu.size();i++){
                        System.out.println((i+1)+". "+menu.get(i)+" - $"+precios.get(i));
                    }
                    
                    break;
                case 2:
                    System.out.println("Seleccione el numero del plato que desea ordenar");
                    int seleccion=entrada.nextInt();
                    if(seleccion >0 && seleccion <=menu.size()){
                        pedido.add(menu.get(seleccion -1));
                        totalPedido.add(precios.get(seleccion -1));
                        System.out.println(menu.get(seleccion -1)+" añadido al pedido");
                    }
                    else{
                        System.out.println("Opción invalidad");
                    }
                    break;
                case 3:
                    //OPCIÓN PARA MOSTRAR EL PEDIDO ACTUAL Y CALCULAR EL TOTAL
                    System.out.println("\n PEDIDO");
                    double  total=0;
                    for (int i=0; i<pedido.size(); i++){
                        System.out.println((i+1)+". "+pedido.get(i)+" - $"+totalPedido.get(i));
                        total+=totalPedido.get(i); 
                    }
                    System.out.println("Total a pagar: "+total);
                    
                    break;
                case 4:
                    salir=true;
                    System.out.println("\n");
                    System.out.println("Gracias por tu compra!");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
           
        }
        
        entrada.close();
        
    }  
}