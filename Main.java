import java.util.Scanner;
import java.util.ArrayList;
//{}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Camisa> catalogo = new ArrayList<>();
        int opcion;

        do {
            System.out.println("***Menu***");
            System.out.println("1) Para añadir camisas al catalogo(admin)");
            System.out.println("2) Para comprar camisas (cliente)");
            System.out.println("3) Salir");
            System.out.println("Selecciona una opcion: ");
            opcion = scanner.nextInt();

            if (opcion == 1){
                Admin adminSistema = new Admin();
                System.out.println("Cuantas camisas deseas agregar: ");
                int numCamisas = scanner.nextInt();

                for(int i = 1; i <= numCamisas; i++){
                    System.out.println("***Camisa " + i + "***");
                    Camisa camisa = adminSistema.registrarCamisa();
                    adminSistema.añadirAlCatalogo(catalogo,camisa);
                }
                System.out.println("Las camisas se han añadido al catalogo");
            }

            if (opcion == 2){

                System.out.println("**Datos del cliente**");
                System.out.println("Ingresa tu correo: ");
                String correo = scanner.next();
                System.out.println("Ingresa tu nombre: ");
                String nombre = scanner.next();
                Cliente cliente = new Cliente(nombre, correo);

                do{
                    System.out.println("**Menu cliente**");
                    System.out.println("1) Agregar playera a la lista de compras");
                    System.out.println("2) Eliminar playera de la lista de compras");
                    System.out.println("3) Mostrar lista de pedidos");
                    System.out.println("4) Comprar lista de pedidos");
                    System.out.println("5) Salir");
                    System.out.println("Ingresa una opcion: ");
                    opcion = scanner.nextInt();


                    if (opcion == 1){
                        if (!catalogo.isEmpty()){
                            System.out.println("El catalogo disponible es el siguiente: ");
                            for (Camisa camisa : catalogo){
                                camisa.mostrarInfo();;
                            }

                            System.out.println("Selecciona por id la camisa que quieras comprar: ");
                            int idCamisa = scanner.nextInt();
                            cliente.agregarPedido(catalogo, idCamisa);
                        }
                    }

                    if (opcion == 2){
                        if(!cliente.getListaPedidos().isEmpty()){
                            System.out.println("Selecciona por id la camisa que quieras eliminar: ");
                            int idCamisa = scanner.nextInt();
                            cliente.elimiarPedido(catalogo,idCamisa);
                        } else {
                            System.out.println("La lista de pedidos esta vacia");
                        }
                    }

                    if (opcion == 3){
                        if(!cliente.getListaPedidos().isEmpty()){
                            System.out.println("Tu lista de pedidos es la siguiente: ");
                            cliente.mostrarListaPedidos();
                        }else {
                            System.out.println("La lista de pedidos esta vacia :(");
                        }
                    }

                    if(opcion == 4){
                        if(!cliente.getListaPedidos().isEmpty()){
                            Pedido pedido = new Pedido(cliente.getListaPedidos(), cliente);

                            System.out.println("Tipo de pago");
                            System.out.println("1) Cheque");
                            System.out.println("2) Tarjeta de credito");
                            System.out.println("Selecciona una opcion: ");
                            int metodoPago = scanner.nextInt();

                            if (metodoPago == 1){
                                pedido.setTipoPago("Cheque");
                            } else {
                                pedido.setTipoPago("Tarjeta de credito");
                            }

                            pedido.setTotal(pedido.calcularTotal(cliente.getListaPedidos()));
                            System.out.println("**Resumen del pedido**\n");
                            pedido.mostrarResumenPedido();
                            opcion = 5;
                        } else {
                            System.out.println("La lista de pedidos esta vacia :(");
                        }
                    }


                }while (opcion != 5);

            }
        } while (opcion != 3);



    }
}

