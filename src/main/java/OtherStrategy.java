import java.util.ArrayList;
import java.util.Comparator;
public class OtherStrategy implements Strategy {

    @Override
    public ArrayList<String> execute(ArrayList<ProductData.Product> productsCopy) {
        for (int j = 0; j < productsCopy.size()-1; j++){
            for (int i = j + 1; i < productsCopy.size(); i++) {
                if(productsCopy.get(j).getNameOfProduct().compareTo(productsCopy.get(i).getNameOfProduct()) == 0){
                    productsCopy.set(j, new ProductData.Product(productsCopy.get(j).getNameOfProduct() ,
                            "Coalition",
                            productsCopy.get(j).getCountOfProduct() + productsCopy.get(i).getCountOfProduct()));
                    productsCopy.remove(i); i--;
                }
                productsCopy.sort(Comparator.comparing(ProductData.Product::getNameOfProduct));
            }
        }
        productsCopy.sort(ProductData.Product::compareTo);
        ArrayList<String> product = new ArrayList<>();
        for (ProductData.Product s : productsCopy){
            product.add(s.getNameOfProduct());
        }
        return product;
    }

}