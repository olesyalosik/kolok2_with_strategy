import java.util.ArrayList;
import java.awt.List;

public interface Strategy{
    public ArrayList<String> execute(ArrayList<ProductData.Product> productsCopy) throws CloneNotSupportedException;
}