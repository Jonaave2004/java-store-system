
import java.util.ArrayList;

public class Store{

    // la lista donde se van a guardar los productos que se van a utilizar
    ArrayList<Product> productsList;
    ArrayList<Customer> customerList;
    ArrayList<Order> orderList;

    // crea la lista donde se van a guardar
    // asi cada que se cree una store , va a tener su propia lista de productos 
    public Store() {
        productsList = new ArrayList<Product>();
        customerList = new ArrayList<Customer>();
        orderList = new ArrayList<Order>(); 
    }


    // toma los datos de el producto y lo anade a la lista 
    public void addProduct(Product product){
        productsList.add(product);
          
    }

    // por cada Product llamado currentProduct dentro de productList haz esto 
    public void showProduct(){
        for(/*tipo de variable*/ Product /*nombre de la variable*/  currentProduct : /*coleccion*/ productsList){
            currentProduct.show();
        }
    }

    // aqui miramos si el id que ponemos en producto no esta ya 
    public boolean productExist(String id){
        for(Product currentProduct : productsList){
            if(id.equals(currentProduct.ID)){
                return true;
            }
        }
        return false;
    }

    public void addCustomer(Customer customer ){
        customerList.add(customer);
    }

    public void showCustomer(){
        for(Customer currentCustomer : customerList){
            currentCustomer.show();
        }
    }
    // aqui busca que el id que me dieron en el main se paresca a alguno que tengo guardado en customer
    public Customer findCustomer(String id){
        for(Customer currentCustomer : customerList){
            if(id.equals(currentCustomer.ID)){
                return currentCustomer;
            }
        }
        return null;
    }

    public Product findProduct(String id){
        for (Product currentProduct : productsList) {
            if(id.equals(currentProduct.ID)){
                return currentProduct;
            }
        }
        return null;
    }

    public void addOrder(Order order){
        orderList.add(order);
    }
    // aqui muestra toda las ordenes guardadas
    public void showOrder(){
        for(Order currentOrder: orderList){
            currentOrder.show();
        }
    }

    public Order findOrder(String id){
        for(Order currentOrder : orderList){
            if(id.equals(currentOrder.ID)){
                return currentOrder;
            }
        }
        return null;
    }

    public void showEspecificOrder(Order order){
        order.show();
    }


}