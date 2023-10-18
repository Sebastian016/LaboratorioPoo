public class Camisa {
    //Propiedades del objeto camisa
    int id;
    String color;
    String talla;
    String descripcion;
    int precio;

    //Constructor
    public Camisa(int precio, String talla, String color, String descripcion){
        this.precio = precio;
        this.talla = talla;
        this.color = color;
        this.descripcion = descripcion;
    }

    //Getters y setters

    public int getId() {
        return id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setId(int id){
        this.id = id;
    }

    //Metodos
    public void mostrarInfo(){
        System.out.println("Color: " + this.color);
        System.out.println("Talla: "+ this.talla);
        System.out.println("Precio: "+ this.precio);
        System.out.println("Descripcion: " + this.descripcion);
        System.out.println("Id: "+  this.id);
        System.out.println("\n");
    }
}
