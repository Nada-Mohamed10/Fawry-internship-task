import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Shipping {
    public static void shipItems(List<Shippable> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("** No items to ship **");
            return;
        }

        System.out.println("** Shipment notice **");

        Map<String, Integer> itemCounts = new LinkedHashMap<>();
        Map<String, Double> itemWeights = new LinkedHashMap<>();

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            itemCounts.put(name, itemCounts.getOrDefault(name, 0) + 1);
            itemWeights.putIfAbsent(name, weight);
        }

        for (String name : itemCounts.keySet()) {
            int qty = itemCounts.get(name);
            int weightInGrams = (int)(itemWeights.get(name) * 1000);
            System.out.printf("%-15s %5sg\n", qty + "x " + name, weightInGrams);
        }

        double totalWeight = 0;
        for (double weight : itemWeights.values()) {
            totalWeight += weight;
        }
        System.out.printf(Locale.US,"Total package weight %.1fkg\n", totalWeight);
    }
}
