public class Product {
    protected   String name;
    protected   double price;
    protected   int quantity;

    public Product(String name , double price , int quantity)
    {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    public String getName()
    {
        return name;
    }
    public double getPrice()
    {
        return price;
    }

    public void setQuantity(int quantity)
    {
        this.quantity= quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void reduceQuantity(int amount)
    {
        if (amount > quantity)
        {
            throw  new IllegalArgumentException("Insufficient stock for " + name);
        }
        this.quantity -= amount;
    }

}
