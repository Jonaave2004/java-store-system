
public class Customer extends DatosPersonales implements AddInterface {


    String name;

    public Customer(String ID, String name) {
        super(ID);
        this.name = name;
    }

    @Override 
    public void show(){
        System.out.println("ID: "+ ID );
        System.out.println("Name: "+ name);
    }

   

    
    
}
