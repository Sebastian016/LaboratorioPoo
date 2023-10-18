import java.util.ArrayList;

public class Cliente {
    String correo;
    String nombre;
    ArrayList <Camisa> listaPedidos;

    public Cliente(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
        this.listaPedidos = new ArrayList<>();
    }

    public ArrayList<Camisa> getListaPedidos(){
        return listaPedidos;
    }

    public void mostrarInfo(){
        System.out.println("**Datos del cliente**");
        System.out.println("Nombre: "+ this.nombre);
        System.out.println("Correo: "+ this.correo);
    }

    public void agregarPedido(ArrayList <Camisa> catalogo, int id){
        for (Camisa camisa : catalogo){
            if(camisa.getId() == id){
               this.listaPedidos.add(camisa);
                System.out.println("Ahora la camisa con el identificador "+id + " esta en tu lista de pedidos");
               return;
            }
        }
        System.out.println("No se encontro ninguna camisa con ese id :(");
    }

    public void elimiarPedido(ArrayList <Camisa> catalogo, int id){
        for (Camisa camisa : catalogo){
            if(camisa.getId() == id){
                this.listaPedidos.remove(camisa);
                System.out.println("Se ha borrado la camisa con "+id + " de tu lista de pedidos");
                return;
            }
        }
        System.out.println("No se encontro ninguna camisa con ese id :(");
    }


    public void mostrarListaPedidos(){
        for(Camisa camisa : this.getListaPedidos()){
            camisa.mostrarInfo();
        }
    }


}
