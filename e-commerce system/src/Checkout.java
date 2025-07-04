import java.util.List;
import java.util.Locale;

public class Checkout {

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new RuntimeException(" Cart is empty");
        }

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product instanceof Expirable) {
                Expirable exp = (Expirable) product;
                if (exp.isExpire()) {
                    throw new RuntimeException(" Product expired: " + product.getName());
                }
            }

            if (item.getQuantity() > product.getQuantity()) {
                throw new RuntimeException(" Not enough quantity for: " + product.getName());
            }
        }

        double subtotal = cart.calcSubtotal();

        List<Shippable> shippables = cart.getShippable();
        double shippingFee = shippables.size() * 10.0;

        double total = subtotal + shippingFee;

        if (!customer.isCanPay(total)) {
            throw new RuntimeException(" Customer does not have enough balance.");
        }
        customer.withdrawMoney(total);

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        if (!shippables.isEmpty()) {
            Shipping.shipItems(shippables);
        }
         System.out.println();
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf(Locale.US,"%-18s %5d\n", item.getQuantity() + "x " + item.getProduct().getName(),
                    (int)(item.getProduct().getPrice() * item.getQuantity()));

        }
        System.out.println("----------------------");
        System.out.printf(Locale.US,"%-15s %d\n", "Subtotal", (int) subtotal);
        System.out.printf(Locale.US,"%-15s %d\n", "Shipping", (int) shippingFee);
        System.out.printf(Locale.US,"%-15s %d\n", "Amount", (int) total);

    }
}
