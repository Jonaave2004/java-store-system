
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        
        /*try{
            Scanner testScanner = new Scanner(new File("testData.txt"));
            System.out.println(testScanner.nextLine());

        }catch(FileNotFoundException e){
            System.out.println("not found file");
        }*/

        int option = 0;

        while (option !=  7) { 
            System.out.println("====== MENU OPTIONS ======");
            System.out.println("1. Add Product ");
            System.out.println("2. Show Products");
            System.out.println("3. Add Customer");
            System.out.println("4. Show Customers");
            System.out.println("5. Create Order");
            System.out.println("6. Show Order");
            System.out.println("7. Exit");  

            System.out.println("Choose an option");
            option = scanner.nextInt();
            scanner.nextLine();

        

            switch (option) {
                case 1: 
                    addProductToStore(store, scanner);
                    break;
                case 2:
                    showStoreProducts(store);
                    break;
                
                case 3:
                    addCustomerToStore(store, scanner);
                    break;
                
                case 4:
                    showStoreCustomers(store);
                    break;

                case 5: 
                    createOrder(store, scanner);
                    break;

                case 6:
                    showSpecificOrder(store, scanner);
                    break;
                
                case 7:
                    System.out.println("Goodbye!");
                    break;

            }
        }
            
        
    }

    public static void addProductToStore(Store store,Scanner scanner ){
        System.out.println("====== ADD PRODUCT ======");

        // este do - while se utiliza para que no se repitan los id , si no que en caso de que pase , le haga volver a poner uno diferente
        String id;
        boolean productIdSearch;
                    
        do { 
            System.out.println("Enter product ID: ");
            id = scanner.nextLine();

            productIdSearch = store.productExist(id);

            if(productIdSearch){
                System.out.println("Product ID already Exists , try again ");
            }
                        
        } while(productIdSearch);
                     
                    
        System.out.println("Enter product name : ");
        String name = scanner.nextLine();

                    
        double price = 0 ;
        boolean validPrice;

        // aqui se hace el while para que no pongan precio negativo o algo que no sea un numero
        do { 
            System.out.println("Enter Product price: ");
                        
            // este try es para cuando la gente no pone un numero si no un string , entonces lo que hace es que le diga que es invalido y no acabe el programa si no que lo vuelva a intentar 
            try {
                price = scanner.nextDouble();
                validPrice = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid price, try again");
                scanner.nextLine();
                validPrice = false;
            }
            // este es que mire lo del precio solo si pusieron un double 
            if(validPrice){
                if(price < 0){
                    System.out.println("Price cant be negative ");
                }
            }

        } while (price < 0 || validPrice == false);

        // este igual que con el precio se hace para que no pongan cantidad negativa o que no pongan un entero 
        int stock = 0;
        boolean validStock;

        do { 
            System.out.println("Enter stock: ");

            try {
                stock = scanner.nextInt();
                validStock = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid stock, try again ");
                scanner.nextLine();
                validStock = false;

            }
            if(validStock){
                scanner.nextLine();
                if(stock < 0){
                    System.out.println("Stock cant be negative");
                }
            }
        } while (stock < 0 || !validStock);
                   

        Product product1 = new Product(id, name, price,stock);
        store.addProduct(product1);

        System.out.println("Product added sucessfully");
        System.out.println();
    }

    public static void showStoreProducts(Store store){
        System.out.println("====== PRODUCTS ======");
        store.showProduct();
        System.out.println();
    }

    public static void addCustomerToStore(Store store, Scanner scanner){
        System.out.println("====== ADD CUSTOMER ======"); 
        System.out.println("Enter Customer ID: ");
        String idCustomer = scanner.nextLine();

        System.out.println("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        Customer customer1 = new Customer(idCustomer, customerName);
        store.addCustomer(customer1);

        System.out.println("Customer added succesfully");
        System.out.println();
    }

    public static void showStoreCustomers(Store store){
        System.out.println("====== CUSTOMERS ======");
        store.showCustomer();
        System.out.println();
    }

    public static void createOrder(Store store, Scanner scanner){
       System.out.println("====== CREATE ORDER ======"); 
                    
       System.out.println("Enter order ID: ");
        String orderID = scanner.nextLine();

        System.out.println("Search Customer ID: ");
        String customerID = scanner.nextLine();

            Customer customer = store.findCustomer(customerID);

        if(customer == null){
            System.out.println("Customer not found");
            return;
        }
                    
        // creamos una lista donde se guarden los productos que va a querer en la orden 
        ArrayList<Product> orderProducts = new ArrayList<>();

        store.showProduct();

        String another = "yes";

        while(another.equals("yes")){
            System.out.println("Enter product ID: ");
            String productID = scanner.nextLine();

            Product product = store.findProduct(productID);
                        
            // si no encuentra el producto  
            if(product == null){
                System.out.println("Product not found");
                System.out.println();
                continue;

            }
            // si la cantidad es 0 o menor , osea no hay 
            if(product.getCantidad() <= 0){
            System.out.println(" No stock available ");
            System.out.println();
            continue;
            }

            // esto es para que cada que yo agregue un producto a la orden me borre uno de la cantidad que hay 
            product.setCantidad(product.getCantidad() - 1);

            orderProducts.add(product);
            System.out.println();

            System.out.println("Add another product? (yes/no)");
            another= scanner.nextLine();
                        
        }
        
        Order order1 = new Order(orderID, customer, orderProducts);
        store.addOrder(order1);
 
        System.out.println("Order created sucessfully");
    }

    public static void showSpecificOrder(Store store , Scanner scanner){
        System.out.println("Please enter the order ID: ");
        String orderFindId = scanner.nextLine();

        Order orderfound = store.findOrder(orderFindId);

        if(orderfound == null){
            System.out.println("Order not found");
            return;
        }

        store.showEspecificOrder(orderfound);
        System.out.println();

    }
}

    
