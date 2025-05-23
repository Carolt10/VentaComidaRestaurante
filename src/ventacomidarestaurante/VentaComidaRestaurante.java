
package ventacomidarestaurante;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author santir
 */
public class VentaComidaRestaurante {

    public static void main(String[] args) {
        List<String> menu = new ArrayList<>();
        List<Double> precios = new ArrayList<>();

        // Añadimos platos al menú
        menu.add("Hamburguesa");
        precios.add(10.0);

        menu.add("Pizza");
        precios.add(8.25);

        menu.add("Ensalada");
        precios.add(4.15);

        // Listas para guardar el pedido del cliente
        List<String> pedido = new ArrayList<>();
        List<Double> totalPedido = new ArrayList<>();
        List<Integer> cantidades = new ArrayList<>();
        
        // Información de la empresa
        String nombreEmpresa = "Restaurante Sabor Tolimense";
        String telefonoEmpresa = "Tel: 300-123-4567";
        String direccionEmpresa = "Dirección: Calle 64 #45-67, Ciudad Ibague";

        // Scanner para entrada del usuario
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
             // Mostrar datos de la empresa en cada iteración
            System.out.println("\n=============================");
            System.out.println(nombreEmpresa);
            System.out.println(telefonoEmpresa);
            System.out.println(direccionEmpresa);
            System.out.println("=============================");
            
            // Menú de opciones
            System.out.println("\n--MENU--");
            System.out.println("1. VER MENU");
            System.out.println("2. HACER PEDIDO");
            System.out.println("3. ELIMINAR PEDIDO");
            System.out.println("4. VER PEDIDO");
            System.out.println("5. SALIR");
            System.out.print("\n Elige una opción: ");
            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n MENU DE COMIDA");
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println((i + 1) + ". " + menu.get(i) + " - $" + precios.get(i));
                    }
                    break;

                case 2:
                    System.out.println("SELECCIONA EL NÚMERO DEL PLATO QUE DESEAS:");
                    int seleccion = entrada.nextInt();

                    if (seleccion > 0 && seleccion <= menu.size()) {
                    System.out.print("¿Cuántas unidades deseas?: ");
                    int cantidad = entrada.nextInt();

                    if (cantidad > 0) {
                    pedido.add(menu.get(seleccion - 1));
                    double subtotal = precios.get(seleccion - 1) * cantidad;
                    totalPedido.add(subtotal);
                    cantidades.add(cantidad);

                    System.out.println(cantidad + " x " + menu.get(seleccion - 1) + " se han añadido al pedido.");
                    } else {
                    System.out.println("Cantidad inválida.");
                    }
                    } else {
                    System.out.println("Opción inválida");
                    }
                    break;

                case 3:
                    if (pedido.isEmpty()) {
                        System.out.println("No hay productos en el pedido para eliminar.");
                        break;
                    }

                    System.out.println("SELECCIONA EL NÚMERO DEL PRODUCTO DEL PEDIDO A ELIMINAR:");
                    for (int i = 0; i < pedido.size(); i++) {
                        System.out.println((i + 1) + ". " + pedido.get(i));
                    }
                    int eliminar = entrada.nextInt();
                    if (eliminar > 0 && eliminar <= pedido.size()) {
                        System.out.println(pedido.get(eliminar - 1) + " *Se ha eliminado del pedido*");
                        pedido.remove(eliminar - 1);
                        totalPedido.remove(eliminar - 1);
                        cantidades.remove(eliminar - 1);
                    } else {
                        System.out.println("Opción inválida");
                    }
                    break;

                case 4:
                    System.out.println("\n PEDIDO ACTUAL");
                    double total = 0;
                    for (int i = 0; i < pedido.size(); i++) {
                        System.out.println((i + 1) + ". " + cantidades.get(i) + " x " + pedido.get(i) + " - $" + totalPedido.get(i));
                        total += totalPedido.get(i);
                    }
                    System.out.println("Total a pagar: $" + total);
                    break;

                case 5:
                    if (pedido.isEmpty()) {
                        System.out.println("No hay productos en el pedido. Gracias por visitarnos.");
                        salir = true;
                        break;
                    }

                    // Mostrar resumen del pedido
                    double totalFinal = 0;
                    System.out.println("\n--- RESUMEN DE PEDIDO ---");
                    for (int i = 0; i < pedido.size(); i++) {
                        System.out.println((i + 1) + ". " + cantidades.get(i) + " x " + pedido.get(i) + " - $" + totalPedido.get(i));
                        totalFinal += totalPedido.get(i);
                    }

                    // Registro de la hora del pedido (HH:mm:ss)
                    LocalTime horaPedido = LocalTime.now();
                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String horaFormateada = horaPedido.format(formatoHora);
                    System.out.println("");
                    System.out.printf("TOTAL A PAGAR: $%.2f\n", totalFinal);
                    System.out.println("Hora del pedido: " + horaFormateada);  // ← Hora del pedido

                    // Método de pago
                    System.out.println("\nSeleccione el método de pago:");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Transferencia");
                    System.out.print("Opción: ");
                    int metodoPago = entrada.nextInt();

                    if (metodoPago == 1) {
                        // Pago en efectivo
                        System.out.print("Ingrese la cantidad con la que va a pagar: $");
                        double efectivo = entrada.nextDouble();
                        if (efectivo >= totalFinal) {
                            double cambio = efectivo - totalFinal;
                            System.out.printf("Pago recibido. Su cambio es: $%.2f\n", cambio);
                            System.out.println("Gracias por su compra en efectivo. ¡Vuelva pronto!");
                        } else {
                            System.out.println("Fondos insuficientes. No se puede completar el pago.");
                            break;
                        }
                    } else if (metodoPago == 2) {
                        // Simular transferencia
                        System.out.println("\n** DATOS PARA TRANSFERENCIA **");
                        System.out.println("Banco: Bancolombia");
                        System.out.println("Cuenta: 123456789");
                        System.out.println("Titular: Restaurante Buen Sabor");
                        System.out.println("Por favor, realice la transferencia y muestre el comprobante al cajero.");
                        System.out.println("Gracias por su compra por transferencia. ¡Vuelva pronto!");
                    } else {
                        System.out.println("Método de pago no válido.");
                        break;
                    }

                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        entrada.close();
    }
}