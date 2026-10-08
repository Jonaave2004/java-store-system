
import java.util.ArrayList;

public class Order extends DatosPersonales implements AddInterface{

    Customer customer;
    ArrayList<Product> productList;


    public Order(String ID, Customer customer, ArrayList<Product> productList) {
        super(ID);
        this.customer = customer;
        this.productList = productList;
    }

    @Override 
    public void show(){
        System.out.println("====== ORDER ======");
        System.out.println("Order ID: " + ID);
        System.out.println();

        System.out.println("Customer: ");
        customer.show();
        System.out.println();

        System.out.println("Products: ");
        for (Product currentProduct : productList) {
            System.out.println(currentProduct.getName() + " - $" + currentProduct.getPrecio() );
        }

        System.out.println("Total: $" + calcularTotal());
        
    }

    public double calcularTotal(){
        double total = 0;

        // busca el getter para obtener el precio de el producto , y lo pone en el total , asi que cada que pase el for se van a sumar 
        for ( Product currentProduct : productList) {
            total += currentProduct.getPrecio();  
        }
        return total;
    }

}
