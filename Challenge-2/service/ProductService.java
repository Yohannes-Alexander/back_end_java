import java.util.HashMap;
import java.util.List;

public interface  ProductService {
    int getTotalProduct();
    int getTotalOrderList(int id);
    List<Product> getListMenu();
    HashMap<Integer, Order> getListOrder();
    void addOrder(int id);
    // void updateProduct(int id, int amount);
}
