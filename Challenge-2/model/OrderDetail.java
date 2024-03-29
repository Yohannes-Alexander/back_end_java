import java.util.UUID;

public class OrderDetail {
    private String id;
    private Product product;
    private int amount;

    public OrderDetail(Product product, int amount){
        this.id = UUID.randomUUID().toString();
        this.product = product;
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }
    public Product getProduct(){
        return product;
    }
}
