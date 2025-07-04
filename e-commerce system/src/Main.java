import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
    Customer customer=new Customer("Nada" ,1000);
    Cart cart=new Cart();
    Product cheese=new Cheese("cheese" ,100,2, LocalDate.of(2025,10,10) , 0.4);
    Product biscuits=new Biscuits("Biscuits" , 150,1,LocalDate.of(2025,12,1),0.7);
    cart.addToCart(cheese,2);
    cart.addToCart(biscuits,1);
    Checkout.checkout(customer,cart);

    }
}