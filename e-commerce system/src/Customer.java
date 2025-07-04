public class Customer {

    private String name;
    private double money;

    public Customer(String name , double money)
    {
        this.name=name;
        this.money=money;
    }

    public String getName()
    {
         return  name;
    }
    public double getMoney()
    {
        return  money;
    }

    public boolean isCanPay(double paymoney)
    {
      if(paymoney > money)
      {
          return false;
      }
      return true;
    }

    public void  withdrawMoney(double paymoney )
    {
        if(isCanPay(paymoney))
        {
          money-=paymoney;

        }
        else
        {
            System.out.println("Insufficient Money");
        }
    }

}
