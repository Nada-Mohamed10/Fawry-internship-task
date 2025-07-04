import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    public Cart()
    {
        this.items=new ArrayList<>();
    }

    public void addToCart(Product product  , int quantity)
    {
        if(quantity > product.getQuantity())
        {
            throw  new IllegalArgumentException("Quantity exceeds stock for " + product.getName() + " Available quantity: " + product.getQuantity() );
        }
        items.add(new CartItem(product ,quantity));
    }

    public List<CartItem> getItems()
    {
        return items;
    }

    public boolean isEmpty()
    {
        return  items.isEmpty();
    }

    public double calcSubtotal()
    {
        double subTotal=0;
        for(CartItem item :items)
        {
            subTotal+=item.getTotalPrice();
        }
        return  subTotal;
    }

    public List<Shippable> getShippable()
    {
      List<Shippable> shippables=new ArrayList<>();
      for(CartItem item :items)
      {
          Product product=item.getProduct();
          if(product instanceof  Shippable)
          {
              for(int i=0;i<item.getQuantity() ;i++)
              {
                  shippables.add((Shippable) product);
              }
          }
      }
      return shippables;
    }


}
