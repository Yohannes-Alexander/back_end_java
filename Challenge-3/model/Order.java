import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order {
    private int id;
    private LocalDate date;
    private String destination_address;
    private List<OrderDetail> itemOrderList;
    private User user;
    private boolean completed;

    public Order(int id, String destination_address, User user){
        this.id=id;
        this.date=LocalDate.now();
        this.itemOrderList = new ArrayList<>();
        this.user = user;
        this.destination_address = destination_address;
        this.completed = false;
    }
    public void setItemOrderList(OrderDetail orderDetail){
    // Check if the product already exists in the itemOrderList
    Optional<OrderDetail> existingOrderDetail = itemOrderList.stream()
    .filter(od -> od.getProduct().equals(orderDetail.getProduct()))
    .findFirst();

    if (existingOrderDetail.isPresent()) {
    // If the product exists, remove the old entry
        itemOrderList.remove(existingOrderDetail.get());
    }
        this.itemOrderList.add(orderDetail);
    }

    public List<OrderDetail> getItemOrderList(){
        return this.itemOrderList;
    }
}
