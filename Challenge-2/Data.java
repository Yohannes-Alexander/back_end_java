import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    public static List<Product> menuProduct = new ArrayList<>();
    public static HashMap<Integer, Order> order = new HashMap<>();
//    public static Set<Product> productSet = new TreeSet<>();

    public static void initiateProduct(){

        Product product1 = new Product(1,"Nasi Goreng", 15000);
        Product product2 = new Product(2,"Mie Goreng", 13000);
        Product product3 = new Product(3,"Nasi + Ayam", 18000);
        Product product4 = new Product(4,"Es Teh Manis", 13000);
        Product product5 = new Product(5,"Es Jeruk", 5000);

        menuProduct.add(product1);
        menuProduct.add(product2);
        menuProduct.add(product3);
        menuProduct.add(product4);
        menuProduct.add(product5);
    }
}
