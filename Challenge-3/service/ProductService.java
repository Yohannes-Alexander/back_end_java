import java.util.HashMap;
import java.util.List;

public interface  ProductService {
    int getTotalProduct();
    int getTotalOrderList(int id);
    List<Product> getListMenu();
    void addOrder(int id, String destination_order, User user);
    // void updateProduct(int id, int amount);
}
