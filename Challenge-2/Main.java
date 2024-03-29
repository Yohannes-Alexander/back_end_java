import java.util.UUID;
public class Main {
    public static void main(String[] args) {
        Data.initiateProduct();
        ProductController prodControl = new ProductController();
        prodControl.orderApp();

    }
}
