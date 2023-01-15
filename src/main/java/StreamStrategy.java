import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamStrategy implements Strategy {

    @Override
    public ArrayList<String> execute(ArrayList<ProductData.Product> productsCopy) {
        return productsCopy
                .stream()
                .collect(Collectors.groupingBy(ProductData.Product::getNameOfProduct))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream()
                                .mapToInt(ProductData.Product::getCountOfProduct)
                                .sum(),
                        (oldValue, newValue) -> oldValue, HashMap::new))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}