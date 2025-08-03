import java.util.Map;

public record TypeChange(String result,
                         String base_code,
                         Map<String, Double> conversion_rates) {

    public double convertQuantity(double quantity, String target) {
        return quantity*conversion_rates.get(target);
    }
}
