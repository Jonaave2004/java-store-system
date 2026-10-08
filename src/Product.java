public class Product extends DatosPersonales implements AddInterface {

    String name;
    double precio;
    int cantidad;


    public Product(String ID, String name, double precio, int cantidad) {
        super(ID);
        this.name = name;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public void show() {
        System.out.println();
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Price: " + precio);
        System.out.println("Quantity: " + cantidad);
        System.out.println();
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        
    }

    
    
}
