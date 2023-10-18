import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Admin {
    public Admin(){}

    public Camisa registrarCamisa(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Ingresa el color de la camisa: ");
        String color = scanner.next();

        System.out.println("Ingresa precio de la camisa: ");
        int precio = scanner.nextInt();

        System.out.println("Ingresa la talla de la camisa: ");
        String talla = scanner.next();

        System.out.println("Ingresa una descripcion de la camisa: ");
        String descripcion = scanner.next();
        Camisa camisa = new Camisa(precio, talla, color, descripcion);
        int id = random.nextInt(200000);
        camisa.setId(id);

        return camisa;
    }

    public void añadirAlCatalogo(ArrayList <Camisa> catalogo, Camisa camisa){
        catalogo.add(camisa);
    }
}
