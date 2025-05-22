/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventacomidarestaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author carot
 */
public class VentaComidaRestaurante {

    public static void main(String[] args) {
        List<String> menu = new ArrayList<>();
        List<Double> precios = new ArrayList<>();

        // add añadimos platos al menu

        menu.add("Hamburguesa");
        precios.add(10.0);

        menu.add("Pizza");
        precios.add(8.25);

        menu.add("Ensalada");
        precios.add(4.15);

        // inicializamos las lsitas para guardar el pedido del cliente
        List<String> pedido = new ArrayList<>();
        List<Double> totalPedido = new ArrayList<>(); // cuanto s ele cobrara a la persona

        // creamos un scanner para leer la entrada del usuario
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            // menu de opciones
            System.out.println("\n--MENU--");
            System.out.println("1. VER MENU");
            System.out.println("2. HACER PEDIDO");
            System.out.println("3. ELIMINAR PEDIDO");
            System.out.println("4. VER PEDIDO");
            System.out.println("5. SALIR");
            System.out.println("\n Elige una opción:");
            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n MENU DE COMIDA");
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println((i + 1) + ". " + menu.get(i) + "- $" + precios.get(i));
                    }
                    break;
                case 2:
                    System.out.println("SELECCIONA EL NUMERO DEL PLATO QUE DESEAS");
                    int seleccion = entrada.nextInt();
                    if (seleccion > 0 && seleccion <= menu.size()) {
                        pedido.add(menu.get(seleccion - 1));
                        totalPedido.add(precios.get(seleccion - 1));
                        System.out.println(menu.get(seleccion - 1) + " ***Se ha añadido al pedido");

                    } else {
                        System.out.println("Opcion invalida");
                    }
                    break;
                case 3:
                    System.out.println("SELECCIONA EL NUMERO DEL PLATO A ELIMINAR");
                    int seleccionn = entrada.nextInt();
                    if (seleccionn > 0 && seleccionn <= menu.size()) {
                        pedido.remove(menu.get(seleccionn - 1));
                        totalPedido.remove(precios.get(seleccionn - 1));
                        System.out.println(menu.get(seleccionn - 1) + " ***Se ha eliminado el producto");

                    } else {
                        System.out.println("Opcion invalida");
                    }
                    break;
                case 4:
                    // opcion para mostrar el pedido actual y calcular el total
                    System.out.println("\n PEDIDO");
                    double total = 0;
                    for (int i = 0; i < pedido.size(); i++) {
                        System.out.println((i + 1) + ". " + pedido.get(i) + " - $" + totalPedido.get(i));
                        total += totalPedido.get(i);

                    }
                    System.out.println("Total a pagar: " + total);
                    break;
                case 5:
                    salir = true;
                    System.out.println("***Gracias por tu compra***");
                    break;

                default:
                    System.out.println(" opcion no valida");
                    break;

            }
        }
        entrada.close();
    }
}
