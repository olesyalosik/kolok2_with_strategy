import java.io.File;
import java.io.IOException;
import java.util.*;

public class ProductData {

    ArrayList<Product> products;

    @Override
    public String toString() {
        return "Data{" + products.toString() +"}";
    }

    ProductData() {
        products = new ArrayList<>();
    }

    static class Product implements Comparable<Product> {
        private final String nameOfProduct;
        private final String countryOfProduct;
        private final int countOfProduct;

        public String getNameOfProduct() {
            return nameOfProduct;
        }

        public String getCountryOfProduct() {
            return countryOfProduct;
        }

        public int getCountOfProduct() {
            return countOfProduct;
        }

        Product(String nameOfProduct, String countryOfProduct, int countOfProduct) {
            this.nameOfProduct = nameOfProduct;
            this.countryOfProduct = countryOfProduct;
            this.countOfProduct = countOfProduct;
        }

        @Override
        public String toString() {
            return "{" + nameOfProduct + ", " +
                    countryOfProduct + ", " +
                    countOfProduct + "}\n";
        }


        @Override
        public int compareTo(Product o) {
            return countOfProduct - o.countOfProduct;
        }


    }
    public void readData(File file) throws IOException {
        if (!products.isEmpty()){
            products.clear();
        }
        Scanner input = new Scanner(file);
        if (!input.hasNextInt()) {
            throw new IOException("file hasn't count of products");
        }
        int size = Integer.parseInt(input.nextLine());
        for (int i = 0; i < size; i++) {
            if (!input.hasNextLine()) {
                throw new IOException("file hasn't enough product descriptions");
            }
            String nameOfProduct = input.nextLine();
            if (!input.hasNextLine()) {
                throw new IOException("last product description has only name");
            }
            String countryOfProduct = input.nextLine();
            if (!input.hasNextInt()) {
                throw new IOException("in product description count of products is invalid");
            }
            int countOfProduct = Integer.parseInt(input.nextLine());
            products.add(new Product(nameOfProduct, countryOfProduct, countOfProduct));
        }
        if (input.hasNext()) {
            throw new IOException("file has extra data");
        }
    }

    public void addProduct(String nameOfProduct, String countryOfProduct, int countOfProduct) {
        products.add(new Product(nameOfProduct, countryOfProduct, countOfProduct));
    }
}