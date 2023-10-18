import java.util.ArrayList;

public class Pedido {
    ArrayList <Camisa> listaPedidos;
    Cliente cliente;
    float total;
    String tipoPago;


    public Pedido(ArrayList <Camisa> listaPedidos, Cliente cliente){
        this.listaPedidos = listaPedidos;
        this.cliente = cliente;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }
    public void setTotal(float total){
        this.total = total;
    }

    public float getTotal() {
        return total;
    }

    public float calcularTotal(ArrayList <Camisa> listaPedidos){
        float total = 0;
       for (Camisa camisa : listaPedidos){
           total = total + camisa.getPrecio();
       }
       return total;
    }

    public void mostrarResumenPedido(){
        cliente.mostrarInfo();
        System.out.println("Tipo de pago: " + this.getTipoPago());
        System.out.println("Total: " + this.getTotal());
        System.out.println("Gracias por comprar :)\n");
        System.out.println("Las camisas compradas son las siguientes: ");
        cliente.mostrarListaPedidos();
    }
}
