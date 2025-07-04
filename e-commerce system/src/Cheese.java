import java.time.LocalDate;

public class Cheese extends Product implements Expirable , Shippable
{
  private LocalDate expireDate;
  private double weight;
  public Cheese(String name , double price , int quantity , LocalDate expireDate , double  weight)
  {
   super(name , price , quantity);
   this.expireDate=expireDate;
   this.weight=weight;
  }
    @Override
    public boolean isExpire() {
      return expireDate.isBefore(LocalDate.now());
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName()
    {
        return  super.getName();
    }
}
